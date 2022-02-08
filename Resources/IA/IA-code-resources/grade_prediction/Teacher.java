/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import java.util.*;
import java.io.*;

/**
 *
 * @author sameer
 */
public class Teacher extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Class> classes = new ArrayList<Class>();

    public Teacher(String firstname, String surname, String schoolName, int id) {
        super(firstname, surname, schoolName, id);
    }

    public ArrayList<Class> getClasses() {
        return this.classes;
    }

    public void sortClasses(int setting) {

        int csp = 0;
        while (csp < this.classes.size()) {
            int i = csp;
            Class se = this.classes.get(i);
            int j = i + 1;
            while (j < this.classes.size()) {

                switch (setting) {

                    //sort by ID
                    case (0):
                        if (this.classes.get(j).getID() < se.getID()) {
                            i = j;
                            se = this.classes.get(j);
                        }
                        break;

                    //sort by subject name 
                    case (1):
    if (this.classes.get(j).getClassSubject().getSubjectName().compareToIgnoreCase(se.getClassSubject().getSubjectName()) < 0) {
                            i = j;
                            se = this.classes.get(j);
                        }
                        break;

                }
                j++;
            }
            this.classes.set(i, this.classes.get(csp));
            this.classes.set(csp, se);
            csp++;
        }

    }

    public boolean addClass(Class c) {
        this.classes.add(c);
        sortClasses(0);
        return true;
    }

    public boolean removeClass(int classId) {
        ArrayList<Student> students = new ArrayList<Student>();
        for (Class c : this.classes) {
            if (c.getID() == classId) {
                for (Student s : c.getClassStudents()) {
                    students.add(s);

                }

            }
        }

        for (Class c : this.classes) {
            if (c.getID() == classId) {
                for (Student s : students) {

                    c.removeStudent(s.getID());

                }

                return this.classes.remove(c);
            }
        }
        return false;

    }

    public void viewClassGrades(int classID) {
        for (Class c : this.classes) {
            if (c.getID() == classID) {
                for (Student s : c.getClassStudents()) {
                    System.out.println(s.getFirstname() + "  -->   " + s.getGrades(c));
                }
            }
        }

    }

    public Student findStudent(int id) {

        for (Class c : this.classes) {
            for (Student s : c.getClassStudents()) {
                if (s.getID() == id) {
                    return s;
                }
            }
        }

        return null;

    }

    public ArrayList<Student> findStudents(String hint) {
        ArrayList<Student> students = new ArrayList<Student>();
        for (Class c : this.classes) {
            for (Student s : c.getClassStudents()) {
                if ((s.getFirstname().toLowerCase().contains(hint) || s.getSurname().toLowerCase().contains(hint)) && !students.contains(s)) {
                    students.add(s);
                }
            }
        }

        return students;

    }

    public boolean addGrade(int id, int classID, double grade) { //get class that had both that student, identified by id, and teacher

        for (Class c : this.classes) {
            if (c.getID() != classID) {
                continue;
            }
            Student s = c.findStudent(id);
            if (s != null) {

                s.getGrades(c).add(grade);

            }
        }
        return true;
    }

    public boolean editGrade(int id, double grade, int index, Class c) //edits/changes grade at index 'index'
    {

        Student s = c.findStudent(id);
        if (s != null) {

            s.getGrades().get(c).set(index, grade);
            return true;

        }

        return false;
    }

    public ArrayList<Double> predictGrade(int studentID, Class c, ArrayList<Double> g) throws IOException {
        //returns an arraylist of the different predicted grades individually. eg {5.6, 6. 7.1}
        ArrayList<Double> predicteds = new ArrayList<Double>();

        Student s = c.findStudent(studentID);

        if (s == null) {
            return null;
        }

        //NN Predict
        Predictable NNpredict = (grades, attributes, h) -> {
            double grade = 0;
            try {
                NNModel model = new NNModel();
                ArrayList<Double> temp = new ArrayList<Double>();
                int temp1 = grades.size();
                for (int i = 0; i < 14; i++) {
                    temp.add(grades.get(i % temp1));
                }
                grade = model.Dense(temp);
                return grade;
            } catch (Exception e) {
                System.out.println("error1");
                return grade;
            }

        };

        //TA Predict
        Predictable TeacherAverage = (grades, attributes, h) -> {
            ArrayList<Double> gradeList = grades;
            int size = gradeList.size();
            if (size == 0) {
                return 0;

            }
            if (size <= 3) {
                return gradeList.get(size - 1);

            }
            if (size <= 7) {
                return gradeList.get(3);
            }

            return (gradeList.get(3) + gradeList.get(7)) / 2;

        };

        //this is an algorithm I came up with myself.
        Predictable LinRegPredict = (grades, attributes, h) -> {

            // compute the gradients
            double sf1 = 0.5;
            double outlier = 1.5;
            System.out.println(grades);
            for (int i = 1; i < grades.size(); i++) {
                double result = grades.get(i) - grades.get(i - 1);
                System.out.println(result);
                if (result > outlier) {// to keep outliers in check
                    grades.set(i, grades.get(i - 1) + result * sf1);
                }

            }
            System.out.println(grades);
            LinReg r = new LinReg(grades, 10);

            ArrayList<Double> thing = r.predict();

            double pred = 0;

            pred += thing.get(0) * grades.size(); // this finds the next point on the line. 
            //thing.size is like the next x-cordinate;

            pred += thing.get(1);

            if (h != null) {
                h.setTrend(thing, c);

                if (pred > s.max(grades)) {
                    return s.max(grades);
                }
                if (pred < 1.0) {
                    return 1.0;
                }
            }

            return pred;

        };

        Predictable gradientPredict = (grades, attributes, h) -> {

            // compute the gradients
            ArrayList<Double> gradients = new ArrayList<Double>();
            double sf1 = 0.5;
            double outlier = 1.5;
            System.out.println(grades);
            for (int i = 0; i < grades.size() - 1; i++) {
                double result = grades.get(i + 1) - grades.get(i);
                System.out.println(result);
                if (result > outlier) {// to keep outliers in check
                    result *= sf1;
                }
                System.out.println(result);
                gradients.add(result);
            }

            LinReg r = new LinReg(gradients, 10);

            ArrayList<Double> thing = r.predict();

            double pred = 0;

            pred += thing.get(0) * gradients.size(); // this finds the next point on the line. thing.size is like the next x-cordinate;

            pred += thing.get(1);
            double sf2 = 0.2; //this is to limit the chnage in gradient.

            if (h != null) {
                h.gradient = pred * sf2;

            }

            return pred;

        };
        ArrayList<Double> wow = new ArrayList<Double>();
        for (Double d : g) {
            if (d != 0.0) {
                wow.add(d);
            }
        }
        if (wow.size() == 0) {
            for (int i = 0; i < 3; i++) {
                predicteds.add(0.0);
            }
            return predicteds;
        }

        predicteds.add(NNpredict.predict(wow, null, s));

        predicteds.add(LinRegPredict.predict(wow, null, s));

        predicteds.add(TeacherAverage.predict(wow, null, s));

        if (wow.size() > 1 && wow.size() <= 5) {

            gradientPredict.predict(wow, null, s);

        }
        if (wow.size() > 5) {

            ArrayList<Double> gdg = new ArrayList<Double>();
            for (int i = wow.size() - 3; i < wow.size(); i++) {
                gdg.add(wow.get(i));
            }
            gradientPredict.predict(gdg, null, s);

        }

        return predicteds;

    }

    public ArrayList<Double> probabilityPredict(int studentID, Class c) {
        ArrayList<Double> grades = new ArrayList<Double>();

        try {
            Student s = c.findStudent(studentID);
            ArrayList<Double> wow = new ArrayList<Double>();
            for (Double d : s.getGrades(c)) {
                if (d != 0.0) {
                    wow.add(d);
                }
            }
            if (wow.size() == 0) {
                for (int i = 0; i < 7; i++) {
                    grades.add(0.0);
                }
                return grades;
            }
            NNModel model = new NNModel();
            ArrayList<Double> temp = new ArrayList<Double>();
            int temp1 = wow.size();
            for (int i = 0; i < 14; i++) {
                temp.add(wow.get(i % temp1));
            }
            grades = model.Probability(temp);
            return grades;
        } catch (Exception e) {
            System.out.println("error2");
            return grades;
        }

    }

    public double predictCompositeGrade(ArrayList<Double> probabilities, ArrayList<Double> otherStats, Class c, Student s) {
        double compositeGrade = 0.0;
        double max = 0;
        for (int i = 0; i< probabilities.size(); i++) {
            max+= (i+1)*probabilities.get(i)*1.05;
        }
        
        double ave = 0.0;
        for (Double temp : otherStats) {
            ave += temp / otherStats.size();
        }
        compositeGrade = Math.round(  ( (max*0.6 + ave*0.4) ) *100.0) /100.0;

        s.setPredictedGrades(c, compositeGrade);

        return compositeGrade;

    }

    public String toString() {

        return "Name: " + this.getFirstname() + "----- id: " + this.getID() + "-------number of classes: " + this.classes.size();
    }

}
