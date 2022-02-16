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
public class Student extends Person implements Serializable{
    
    private ArrayList<HomeworkNodeList> homeworkTracker = new ArrayList<HomeworkNodeList>();
    private ArrayList<String> allEffortGrades =  new ArrayList<String>();
    private ArrayList<Character> effortInfluence = new ArrayList<Character>();
    private AssessmentStack quarterTests = new AssessmentStack();
    private AssessmentStack semesterExams = new AssessmentStack();

    public ArrayList<HomeworkNodeList> getHomeworkTracker() {
        return homeworkTracker;
    }

    public void setHomeworkTracker(ArrayList<HomeworkNodeList> homeworkTracker) {
        this.homeworkTracker = homeworkTracker;
    }

    public AssessmentStack getQuarterTests() {
        return quarterTests;
    }

    public void setQuarterTests(AssessmentStack quarterTests) {
        this.quarterTests = quarterTests;
    }

    public AssessmentStack getSemesterExams() {
        return semesterExams;
    }

    public void setSemesterExams(AssessmentStack semesterExams) {
        this.semesterExams = semesterExams;
    }

    public ArrayList<String> getAllEffortGrades() {
        return allEffortGrades;
    }

    public void setAllEffortGrades(ArrayList<String> allEffortGrades) {
        this.allEffortGrades = allEffortGrades;
    }

    public ArrayList<Character> getEffortInfluence() {
        return effortInfluence;
    }

    public void setEffortInfluence(ArrayList<Character> effortInfluence) {
        this.effortInfluence = effortInfluence;
    }

    public Student(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
    
}
