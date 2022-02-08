/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import java.io.*;
import java.util.*;

/**
 *
 * @author sameer
 */
public class Class implements Serializable {

    private static final long serialVersionUID = 2L;

    private Teacher classTeacher;
    private ArrayList<Student> classStudents = new ArrayList<Student>();
    private int classID;
    private Subject classSubject; //includes name

    public Class() {

    }

    public Class(int classID) {
        this.classID = classID;
    }

    public Class(Teacher classTeacher) {
        this.classTeacher = classTeacher;
        classTeacher.addClass(this);
    }

    public Class(Teacher classTeacher, Subject classSubject, int classID) {
        this.classTeacher = classTeacher;
        classTeacher.addClass(this);
        this.classID = classID;
        this.classSubject = classSubject;
    }

    public Teacher getTeacher() {
        return this.classTeacher;
    }

    public void setTeacher(Teacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    public int getID() {
        return this.classID;
    }

    public void setID(int classID) {
        this.classID = classID;
    }

    public Subject getClassSubject() {
        return this.classSubject;
    }

    public void setClassSubject(Subject subject) {
        this.classSubject = subject;
    }

    public boolean addStudent(Student student) {

        this.classStudents.add(student);
        
        if(student.getGrades().keySet().contains(this)){
            return true;
        }
        ArrayList<Double> temp = new ArrayList<Double>();
        for (int i = 0; i < 14; i++) {
            temp.add(0.0);
        }
        student.getGrades().put(this, temp);
        student.getProbabilities().put(this, new ArrayList<Double>());
        student.getTrend().put(this, new ArrayList<Double>());
        student.getPredictedGrades().put(this, 0.0);

        return true;

    }

    public boolean removeStudent(int id) {
        for (Student temp : this.classStudents) {
            if (temp.getID() == id) {
                /*temp.getClasses().remove(this);
				temp.getGrades().remove(this);
				temp.getProbabilities().remove(this);
				temp.getTrend().remove(temp);*/ //the grades should never be deleted
                this.classStudents.remove(temp);
                return true;
            }
        }
        return false;

    }

    public boolean removeStudent(String name) {
        for (Student temp : this.classStudents) {
            if (temp.getFirstname().compareToIgnoreCase(name) == 0) {
                temp.getClasses().remove(this);
                temp.getGrades().remove(this);
                temp.getProbabilities().remove(this);
                temp.getTrend().remove(temp);
                this.classStudents.remove(temp);
                return true;
            }
        }
        return false;
    }

    public Student findStudent(int id) {
        /*  boolean found = false;
		  int low = 0;
		  int high = this.classStudents.size();
		  int place = -1;
		  while(!found && (low<high)){
		      int index = (low+high)/2;
		      if(this.classStudents.get(index).getID()==id){
		          found = true;
		          place = index;
		          return this.classStudents.get(place);
		      }
		      else{
		          if(id<this.classStudents.get(index).getID()){
		              high = index-1;
		          }
		          else{
		              low = index+1;
		          }
		      }
		  }*/
        for (Student s : this.classStudents) {
            if (s.getID() == id) {
                return s;
            }
        }

        return null;
    }

    public ArrayList<Student> getClassStudents() {
        return this.classStudents;
    }

    public double classAverage() {

        try {
            double average = 0;
            double counter = 0;
            for (Student s : getClassStudents()) {
                for (int i = 0; i < s.getGrades(this).size(); i++) {
                    if (s.getGrades(this).get(i) != null) {
                        average += s.getGrades(this).get(i);
                        counter++;
                    }
                }

            }
            return average / counter;
        } catch (Exception e) {
        } finally {
            return 0;
        }
    }

    public double classMedian() {

        try {
            ArrayList<Double> classgrades = new ArrayList<Double>();
            for (Student s : getClassStudents()) {
                for (int i = 0; i < s.getGrades(this).size(); i++) {
                    if (s.getGrades(this).get(i) != null) {
                        classgrades.add(s.getGrades(this).get(i));
                    }
                }

            }
            int csp = 0;
            while (csp < classgrades.size()) {
                int i = csp;
                double se = classgrades.get(i);
                int j = i + 1;
                while (j < classgrades.size()) {

                    //sort by ID
                    if (classgrades.get(j) < se) {
                        i = j;
                        se = classgrades.get(j);
                    }
                    break;

                }
                j++;

                classgrades.set(i, classgrades.get(csp));
                classgrades.set(csp, se);
                csp++;
            }

            return classgrades.get((classgrades.size()) / 2);
        } catch (Exception e) {
        }
        return 0.0;

    }

    public String toString() {
        return this.getClassSubject().getSubjectName() + "  " + this.getID();
    }

}
