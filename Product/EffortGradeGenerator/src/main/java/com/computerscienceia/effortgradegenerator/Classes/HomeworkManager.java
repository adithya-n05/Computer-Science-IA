/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author adithyanarayanan
 */
public class HomeworkManager implements Serializable{
    private ArrayList<Student> classStudents;

    public ArrayList<Student> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(ArrayList<Student> classStudents) {
        this.classStudents = classStudents;
    }
    
    
    
}
