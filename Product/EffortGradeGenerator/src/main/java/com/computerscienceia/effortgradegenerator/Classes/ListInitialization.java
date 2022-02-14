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
       for(int i =0; i<listOfClasses.size(); i++){
           listOfClassesAsStrings[i] = listOfClasses.get(i).getClassName();
       }
       return listOfClassesAsStrings;
    }
    
    public static String[] listOfStudentsAsStrings(){
       Class mainClass = EffortGradeGenerator.primaryClass;
       ArrayList<Student> listOfStudents = mainClass.getListOfStudents();
       int size =0;
       if(listOfStudents.isEmpty()){
           size = 0;
           String[] listOfStudentsStringsBlank = new String[size];
           return listOfStudentsStringsBlank;
       }else{
           size = listOfStudents.size();
           String[] listOfStudentsStrings = new String[size];
       for(int i =0; i<size; i++){
           listOfStudentsStrings[i] = listOfStudents.get(i).getFirstName() + " " + listOfStudents.get(i).getLastName();
           
       }
       return listOfStudentsStrings;
       }     
    }
}
