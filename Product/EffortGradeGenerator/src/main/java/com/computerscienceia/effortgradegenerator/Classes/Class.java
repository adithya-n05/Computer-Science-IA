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
 * @author adith
 */
public class Class implements Serializable{
    private HomeworkLinkedList listOfHomeworks = new HomeworkLinkedList();
    private AssessmentLinkedList quarterTests = new AssessmentLinkedList();
    private AssessmentLinkedList semesterExams = new AssessmentLinkedList();
    private ArrayList<Student> listOfStudents = new ArrayList<>();
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

    public void initialiseLinkedList(HomeworkNodeList newNode){
        this.listOfHomeworks.setStart(newNode);
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
        if(quarterTests != null){
            this.quarterTests.addStudent(newStudent);
        }
        if(semesterExams != null){
            this.semesterExams.addStudent(newStudent);
        }
        if(listOfHomeworks != null){
            this.listOfHomeworks.addStudent(newStudent);
        }
        if(!this.quarterTests.isEmpty()){
        AssessmentNodeList temp = this.quarterTests.getStart();
        while(temp!=null){
            newStudent.getQuarterTests().addAssessment(temp.getAssessmentDate(), temp.getAssessmentName());
            temp=temp.getNext();
        }
        }
        if(!this.semesterExams.isEmpty()){
        AssessmentNodeList temp1 = this.semesterExams.getStart();
        while(temp1!=null){
            newStudent.getSemesterExams().addAssessment(temp1.getAssessmentDate(), temp1.getAssessmentName());
            temp1=temp1.getNext();
        }
        }
        if(!this.listOfHomeworks.isEmpty()){
        HomeworkNodeList temp2 = this.listOfHomeworks.getStart();
        while(temp2!=null){
            newStudent.getHomeworkTracker().addHomework(temp2.getDueDate(),temp2.getHomeworkName(), temp2.getDescription());
            temp2=temp2.getNext();
        }
        }
        this.listOfStudents.add(newStudent);
        StudentManager.listOfAllStudents.add(newStudent);
    }
    
    public void addStudent(Student newStudent){
        if(quarterTests != null){
            this.quarterTests.addStudent(newStudent);
        }
        if(semesterExams != null){
            this.semesterExams.addStudent(newStudent);
        }
        if(listOfHomeworks != null){
            this.listOfHomeworks.addStudent(newStudent);
        }
        if(!this.quarterTests.isEmpty()){
        AssessmentNodeList temp = this.quarterTests.getStart();
        while(temp!=null){
            newStudent.getQuarterTests().addAssessment(temp.getAssessmentDate(), temp.getAssessmentName());
            temp=temp.getNext();
        }
        }
        if(!this.semesterExams.isEmpty()){
        AssessmentNodeList temp1 = this.semesterExams.getStart();
        while(temp1!=null){
            newStudent.getSemesterExams().addAssessment(temp1.getAssessmentDate(), temp1.getAssessmentName());
            temp1=temp1.getNext();
        }
        }
        if(!this.listOfHomeworks.isEmpty()){
        HomeworkNodeList temp2 = this.listOfHomeworks.getStart();
        while(temp2!=null){
            newStudent.getHomeworkTracker().addHomework(temp2.getDueDate(),temp2.getHomeworkName(), temp2.getDescription());
            temp2=temp2.getNext();
        }
        }
        this.listOfStudents.add(newStudent);
        StudentManager.listOfAllStudents.add(newStudent);
    }
    
    public void removeStudent(Student removalStudent){
        for(int i =0; i<listOfStudents.size();i++){
            if(listOfStudents.get(i).getId() == removalStudent.getId()){
                listOfStudents.remove(i);
            }
        }
        quarterTests.removeStudent(removalStudent);
        semesterExams.removeStudent(removalStudent);
        listOfHomeworks.removeStudent(removalStudent);
    }
    
    public void addHomework(String homeworkName, String description, Date dueDate){
        for(int i=0; i<listOfStudents.size();i++){
            listOfStudents.get(i).getHomeworkTracker().addHomework(dueDate, homeworkName, description);
            listOfStudents.get(i).getHomeworkTracker().printStack();
        }
        listOfHomeworks.addHomework(listOfStudents, homeworkName, dueDate, description);
    }
    
    public void addQuarterAssessment(String assessmentName, Date assessmentDate){
        for(int i=0; i<listOfStudents.size();i++){
            listOfStudents.get(i).getQuarterTests().addAssessment(assessmentDate, assessmentName);
        }
        quarterTests.addAssessment(listOfStudents, assessmentDate, assessmentName);
    }
    
    public void addSemesterExam(String assessmentName, Date assessmentDate){
        for(int i=0; i<listOfStudents.size();i++){
            listOfStudents.get(i).getSemesterExams().addAssessment(assessmentDate, assessmentName);
        }
        semesterExams.addAssessment(listOfStudents, assessmentDate, assessmentName);
    }
    
    public void removeHomework(String homeworkName){
        for(int i=0; i<listOfStudents.size();i++){
            listOfStudents.get(i).getHomeworkTracker().removeHomework(homeworkName);
        }
        listOfHomeworks.removeHomework(homeworkName);
    }
    
    public void removeQuarterTest(String assessmentName){
        for(int i=0; i<listOfStudents.size();i++){
            listOfStudents.get(i).getQuarterTests().removeAssessment(assessmentName);
        }
        quarterTests.removeAssessment(assessmentName);
    }
    
    public void removeSemesterExam(String assessmentName){
        for(int i=0; i<listOfStudents.size();i++){
            listOfStudents.get(i).getSemesterExams().removeAssessment(assessmentName);
        }
        semesterExams.removeAssessment(assessmentName);
    }
}
