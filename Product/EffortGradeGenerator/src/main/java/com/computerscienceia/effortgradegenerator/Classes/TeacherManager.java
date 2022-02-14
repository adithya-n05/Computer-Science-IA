/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author adith
 */
public class TeacherManager implements Serializable{
    public static ArrayList<Teacher> allTeachers = new ArrayList<>();
    
    public static ArrayList<Teacher> getAllTeachers() {
        return allTeachers;
    }

    public static void setAllTeachers(ArrayList<Teacher> allTeachers) {
        TeacherManager.allTeachers = allTeachers;
    }
    
    public static void addTeacher(Teacher newTeacher){
        allTeachers.add(newTeacher);
        ArrayListHelper.sortTeacher(allTeachers, 0, allTeachers.size()-1);
    }
    
    public static void save(String fileName) throws IOException{
        FileOutputStream saverFOS = new FileOutputStream(fileName+".ser");
        ObjectOutputStream saveOOS = new ObjectOutputStream(saverFOS);
        saveOOS.writeObject(allTeachers);
        saveOOS.close();
        saverFOS.close();
    }
    
    public static void load(String fileName) throws IOException{
        File teachersList = new File(fileName +".ser");
        if(!teachersList.exists()){
            teachersList.createNewFile();
        }
        try{
            FileInputStream loaderFIS = new FileInputStream(fileName+".ser");
            ObjectInputStream loaderOIS = new ObjectInputStream(loaderFIS);
            allTeachers = (ArrayList<Teacher>)loaderOIS.readObject();
            loaderFIS.close();
            loaderOIS.close();
        }catch(ClassNotFoundException c){
        }
    }
    
}
