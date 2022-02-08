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

/**
 *
 * @author sameer
 */
public class ClassManager {

    private static ArrayList<Class> allClasses = new ArrayList<Class>();

    public static void save() {

        try {
            FileOutputStream f = new FileOutputStream(new File("AllClasses.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(allClasses);

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

            FileInputStream fi = new FileInputStream("AllClasses.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            allClasses = (ArrayList<Class>) oi.readObject();

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

    public static Class createClass(Teacher classTeacher, Subject classSubject, int classID) {

        Class newClass = new Class(classTeacher, classSubject, classID);
        allClasses.add(newClass);
        return newClass;
    }

    public static ArrayList<Class> getAllClasses() {

        return allClasses;
    }

    public static void main(String[] args) {
        load();
    }

}
