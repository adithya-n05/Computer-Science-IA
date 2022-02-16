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
    private HomeworkNodeList start;

    public HomeworkNodeList getStart() {
        return start;
    }

    public void setStart(HomeworkNodeList start) {
        this.start = start;
    }
    
    public boolean isEmpty(){
        return start == null;
    }

    public HomeworkLinkedList() {
        this.start = null;
    }
    
    public int length(){
        int length = 0;
        HomeworkNodeList temp = start;
            while (temp != null) {
                length++;
                temp = temp.getNext();
            }
        return length;
    }
    
    public void addHomework(ArrayList<Student> listOfStudents, String HomeworkName, Date dueDate, String description)
    {	
        HomeworkNodeList newNode = new HomeworkNodeList(listOfStudents, HomeworkName, description, dueDate);
	if( isEmpty() )
	{   
            start = newNode;
            return;
	}
	HomeworkNodeList temp = start;
	while( temp != null )
	{	temp = temp.getNext();
	}
	temp.setNext(newNode);

    }
    
    public void removeHomework(String homeworkName){
        if( homeworkName.equals(start.getHomeworkName()) ){
            start = start.getNext();
            return;
        }
        HomeworkNodeList temp1 = start;
        HomeworkNodeList temp2 = start.getNext();
        while(temp2 != null){
            if(temp2.getHomeworkName().equals(homeworkName)){
                temp1.setNext(temp2.getNext());
                return;
            }
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }
    }
    
    public void addStudent(Student student){
        HomeworkNodeList temp = start;
        ArrayList<ArrayList<Integer>> listOfStudents;
	while(temp != null){
            listOfStudents = temp.getListOfStudents();
            int id = student.getId();
            ArrayList<Integer> studentList = new ArrayList<>();
            studentList.add(id);
            studentList.add(0);
            listOfStudents.add(studentList);
            ArrayListHelper.sortInt(listOfStudents, 0, listOfStudents.size()-1);
            temp.setListOfStudents(listOfStudents);
            temp = temp.getNext();
        }
    }

    public void removeStudent(Student student){
        HomeworkNodeList temp = start;
        ArrayList<ArrayList<Integer>> listOfStudents;
        while(temp!=null){
            listOfStudents = temp.getListOfStudents();
            int id = student.getId();
            int location = ArrayListHelper.binarySearchInt(listOfStudents, id);
            listOfStudents.remove(location);
            temp.setListOfStudents(listOfStudents);
        }
    }
}
