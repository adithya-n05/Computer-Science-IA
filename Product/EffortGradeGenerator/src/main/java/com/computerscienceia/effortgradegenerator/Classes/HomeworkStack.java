/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author adith
 */
public class HomeworkStack implements Serializable{
    private HomeworkNodeStack top;

    public HomeworkNodeStack getTop() {
        return top;
    }

    public void setTop(HomeworkNodeStack top) {
        this.top = top;
    }
    
    public HomeworkStack() {
        this.top = null;
    }
    
    public boolean isEmpty(){
        return top ==null;
    }
    
    public void pushCompletionRateNode(){
        if(isEmpty()){
            this.top = new HomeworkNodeStack(false, true, 0.0, "completionRateNode", "None", new Date());
        }else{
            HomeworkNodeStack temp = top;
            ArrayList<Boolean> completedList = new ArrayList<>();
            while(temp!=null){
                completedList.add(temp.isCompleted());
                temp=temp.getNext();
            }
            double percentCompletion = HomeworkPercentageCompletedHelper.calculatePercentageCompleted(completedList);
            HomeworkNodeStack newNode = new HomeworkNodeStack(false, true, percentCompletion, "completionRateNode", "Nonde", new Date());
            newNode.setNext(this.top);
            this.top.setNext(newNode);
        }
    }
	
    public void addHomework(Date homeworkDueDate, String homeworkName, String descriptionString)
	{
            this.popCompletionNode();
            HomeworkNodeStack newAssessment = new HomeworkNodeStack(true, true, 0.0, homeworkName, descriptionString, homeworkDueDate);
		if( isEmpty() )
		{
			top = newAssessment;
		} else {
			newAssessment.setNext(top);
			top = newAssessment;
		}
            this.pushCompletionRateNode();
	}
	
    public Map<String, Double> popCompletionNode()
	{
		if( !isEmpty() )
		{
			String homeworkName = top.getHomeworkName();
                        double percentageCompleted = top.getPercentageCompleted();
			top = top.getNext();
                        Map<String, Double> nodeInformation = new HashMap<>();
                        nodeInformation.put(homeworkName, percentageCompleted);
			return nodeInformation;
		} else {
                        Map<String, Double> nodeInformation = new HashMap<>();
			return nodeInformation;
		}
	}
    
    
    public void removeAssessment(String homeworkNameString){
        this.popCompletionNode();
        HomeworkNodeStack temp1 = top;
        HomeworkNodeStack temp2 = top.getNext();
        if(temp1.getHomeworkName().equals(homeworkNameString)){
            top=top.getNext();
            this.pushCompletionRateNode();
        }else{
            while(temp2!=null){
                if(temp2.getHomeworkName().equals(homeworkNameString)){
                temp1.setNext(temp2.getNext());
                this.pushCompletionRateNode();
                return;
            }
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
            }
        }
    }
	
	public Map<String, Double> peekPercentageCompletedValue()
	{
                String homeworkName = top.getHomeworkName();
                double score = top.getPercentageCompleted();
		Map<String, Double> nodeInformation = new HashMap<>();
                nodeInformation.put(homeworkName, score);
                return nodeInformation;
	}
    
    
}
