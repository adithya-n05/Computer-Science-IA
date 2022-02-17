/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

/**
 *
 * @author adith
 */
public class EffortGradeCalculator {
    public static double calculateWeightedEMA(double EMASemesterExams, double EMAQuarterTests){
        System.out.println(EMAQuarterTests);
        System.out.println(EMASemesterExams);
        return(((0.7)*(EMASemesterExams)) + ((0.3) * (EMAQuarterTests)));
    }
    
    public static String CalculateEffortGrade(double EMASemesterExams, double EMAQuarterTests, double homeworkCompletionRate, String score){
        double scoreWeighting = 0;
        double testWeighting = calculateWeightedEMA(EMASemesterExams, EMAQuarterTests);
        double finalWeighting = 0;
        if(score.equals("U")){
            scoreWeighting = 25.0;
        }else if(score.equals("S")){
            scoreWeighting = 50.0;
        }else if(score.equals("G")){
            scoreWeighting = 75.0;
        }else if(score.equals("E")){
            scoreWeighting = 100.0;
        }
        testWeighting = (testWeighting/7.9)*100;
        finalWeighting = ((0.25) * scoreWeighting) + (0.25 * homeworkCompletionRate) + (0.5*testWeighting);
        
        String EffortGrade = "U";
        
        if(finalWeighting<25.0){
            EffortGrade = "U";
        }else if(finalWeighting < 50.0){
            EffortGrade = "S";
        }else if(finalWeighting<75.0){
            EffortGrade = "G";
        }else{
            EffortGrade = "E";
        }
        
        return EffortGrade;
    }
    
}
