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
    private AssessmentNodeList start;

    public AssessmentNodeList getStart(){
        return start;
    }

    public void setStart(AssessmentNodeList start){
        this.start = start;
    }
 
    public boolean isEmpty(){
        return start == null;
    }

    public AssessmentLinkedList() {
        this.start = null;
    }
    
    public int length(){
        int length = 0;
        AssessmentNodeList temp = start;
            while (temp!=null) {
                temp = temp.getNext();
                length++;
            }
        return length;
    }
	
    public void addAssessment(ArrayList<Student> listOfStudents, Date assessmentDate, String assessmentName){
        AssessmentNodeList newAssessmentNode = new AssessmentNodeList(listOfStudents, assessmentName, assessmentDate);
        if (isEmpty()) {
            start = newAssessmentNode;
        }else{
           AssessmentNodeList temp = start;
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
        AssessmentNodeList temp1 = start;
        AssessmentNodeList temp2 = start.getNext();
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
        AssessmentNodeList temp = start;
        ArrayList<ArrayList<Double>> listOfStudents = new ArrayList<>();
        while(temp != null){
            listOfStudents = temp.getListOfStudents();
            int id = student.getId();
            ArrayList<Double> studentList = new ArrayList<>();
            studentList.add((double)id);
            studentList.add(1.0);
            listOfStudents.add(studentList);
            ArrayListHelper.sortDouble(listOfStudents, 0, listOfStudents.size()-1);
            temp.setListOfStudents(listOfStudents);
            temp = temp.getNext();
        }
    }
    
    public void removeStudent(Student student){
        AssessmentNodeList temp = start;
        ArrayList<ArrayList<Double>> listOfStudents = new ArrayList<>();
        while(temp!=null){
            listOfStudents = temp.getListOfStudents();
            int id = student.getId();
            int location = ArrayListHelper.binarySearchDouble(listOfStudents, id);
            listOfStudents.remove(location);
            temp.setListOfStudents(listOfStudents);
            temp = temp.getNext();
        }
    }
    
    public void markAssessment(String homeworkName, int id, double score){
        AssessmentNodeList temp = start;
        ArrayList<Integer> AListModification = new ArrayList<>();
        while(temp!=null){
            if(temp.getAssessmentName().equals(homeworkName)){
                for(int i=0; i<temp.getListOfStudents().size(); i++){
                    if(temp.getListOfStudents().get(i).get(0) == id){
                        temp.getListOfStudents().get(i).set(1, score);
                    }
                }
            }
            temp = temp.getNext();
        }
    }

}
