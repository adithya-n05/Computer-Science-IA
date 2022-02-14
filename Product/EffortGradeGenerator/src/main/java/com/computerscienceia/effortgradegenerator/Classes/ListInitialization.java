/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;
import com.computerscienceia.effortgradegenerator.GUI.EffortGradeGenerator;
import java.util.ArrayList;


/**
 *
 * @author adithyanarayanan
 */
public class ListInitialization {
    public static String[] listOfClassesAsStrings(){
       ArrayList<Class> listOfClasses = EffortGradeGenerator.primaryTeacher.getClasses();
       String[] listOfClassesAsStrings = new String[listOfClasses.size()];
       String HLAdder = "";
       for(int i =0; i<listOfClasses.size(); i++){
           if(listOfClasses.get(i).isIsHL()){
               HLAdder = "HL";
           }else{
               HLAdder = "SL";
           }
           listOfClassesAsStrings[i] = listOfClasses.get(i).getClassName() + " " + HLAdder;
       }
       return listOfClassesAsStrings;
    }
    
    public static String[] listOfStudentsAsStrings(){
       Class mainClass = EffortGradeGenerator.primaryClass;
       ArrayList<Student> listOfStudents = mainClass.getListOfStudents();
       int size =0;
       if(listOfStudents == null){
           size = 1;
           String[] listOfStudentsStringsBlank = new String[size];
           return listOfStudentsStringsBlank;
       }else{
           size = listOfStudents.size();
           String[] listOfStudentsStrings = new String[size];
       for(int i =0; i<size; i++){
           listOfStudentsStrings[i] = listOfStudents.get(i).getFirstName() + " " + listOfStudents.get(i).getLastName() + " " + listOfStudents.get(i).getId();
           
       }
       return listOfStudentsStrings;
       }     
    }
    
    public static String[] listOfQuarterAssessmentsAsStrings(){
       Class mainClass = EffortGradeGenerator.primaryClass;
       AssessmentLinkedList listOfTests = mainClass.getQuarterTests();
       int size =0;
       if(listOfTests == null){
           size = 1;
           String[] listOfStudentsStringsBlank = new String[size];
           return listOfStudentsStringsBlank;
       }else{
           size = listOfTests.length();
           String[] listOfStudentsStrings = new String[size];
           AssessmentNode temp = listOfTests.getStart();
           int i =0;
            while (temp.hasNext()) {
                listOfStudentsStrings[i] = temp.getAssessmentName();
                temp = temp.getNext();
                i++;
            }
            return listOfStudentsStrings;

       }
    }
    
    public static String[] listOfSemesterExamsAsStrings(){
       Class mainClass = EffortGradeGenerator.primaryClass;
       AssessmentLinkedList listOfTests = mainClass.getSemesterExams();
       int size =0;
       if(listOfTests == null){
           size = 1;
           String[] listOfStudentsStringsBlank = new String[size];
           return listOfStudentsStringsBlank;
       }else{
           size = listOfTests.length();
           String[] listOfStudentsStrings = new String[size];
           AssessmentNode temp = listOfTests.getStart();
           int i =0;
            while (temp.hasNext()) {
                listOfStudentsStrings[i] = temp.getAssessmentName();
                temp = temp.getNext();
                i++;
            }
            return listOfStudentsStrings;

       }
    }
    
    public static String[] listOfHomeworksAsStrings(){
       Class mainClass = EffortGradeGenerator.primaryClass;
       HomeworkLinkedList listOfTests = mainClass.getListOfHomeworks();
       int size =0;
       if(listOfTests == null){
           size = 1;
           String[] listOfStudentsStringsBlank = new String[size];
           return listOfStudentsStringsBlank;
       }else{
           size = listOfTests.length();
           String[] listOfStudentsStrings = new String[size];
           HomeworkNode temp = listOfTests.getStart();
           int i =0;
            while (temp.hasNext()) {
                listOfStudentsStrings[i] = temp.getHomeworkName();
                temp = temp.getNext();
                i++;
            }
            return listOfStudentsStrings;

       }
    }
}
