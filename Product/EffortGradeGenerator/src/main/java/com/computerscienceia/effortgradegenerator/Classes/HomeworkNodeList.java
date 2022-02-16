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
public class HomeworkNodeList extends HomeworkNode implements Serializable{
    
    private ArrayList<ArrayList<Integer>> listOfStudents;
    private HomeworkNodeList next;

    public ArrayList<ArrayList<Integer>> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(ArrayList<ArrayList<Integer>> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public HomeworkNodeList getNext() {
        return next;
    }

    public void setNext(HomeworkNodeList next) {
        this.next = next;
    }

    public HomeworkNodeList(ArrayList<Student> listOfStudents, String homeworkName, String description, Date dueDate) {
        super(homeworkName, description, dueDate);
        for(int i =0; i<listOfStudents.size(); i++){
            Student student = listOfStudents.get(i);
            int id = student.getId();
            this.listOfStudents.add(new ArrayList<>());
            this.listOfStudents.get(i).add(0, id);
        }
        this.next = null;
    }
    
    public boolean hasNext(){
        return next == null;
    }
}
