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
    
    public int length(){
        int length = 0;
        AssessmentNode temp = start;
            while (temp.hasNext()) {
                temp = temp.getNext();
                length++;
            }
        return length;
    }
	
    public void addAssessment(ArrayList<Student> listOfStudents, Date assessmentDate, String assessmentName){
        AssessmentNode newAssessmentNode = new AssessmentNode(listOfStudents, assessmentName, assessmentDate);
        if (isEmpty()) {
            start = newAssessmentNode;
        }else{
           AssessmentNode temp = start;
            while (temp.hasNext()) {
                temp = temp.getNext();
            }
            temp.setNext(newAssessmentNode);
        }
    }
    
    public void removeAssessment(String assessmentName){
        if( assessmentName.equals(start.getAssessmentName()) ){
            start = start.getNext();
            return;
        }
        AssessmentNode temp1 = start;
        AssessmentNode temp2 = start.getNext();
        while(temp2 != null){
            if(temp2.getAssessmentName().equals(assessmentName)){
                temp1.setNext(temp2.getNext());
                return;
            }
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }
    }
    
    public void addStudent(Student student){
        AssessmentNode temp = start;
        ArrayList<ArrayList<Double>> listOfStudents;
	while(temp != null){
            listOfStudents = temp.getListOfStudents();
            int id = student.getId();
            ArrayList<Double> studentList = new ArrayList<>();
            studentList.add((double)id);
            listOfStudents.add(studentList);
            ArrayListHelper.sortDouble(listOfStudents, 0, listOfStudents.size()-1);
            temp.setListOfStudents(listOfStudents);
            temp = temp.getNext();
        }
    }
    
    public void removeStudent(Student student){
        AssessmentNode temp = start;
        ArrayList<ArrayList<Double>> listOfStudents;
        while(temp!=null){
            listOfStudents = temp.getListOfStudents();
            int id = student.getId();
            int location = ArrayListHelper.binarySearchDouble(listOfStudents, id);
            listOfStudents.remove(location);
            temp.setListOfStudents(listOfStudents);
        }
    }

}
