/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author adith
 */
public class AssessmentNode implements Serializable{
    private String assessmentName; 
    private Date assessmentDate;

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public Date getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(Date assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public AssessmentNode(String assessmentName, Date assessmentDate) {
        this.assessmentName = assessmentName;
        this.assessmentDate = assessmentDate;
    }
}
