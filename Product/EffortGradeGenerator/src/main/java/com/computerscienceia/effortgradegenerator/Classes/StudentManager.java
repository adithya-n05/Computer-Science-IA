/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author adithyanarayanan
 */
public class StudentManager implements Serializable{
    public static ArrayList<Student> listOfAllStudents = new ArrayList<>();
    
    public static String[] generateStringOfStudents(){
        int size;
        String[] listOfStudents;
        if(listOfAllStudents == null){
            size = 1;
            listOfStudents = new String[size];
            return listOfStudents;
        }else{
            listOfStudents = new String[listOfAllStudents.size()];
            for(int i = 0; i<listOfAllStudents.size(); i++){
            listOfStudents[i] = listOfAllStudents.get(i).getFirstName() + " " + listOfAllStudents.get(i).getLastName() + " " + listOfAllStudents.get(i).getId();
            }
            return listOfStudents;
        }
    }
    
    public static int sizeOfStudentsArray(){
        int size;
        if(listOfAllStudents == null){
            size = 1;
            return size;
        }else{
            size = listOfAllStudents.size();
            return size;
        }

    }
}
