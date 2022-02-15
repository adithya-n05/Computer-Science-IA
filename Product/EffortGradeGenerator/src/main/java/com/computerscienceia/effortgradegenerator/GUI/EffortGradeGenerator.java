/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.GUI;

import com.computerscienceia.effortgradegenerator.Classes.AssessmentNode;
import com.computerscienceia.effortgradegenerator.Classes.Teacher;
import com.computerscienceia.effortgradegenerator.Classes.TeacherManager;
import com.computerscienceia.effortgradegenerator.Classes.Class;
import com.computerscienceia.effortgradegenerator.Classes.HomeworkNode;
import java.io.IOException;

/**
 *
 * @author adith
 */
public class EffortGradeGenerator {
    public static Teacher primaryTeacher;
    public static Class primaryClass;
    public static AssessmentNode primaryAssessment;
    public static HomeworkNode primaryHomework;
    
    public static void main(String[] args){
        try {
               TeacherManager.load("Effort Grade Generator");
           } catch (IOException e) {
           }
        new Login().setVisible(true);
    } 
}
