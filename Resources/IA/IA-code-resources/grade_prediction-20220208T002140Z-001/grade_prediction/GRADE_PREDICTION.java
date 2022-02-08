/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 *
 * @author sameer
 */
public class GRADE_PREDICTION {

    //we are doignt his so that the object will be accessible whre ever we are. upon login, the loaded object is stored immediately, so all data is updated and we can use the EXACT SAME OBJECT where we want to.
    //storing the object basically. this system is only for the use of one teacher or student anyway so ya.
    static Teacher primaryTeacher;
    static Student primaryStudent;
    private static ArrayList<Integer> id = new ArrayList<Integer>();

    public static void main(String[] args) {
        ClassManager.main(null);
        TeacherManager.main(null);
        StudentManager.main(null);

        IAFXMain.main(null);
        TeacherManager.save();
        StudentManager.save();
        ClassManager.save();
        
        
              
        try {
            FileOutputStream h = new FileOutputStream("AllStudents.txt");
            h.close();
            FileOutputStream j = new FileOutputStream("AllTeachers.txt");
            j.close();
            PrintWriter pw = new PrintWriter("Accounts.txt");
            pw.close();
        } catch (Exception e) {

        }
        

    }

    /**
     * @return the id
     */
    public static ArrayList<Integer> getId() {
        return id;
    }

    /**
     * @param aId the id to set
     */
    public static void setId(int aId) {
        id.add(aId);
    }

}
