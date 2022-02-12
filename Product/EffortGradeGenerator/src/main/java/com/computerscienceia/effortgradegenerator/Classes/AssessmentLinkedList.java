/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author adithyanarayanan
 */
public class AssessmentLinkedList implements Serializable{
    private AssessmentNode start;

    public AssessmentNode getStart(){
        return start;
    }

    public void setStart(AssessmentNode start){
        this.start = start;
    }
 
    public boolean isEmpty(){
        return start == null;
    }
	
    public void addAssessment(ArrayList<Student> listOfStudents, Date assessmentDate, String assessmentName){
        AssessmentNode newAssessmentNode = new AssessmentNode(listOfStudents, assessmentName, assessmentDate);
        if (isEmpty()) {
            start = newAssessmentNode;
            return;
        }else{
           AssessmentNode temp = start;
            while (temp.hasNext()) {
                temp = temp.getNext();
            }
            temp.setNext(newAssessmentNode);
        }
    }
}
