/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author adith
 */
public class SubjectManager{
    
    private static ArrayList<Subject> allSubjects;
    
    public static void save() throws IOException{
        try (FileOutputStream subjectFOS = new FileOutputStream("allSubjects.ser")) {
            ObjectOutputStream subjectOOS = new ObjectOutputStream(subjectFOS);
            subjectOOS.writeObject(allSubjects);
            subjectOOS.close();
        }
    }
    
    public static void load() throws IOException
    {
        File subjectsFile = new File("allSubjects.ser");
        try {
            FileInputStream subjectFIS = new FileInputStream("allSubjects.ser");
            ObjectInputStream subjectOIS = new ObjectInputStream(subjectFIS); //read mode
            allSubjects = (ArrayList<Subject>) subjectOIS.readObject();
            subjectOIS.close();
            subjectFIS.close();
        } catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }
}
