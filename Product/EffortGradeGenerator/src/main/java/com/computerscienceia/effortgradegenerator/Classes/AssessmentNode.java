/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author adithyanarayanan
 */
public class AssessmentNode implements Serializable{
    private ArrayList<ArrayList<Double>> listOfStudents;
    private String assessmentName; 
    private Date assessmentDate;
    AssessmentNode next;
	
    public AssessmentNode(ArrayList<Student> listOfStudents, String assessmentName, Date assessmentDate){
        for(int i =0; i<listOfStudents.size(); i++){
            Student student = listOfStudents.get(i);
            int id = student.getId();
            this.listOfStudents.add(new ArrayList<>());
            this.listOfStudents.get(i).add(id, 1.0);
        }
        this.assessmentName = assessmentName;
        this.assessmentDate = assessmentDate;
	next = null;
    }
    
    public AssessmentNode(){
        next = null;
    }

    public ArrayList<ArrayList<Double>> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(ArrayList<ArrayList<Double>> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

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

    public AssessmentNode getNext() {
        return next;
    }

    public void setNext(AssessmentNode next) {
        this.next = next;
    }
	
	public boolean hasNext()
	{
		if(next == null)
			return false;
		else
			return true;
	}
}
