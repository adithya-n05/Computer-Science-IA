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
       if(listOfStudents.size() == 0){
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
    
    public static String[] listOfStudentsAsStringsHomework(){
       Class mainClass = EffortGradeGenerator.primaryClass;
       ArrayList<Student> listOfStudents = mainClass.getListOfStudents();
       int size =0;
       if(listOfStudents.size() == 0){
           size = 1;
           String[] listOfStudentsStringsBlank = new String[size];
           return listOfStudentsStringsBlank;
       }else{
           size = listOfStudents.size();
           String[] listOfStudentsStrings = new String[size];
       for(int i =0; i<size; i++){
           listOfStudentsStrings[i] = listOfStudents.get(i).getFirstName() + " " + listOfStudents.get(i).getLastName() + " " + listOfStudents.get(i).getId() + " - " + listOfStudents.get(i).getHomeworkTracker().getHomeworkcompleted(EffortGradeGenerator.primaryHomework);
           
       }
       return listOfStudentsStrings;
       }     
    }
    
    public static String[] listOfStudentsAsStringsQuarterAssessment(){
       Class mainClass = EffortGradeGenerator.primaryClass;
       ArrayList<Student> listOfStudents = mainClass.getListOfStudents();
       int size =0;
       if(listOfStudents.size() == 0){
           size = 1;
           String[] listOfStudentsStringsBlank = new String[size];
           return listOfStudentsStringsBlank;
       }else{
           size = listOfStudents.size();
           String[] listOfStudentsStrings = new String[size];
       for(int i =0; i<size; i++){
           listOfStudentsStrings[i] = listOfStudents.get(i).getFirstName() + " " + listOfStudents.get(i).getLastName() + " " + listOfStudents.get(i).getId() + " - " + listOfStudents.get(i).getQuarterTests().getAssessmentScore(EffortGradeGenerator.primaryQuarterTest);
           
       }
       return listOfStudentsStrings;
       }     
    }
    
    public static String[] listOfStudentsAsStringsSemesterExam(){
       Class mainClass = EffortGradeGenerator.primaryClass;
       ArrayList<Student> listOfStudents = mainClass.getListOfStudents();
       int size =0;
       if(listOfStudents.size() == 0){
           size = 1;
           String[] listOfStudentsStringsBlank = new String[size];
           return listOfStudentsStringsBlank;
       }else{
           size = listOfStudents.size();
           String[] listOfStudentsStrings = new String[size];
       for(int i =0; i<size; i++){
           listOfStudentsStrings[i] = listOfStudents.get(i).getFirstName() + " " + listOfStudents.get(i).getLastName() + " " + listOfStudents.get(i).getId() + " - " + listOfStudents.get(i).getSemesterExams().getAssessmentScore(EffortGradeGenerator.primarySemesterExam);
           
       }
       return listOfStudentsStrings;
       }     
    }
    
    public static String[] listOfQuarterAssessmentsAsStrings(){
       Class mainClass = EffortGradeGenerator.primaryClass;
       AssessmentLinkedList listOfTests = mainClass.getQuarterTests();
       int size =0;
       if(listOfTests.getStart() == null){
           size = 1;
           String[] listOfStudentsStringsBlank = new String[size];
           return listOfStudentsStringsBlank;
       }else{
           size = listOfTests.length();
           String[] listOfStudentsStrings = new String[size];
           AssessmentNodeList temp = listOfTests.getStart();
           int i =0;
            while (temp !=null) {
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
       if(listOfTests.getStart() == null){
           size = 1;
           String[] listOfStudentsStringsBlank = new String[size];
           return listOfStudentsStringsBlank;
       }else{
           size = listOfTests.length();
           String[] listOfStudentsStrings = new String[size];
           AssessmentNodeList temp = listOfTests.getStart();
           int i =0;
            while (temp != null) {
                listOfStudentsStrings[i] = temp.getAssessmentName();
                temp = temp.getNext();
                i++;
            }
            return listOfStudentsStrings;

       }
    }
    
    public static String[] listOfHomeworksAsStrings(){
       Class mainClass = EffortGradeGenerator.primaryClass;
       HomeworkLinkedList listOfHomeworks = mainClass.getListOfHomeworks();
       int size =0;
       if(listOfHomeworks.getStart() == null){
           size = 1;
           String[] listOfStudentsStringsBlank = new String[size];
           return listOfStudentsStringsBlank;
       }else{
           size = listOfHomeworks.length();
           String[] listOfStudentsStrings = new String[size];
           HomeworkNodeList temp = listOfHomeworks.getStart();
           int i =0;
           while (temp != null) {
               listOfStudentsStrings[i] = temp.getHomeworkName();
               temp = temp.getNext();
               i++;
           }
           return listOfStudentsStrings;

       }
    }
    
    public static ArrayList<ArrayList<Integer>> calculateListOfStudentsIntsAndBoolean(ArrayList<Student> listOfStudents){
        ArrayList<ArrayList<Integer>> listOfStudentsAsInts = new ArrayList<ArrayList<Integer>>();
        for(int i =0; i<listOfStudents.size(); i++){
            Student student = listOfStudents.get(i);
            int id = student.getId();
            listOfStudentsAsInts.add(new ArrayList<>());
            listOfStudentsAsInts.get(i).add(0, id);
        }
        return listOfStudentsAsInts;
    }
    
}
