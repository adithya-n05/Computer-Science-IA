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
public class AssessmentNodeStack extends AssessmentNode implements Serializable{
    private double score;
    private AssessmentNodeStack next;
    private boolean EMANode;

    public AssessmentNodeStack(double score, String assessmentName, Date assessmentDate, boolean EMANode) {
        super(assessmentName, assessmentDate);
        this.score = score;
        this.EMANode = EMANode;
        this.next = null;
    }

    public boolean isEMANode() {
        return EMANode;
    }

    public void setEMANode(boolean EMANode) {
        this.EMANode = EMANode;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public AssessmentNodeStack getNext() {
        return next;
    }

    public void setNext(AssessmentNodeStack next) {
        this.next = next;
    }
    
}
