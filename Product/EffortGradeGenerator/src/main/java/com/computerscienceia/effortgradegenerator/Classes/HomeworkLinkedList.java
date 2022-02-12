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
public class HomeworkLinkedList implements Serializable{
    private HomeworkNode start;

    public HomeworkNode getStart() {
        return start;
    }

    public void setStart(HomeworkNode start) {
        this.start = start;
    }
    
    public boolean isEmpty(){
        return start == null;
    }
    
    public void append(ArrayList<Student> listOfStudents, String HomeworkName, Date dueDate, String description)
    {	
        HomeworkNode newNode = new HomeworkNode(listOfStudents, HomeworkName, description, dueDate);
	if( isEmpty() )
	{   
            start = newNode;
            return;
	}
	HomeworkNode temp = start;
	while( temp.hasNext() )
	{	temp = temp.getNext();
	}
	temp.setNext(newNode);
    }
    
    public void addStudent(Student student){
        HomeworkNode temp = start;
        ArrayList<ArrayList<Integer>> listOfStudents;
	while(temp != null){
            listOfStudents = temp.getListOfStudents();
            int id = student.getId();
            ArrayList<Integer> studentList = new ArrayList<>();
            studentList.add(id);
            listOfStudents.add(studentList);
            ArrayListHelper.sort(listOfStudents, 0, listOfStudents.size()-1);
            temp.setListOfStudents(listOfStudents);
            temp = temp.getNext();
        }
    }
    
    }
