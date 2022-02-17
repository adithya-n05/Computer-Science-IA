/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import com.computerscienceia.effortgradegenerator.GUI.EffortGradeGenerator;

/**
 *
 * @author adith
 */
public class AssessmentSearcher{
    public static String quarterAssessmentDate(String assessmentName){
        String description = "";
        AssessmentNodeList temp = EffortGradeGenerator.primaryClass.getQuarterTests().getStart();
        while(temp!=null){
            if(temp.getAssessmentName().equals(assessmentName)){
                description = temp.getAssessmentDate().toString();
            }
            temp=temp.getNext();
        }
        return description;
    }

    public static String semsesterExamDate(String assessmentName){
        String description = "";
        AssessmentNodeList temp = EffortGradeGenerator.primaryClass.getSemesterExams().getStart();
        while(temp!=null){
            if(temp.getAssessmentName().equals(assessmentName)){
                description = temp.getAssessmentDate().toString();
            }
            temp=temp.getNext();
        }
        return description;
    }
}
