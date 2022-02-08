/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 *
 * @author sameer
 */
public class TeacherManager {

    private static ArrayList<Teacher> allTeachers = new ArrayList<Teacher>();

    public static void save() {

        try {

            FileOutputStream f = new FileOutputStream(new File("AllTeachers.txt"));

            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(allTeachers);

            o.close();

            f.close();

        } catch (IOException e) {
            System.out.println("Error initializing stream save");
        }

    }

    public static void load() {

        try {

            FileInputStream fi = new FileInputStream("AllTeachers.txt");

            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            allTeachers = (ArrayList<Teacher>) oi.readObject();

            oi.close();

            fi.close();

        } catch (FileNotFoundException e) { //https://www.mkyong.com/java/how-to-read-and-write-java-object-to-a-file/
            System.out.println("File not found");

        } catch (IOException e) {
            System.out.println("Error initializing stream load");

        } catch (ClassNotFoundException e) {
            System.out.println("Error initializing stream classnotfound");
            e.printStackTrace();

        } catch (Exception e) {

        }

    }

    public static Teacher createTeacher(String firstname, String surname, String schoolName, int id) {
        Teacher newTeacher = new Teacher(firstname, surname, schoolName, id);
        allTeachers.add(newTeacher);
        save();
        return newTeacher;
    }

    public static Teacher findTeacher(int id) {

        for (Teacher t : allTeachers) {
            if (t.getID() == id) {
                return t;
            }
        }

        return null;

    }

    public static ArrayList<Teacher> findTeachers(String hint) {
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();

        for (Teacher s : allTeachers) {
            if ((s.getFirstname().toLowerCase().contains(hint) || s.getSurname().toLowerCase().contains(hint)) && !teachers.contains(s)) {
                teachers.add(s);
            }
        }

        return teachers;

    }

    public static void main(String[] args) {
        load();
        Teacher t = new Teacher("Sameer", "Malik", "OFS", 12345);

        /*Class newclass = new Class(t, new Subject(true, "Mathematics 01" ), 52634);
        Class newclass1 = new Class(t, new Subject(true, "Mathematics 02" ), 52635);
        
        Student s = new Student("Tashi", "Karma", t.schoolName, 67589);
        Student agra = new Student("Aryan", "Agrawal", t.schoolName, 85479);
        Student k = new Student("dev", "natarajan", t.schoolName, 78589);
        newclass.addStudent(s);
        newclass.addStudent(agra);
        newclass1.addStudent(s);
        newclass1.addStudent(agra);
        newclass1.addStudent(k);
        
   
        
        System.out.println(newclass.getClassStudents());
        
        
        
        t.addGrade(67589,52634, 7.8);
        t.addGrade(85479, 52634, 5.6);
        t.addGrade(85479, 52634, 5.6);
        t.addGrade(85479, 52634, 5.7);
         t.addGrade(67589,52635, 7.5);
        t.addGrade(85479, 52635, 5.6);
        t.addGrade(85479, 52635, 5.7);
        t.addGrade(85479, 52635, 4.7);
         t.addGrade(78589, 52635, 1.7);
        t.addGrade(78589, 52635, 2.7);
        
        
         
        save(t);
        
        Teacher h = load(12345);
        
         h.viewClassGrades(52634);
         System.out.println(newclass1.getClassStudents());
          h.viewClassGrades(52635);*/
    }

}
