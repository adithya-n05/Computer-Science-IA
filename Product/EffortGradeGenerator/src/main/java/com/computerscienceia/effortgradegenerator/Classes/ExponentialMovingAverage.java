/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.util.ArrayList;
import java.lang.Math;

/**
 *
 * @author adith
 */
public class ExponentialMovingAverage {
    private double multiplier;

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public ExponentialMovingAverage() {
        this.multiplier = 0.0;
    }
    
    public void calculateEMAMultiplier(ArrayList<Double> scores){
        this.multiplier=2 / (scores.size()+1);
    }
    
    
    public double calculateEMA(ArrayList<Double> scores){
        double numerator = 0.0;
        double denominator = 0.0;
        for (int i =0; i<scores.size();i++){
            numerator+= scores.get(i)*(Math.pow(1-multiplier, i));
            denominator+= Math.pow((1-multiplier), i);
        }
        double EMA = numerator/denominator;
        return EMA;
    }
    
}
