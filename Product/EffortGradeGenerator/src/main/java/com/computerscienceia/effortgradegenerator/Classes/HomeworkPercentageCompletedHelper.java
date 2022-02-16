/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.util.ArrayList;

/**
 *
 * @author adith
 */
public class HomeworkPercentageCompletedHelper {
    
    public static double calculatePercentageCompleted(ArrayList<Boolean> listCompleted){
        double numberCompleted =0;
        for(int i =0; i<listCompleted.size();i++){
            if(listCompleted.get(i)==true){
                numberCompleted++;
            }
        }
        double percentageCompletedValue = numberCompleted/((double)listCompleted.size());
        return percentageCompletedValue;
    }
    
}
