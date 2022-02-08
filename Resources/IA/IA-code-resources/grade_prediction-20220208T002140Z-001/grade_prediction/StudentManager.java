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
import java.util.*;

public class StudentManager {

    private static ArrayList<Student> allStudents = new ArrayList<Student>();

    public static void save() {

        try {
            FileOutputStream f = new FileOutputStream(new File("AllStudents.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(allStudents);

            o.close();
            f.close();

        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } finally {
            return;
        }

    }

    public static void load() {
        ArrayList<Student> t = null;

        try {

            FileInputStream fi = new FileInputStream("AllStudents.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            allStudents = (ArrayList<Student>) oi.readObject();

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) { //https://www.mkyong.com/java/how-to-read-and-write-java-object-to-a-file/
            System.out.println("File not found");

        } catch (IOException e) {
            System.out.println("Error initializing stream");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (Exception e) {

        } finally {

        }

        }

    public static Student createStudent(String firstname, String surname, String schoolName, int id) {
        Student newStudent = new Student(firstname, surname, schoolName, id);
        allStudents.add(newStudent);
        sortStudents(1);
        save();
        return newStudent;
    }

    public static Student findStudent(int id) {

        for (Student s : allStudents) {
            if (s.getID() == id) {
                return s;
            }
        }

        return null;

    }

    public static void sortStudents(int setting) {
        int csp = 0;
        while (csp < allStudents.size()) {
            int i = csp;
            Student se = allStudents.get(i);
            int j = i + 1;
            while (j < allStudents.size()) {

                switch (setting) {

                    //sort by ID
                    case (0):
                        if (allStudents.get(j).getID() < se.getID()) {
                            i = j;
                            se = allStudents.get(j);
                        }
                        break;

                    //sort by subject name 
                    case (1):
                        if (allStudents.get(j).getSurname().compareToIgnoreCase(se.getSurname()) < 0) {
                            i = j;
                            se = allStudents.get(j);
                        }
                        break;

                }
                j++;
            }
            allStudents.set(i, allStudents.get(csp));
            allStudents.set(csp, se);
            csp++;
        }
    }

    public static ArrayList<Student> findStudents(String hint) {
        ArrayList<Student> students = new ArrayList<Student>();

        for (Student s : allStudents) {
            if ((s.getFirstname().toLowerCase().contains(hint.toLowerCase()) || s.getSurname().toLowerCase().contains(hint.toLowerCase())) && !students.contains(s)) {
                students.add(s);
            }
        }

        return students;

    }

    public static void main(String[] args) {
        load();

    }

}
