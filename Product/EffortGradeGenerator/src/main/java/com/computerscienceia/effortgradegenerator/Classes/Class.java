/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author adith
 */
public class Class implements Serializable{
    private HomeworkLinkedList listOfHomeworks;
    private  AssessmentLinkedList quarterTests;
    private AssessmentLinkedList semesterExams;
    private ArrayList<Student> listOfStudents;
    private String className;
    private String subject;
    private boolean isHL;

    public HomeworkLinkedList getListOfHomeworks() {
        return listOfHomeworks;
    }

    public void setListOfHomeworks(HomeworkLinkedList listOfHomeworks) {
        this.listOfHomeworks = listOfHomeworks;
    }

    public AssessmentLinkedList getQuarterTests() {
        return quarterTests;
    }

    public void setQuarterTests(AssessmentLinkedList quarterTests) {
        this.quarterTests = quarterTests;
    }

    public AssessmentLinkedList getSemesterExams() {
        return semesterExams;
    }

    public void setSemesterExams(AssessmentLinkedList semesterExams) {
        this.semesterExams = semesterExams;
    }

    public ArrayList<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isIsHL() {
        return isHL;
    }

    public void setIsHL(boolean isHL) {
        this.isHL = isHL;
    }

    public Class() {
    }

    public Class(String className, String subject, boolean isHL) {
        this.className = className;
        this.subject = subject;
        this.isHL = isHL;
    }
    
    public void addStudent(String firstName, String lastName, int id){
        Student newStudent = new Student(id, firstName, lastName);
        listOfStudents.add(newStudent);
        quarterTests.addStudent(newStudent);
        semesterExams.addStudent(newStudent);
        listOfHomeworks.addStudent(newStudent);
    }
    
    public void addStudent(Student newStudent){
        listOfStudents.add(newStudent);
        quarterTests.addStudent(newStudent);
        semesterExams.addStudent(newStudent);
        listOfHomeworks.addStudent(newStudent);
    }
    
    public void remvoeStudent(Student removalStudent){
        listOfStudents.remove(removalStudent);
        quarterTests.removeStudent(removalStudent);
        semesterExams.removeStudent(removalStudent);
        listOfHomeworks.removeStudent(removalStudent);
    }
    
}
