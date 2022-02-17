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
public class AssessmentNodeList extends AssessmentNode implements Serializable{
    private ArrayList<ArrayList<Double>> listOfStudents = new ArrayList<>();
    private AssessmentNodeList next;
	
    public AssessmentNodeList(ArrayList<Student> listOfStudents, String assessmentName, Date assessmentDate){
        super(assessmentName, assessmentDate);
        for(int i =0; i<listOfStudents.size(); i++){
            Student student = listOfStudents.get(i);
            int id = student.getId();
            this.listOfStudents.add(new ArrayList<>());
            this.listOfStudents.get(i).add(id, 1.0);
        }
	next = null;
    }

    public ArrayList<ArrayList<Double>> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(ArrayList<ArrayList<Double>> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }
    
    public AssessmentNodeList getNext() {
        return next;
    }

    public void setNext(AssessmentNodeList next) {
        this.next = next;
    }
    
    public boolean hasNext(){
        return next != null;
    }
}
