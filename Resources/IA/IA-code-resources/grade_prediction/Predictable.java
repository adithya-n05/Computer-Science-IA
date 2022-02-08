/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import java.util.ArrayList;
import java.io.*;

@FunctionalInterface
public interface Predictable { 
//there are many algorithms for prediction, 
//so im using lambda expressions to and an interface to make different prediction algorithms

    public double predict(ArrayList<Double> grades, ArrayList<Double> attributes, Student s);

    default void viewTrend(ArrayList<Double> grades) {
        System.out.println("Nothing");
    }

}
