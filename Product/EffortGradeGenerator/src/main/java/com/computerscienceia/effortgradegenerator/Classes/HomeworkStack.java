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
        pushCompletionRateNode();
    }
    
    public boolean isEmpty(){
        return top ==null;
    }
    
    public void pushCompletionRateNode(){
        if(isEmpty()){
            top = new HomeworkNodeStack(false, true, 0.0, "completionRateNode", "None", new Date());
        }else{
            HomeworkNodeStack temp = top;
            ArrayList<Boolean> completedList = new ArrayList<>();
            while(temp!=null){
                completedList.add(temp.isCompleted());
                temp=temp.getNext();
            }
            double percentCompletion = HomeworkPercentageCompletedHelper.calculatePercentageCompleted(completedList);
            HomeworkNodeStack newNode = new HomeworkNodeStack(false, true, percentCompletion, "completionRateNode", "None", new Date());
            newNode.setNext(top);
            top.setNext(newNode);
        }
    }
	
    public void addHomework(Date homeworkDueDate, String homeworkName, String descriptionString)
	{
            popCompletionNode();
            HomeworkNodeStack newAssessment = new HomeworkNodeStack(true, true, 0.0, homeworkName, descriptionString, homeworkDueDate);
		if( isEmpty() )
		{
			top = newAssessment;
		} else {
			newAssessment.setNext(top);
			top = newAssessment;
		}
            pushCompletionRateNode();
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
    
    
    public HomeworkNodeStack popNode()
	{
		if( !isEmpty() )
		{
                    HomeworkNodeStack transferAssessment = new HomeworkNodeStack(top.isCompleted(), top.isPercentageCompletedNode(), top.getPercentageCompleted(), top.getHomeworkName(), top.getDescription(), top.getDueDate());
                    top = top.getNext();
                    return transferAssessment;
		} else {
                        HomeworkNodeStack transferAssessment1 = new HomeworkNodeStack(false, false, 0.0, "No nodes left in stack", "NA", new Date());
			return transferAssessment1;
		}
	}
     
     public void pushNode(HomeworkNodeStack pushNode){
        if(isEmpty()){
            this.top = pushNode;
        }else{
            pushNode.setNext(this.top);
            this.top.setNext(pushNode);
        }
    }
    
    
    public void removeHomework(String homeworkNameString){
        this.popCompletionNode();
        HomeworkStack tempStack = new HomeworkStack();
        tempStack.popCompletionNode();
        HomeworkNodeStack temp = top;
        if(top.getHomeworkName().equals(homeworkNameString)){
            top=top.getNext();
            this.pushCompletionRateNode();
        }else{
            HomeworkNodeStack transferHomework;
            while(temp!=null){
                if(temp.getHomeworkName().equals(homeworkNameString)){
                    transferHomework = this.popNode();
                    temp = temp.getNext();
                    break;
                }else{
                    transferHomework = this.popNode();
                    tempStack.pushNode(transferHomework);
                    temp=temp.getNext();
                }
            }
            temp = tempStack.getTop();
            while(temp !=null){
                transferHomework = tempStack.popNode();
                this.pushNode(transferHomework);
                tempStack.setTop(tempStack.getTop().getNext());
            }
            this.pushCompletionRateNode();
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
