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
public class HomeworkNodeStack extends HomeworkNode implements Serializable{
    private boolean completed;
    private boolean percentageCompletedNode;
    private double percentageCompleted;

    public double getPercentageCompleted() {
        return percentageCompleted;
    }

    public void setPercentageCompleted(double percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }
    private HomeworkNodeStack next;

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isPercentageCompletedNode() {
        return percentageCompletedNode;
    }

    public void setPercentageCompletedNode(boolean percentageCompletedNode) {
        this.percentageCompletedNode = percentageCompletedNode;
    }

    public HomeworkNodeStack getNext() {
        return next;
    }

    public void setNext(HomeworkNodeStack next) {
        this.next = next;
    }

    public HomeworkNodeStack(boolean completed, boolean percentageCompletedNode, double percentageCompleted, String homeworkName, String description, Date dueDate) {
        super(homeworkName, description, dueDate);
        this.percentageCompleted = percentageCompleted;
        this.completed = completed;
        this.percentageCompletedNode = percentageCompletedNode;
        this.next=null;
    }
    
}
