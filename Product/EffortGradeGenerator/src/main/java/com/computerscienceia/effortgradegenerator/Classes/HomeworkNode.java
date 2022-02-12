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
public class HomeworkNode implements Serializable{
    
    private ArrayList<ArrayList<Integer>> listOfStudents;
    private String homeworkName;
    private String description;
    private Date dueDate;
    private HomeworkNode next;

    public ArrayList<ArrayList<Integer>> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(ArrayList<ArrayList<Integer>> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public HomeworkNode getNext() {
        return next;
    }

    public void setNext(HomeworkNode next) {
        this.next = next;
    }

    public HomeworkNode(ArrayList<Student> listOfStudents, String homeworkName, String description, Date dueDate) {
        for(int i =0; i<listOfStudents.size(); i++){
            Student student = listOfStudents.get(i);
            int id = student.getId();
            this.listOfStudents.add(new ArrayList<>());
            this.listOfStudents.get(i).add(id, 0);
        }
        this.homeworkName = homeworkName;
        this.description = description;
        this.dueDate = dueDate;
        this.next = null;
    }
    
    public boolean hasNext(){
        return next == null;
    }
    
    
}
