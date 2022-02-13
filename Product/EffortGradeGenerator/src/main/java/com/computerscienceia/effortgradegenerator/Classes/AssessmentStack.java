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
    private AssessmentNode top;

    public AssessmentNode getTop() {
        return top;
    }

    public void setTop(AssessmentNode top) {
        this.top = top;
    }
 
    public boolean isEmpty(){
        return top == null;
    }
	
    public void push(Date assessmentDate, String assessmentName)
	{
		AssessmentNode newQuarterTestNode = new AssessmentNode();
		newQuarterTestNode.setAssessmentDate(assessmentDate);
                newQuarterTestNode.setAssessmentName(assessmentName);
		if( isEmpty() )
		{
			top = newQuarterTestNode;
		} else {
			newQuarterTestNode.setNext(top);
			top = newQuarterTestNode;
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
