/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author adith
 */
public class TeacherManager implements Serializable{
    private static ArrayList<Teacher> allTeachers = new ArrayList<>();

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
}
