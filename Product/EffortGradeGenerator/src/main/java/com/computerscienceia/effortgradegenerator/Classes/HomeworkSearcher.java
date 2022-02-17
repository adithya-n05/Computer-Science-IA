/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import com.computerscienceia.effortgradegenerator.GUI.EffortGradeGenerator;

/**
 *
 * @author adithyanarayanan
 */
public class HomeworkSearcher {
    public static String getHomeworkDescription(String homeworkName){
        String description = "";
        HomeworkNodeList temp = EffortGradeGenerator.primaryClass.getListOfHomeworks().getStart();
        while(temp!=null){
            if(temp.getHomeworkName().equals(homeworkName)){
                description = temp.getDescription();
            }
            temp=temp.getNext();
        }
        return description;
    }
    
    public static String getHomeworkDate(String homeworkName){
        String description = "";
        HomeworkNodeList temp = EffortGradeGenerator.primaryClass.getListOfHomeworks().getStart();
        while(temp!=null){
            if(temp.getHomeworkName().equals(homeworkName)){
                description = temp.getDueDate().toString();
            }
            temp=temp.getNext();
        }
        return description;
    }
}
