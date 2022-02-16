/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.ArrayList;
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
    
    public void pushEMANode(){
        if(isEmpty()){
            this.top = new AssessmentNodeStack(0, "EMANode", new Date(), true);
        }else{
            AssessmentNodeStack temp = top;
            ArrayList<Double> studentScores = new ArrayList<>();
            while(temp!=null){
                studentScores.add(temp.getScore());
                temp=temp.getNext();
            }
            ExponentialMovingAverage EMACalculator = new ExponentialMovingAverage();
            EMACalculator.calculateEMAMultiplier(studentScores);
            double EMAValue = EMACalculator.calculateEMA(studentScores);
            AssessmentNodeStack newNode = new AssessmentNodeStack(EMAValue, "EMANode",new Date(), true);
            newNode.setNext(this.top);
            this.top.setNext(newNode);
        }
    }
	
    public void addAssessment(Date assessmentDate, String assessmentName)
	{
            Map<String, Double> disposableInformation = this.popEMANode();
            AssessmentNodeStack newAssessment = new AssessmentNodeStack(1.0, assessmentName, assessmentDate, false);
		if( isEmpty() )
		{
			top = newAssessment;
		} else {
			newAssessment.setNext(top);
			top = newAssessment;
		}
            this.pushEMANode();
	}
	
    public Map<String, Double> popEMANode()
	{
		if( !isEmpty() )
		{
			String assessmentName = top.getAssessmentName();
                        double assessmentScore = top.getScore();
			top = top.getNext();
                        Map<String, Double> nodeInformation = new HashMap<>();
                        nodeInformation.put(assessmentName, assessmentScore);
			return nodeInformation;
		} else {
                        Map<String, Double> nodeInformation = new HashMap<>();
			return nodeInformation;
		}
	}
    
    
    public void removeAssessment(String assessmentNameString){
        this.popEMANode();
        AssessmentNodeStack temp1 = top;
        AssessmentNodeStack temp2 = top.getNext();
        if(temp1.getAssessmentName().equals(assessmentNameString)){
            top=top.getNext();
            this.pushEMANode();
        }else{
            while(temp2!=null){
                if(temp2.getAssessmentName().equals(assessmentNameString)){
                temp1.setNext(temp2.getNext());
                this.pushEMANode();
                return;
            }
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
            }
        }
    }
	
	public Map<String, Double> peekEMAValue()
	{
                String assessmentName = top.getAssessmentName();
                Double score = top.getScore();
		Map<String, Double> nodeInformation = new HashMap<>();
                nodeInformation.put(assessmentName, score);
                return nodeInformation;
	}
}
