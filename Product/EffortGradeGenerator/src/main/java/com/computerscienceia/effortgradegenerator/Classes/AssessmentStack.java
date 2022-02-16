/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.Date;

/**
 *
 * @author adithyanarayanan
 */
public class AssessmentStack implements Serializable{
    private AssessmentNodeStack top;

    public AssessmentNodeStack getTop() {
        return top;
    }

    public void setTop(AssessmentNodeStack top) {
        this.top = top;
    }
 
    public boolean isEmpty(){
        return top == null;
    }

    public AssessmentStack() {
        this.top = null;
    }
	
    public void addAssessment(Date assessmentDate, String assessmentName)
	{
		AssessmentNodeStack newAssessment = new AssessmentNodeStack(1.0, assessmentName, assessmentDate);
		if( isEmpty() )
		{
			top = newAssessment;
		} else {
			newAssessment.setNext(top);
			top = newAssessment;
		}
	}
	
    public Map<String, Date> pop()
	{
		if( !isEmpty() )
		{
			String assessmentName = top.getAssessmentName();
                        Date assessmentDate = top.getAssessmentDate();
			top = top.getNext();
                        Map<String, Date> nodeInformation = new HashMap<>();
                        nodeInformation.put(assessmentName, assessmentDate);
			return nodeInformation;
		} else {
			System.out.println("Stack empty!");
                        Map<String, Date> nodeInformation = new HashMap<>();
			return nodeInformation;
		}
	}
	
	public Map<String, Date> peek()
	{
                String assessmentName = top.getAssessmentName();
                Date assessmentDate = top.getAssessmentDate();
		Map<String, Date> nodeInformation = new HashMap<>();
                nodeInformation.put(assessmentName, assessmentDate);
                return nodeInformation;
                
	}
}
