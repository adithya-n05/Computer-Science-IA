/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import java.util.*;
import java.io.*;

/**
 *
 * @author sameer
 */
public class Student extends Person implements Serializable {

    private static final long serialVersionUID = 3L;

    private ArrayList<Double> trend = new ArrayList<Double>();

    // private ArrayList<Double> grades;
    private Map<Class, ArrayList<Double>> grade = new HashMap<Class, ArrayList<Double>>(); // this is a hashmap... basically to map class to grades for each student. https://stackoverflow.com/questions/13543457/how-do-you-create-a-dictionary-in-java
    private Map<Class, ArrayList<Double>> trends = new HashMap<Class, ArrayList<Double>>();
    private Map<Class, ArrayList<Double>> probabilities = new HashMap<Class, ArrayList<Double>>();
    private Map<Class, Double> predictedGrades = new HashMap<Class, Double>();

    double gradient = 0;

    public Student(String firstname, String surname, String schoolName, int id) {
        super(firstname, surname, schoolName, id);
    }

    public Student() {
        super();
    }

    public Map<Class, ArrayList<Double>> getTrend() {
        return this.trends;
    }

    public ArrayList<Double> getTrend(Class c) {
        return this.trends.get(c);

    }

    public void setTrend(ArrayList<Double> thing, Class c) {
        getTrend(c).clear();
        getTrend(c).addAll(thing);
    }

    public Map<Class, ArrayList<Double>> getProbabilities() {
        return this.probabilities;
    }

    public ArrayList<Double> getProbabilities(Class c) {
        return this.probabilities.get(c);
    }

    public void setProbabilities(ArrayList<Double> thing, Class c) {
        getProbabilities(c).clear();
        getProbabilities(c).addAll(thing);
    }

    public Map<Class, Double> getPredicteds() {
        return this.getPredictedGrades();
    }

    public double getPredicteds(Class c) {
        return this.getPredictedGrades().get(c);
    }

    public double max(ArrayList<Double> list) {
        if (list.size() == 0) {
            return 0.0;
        }
        double max = list.get(0);
        for (Double g : list) {
            if (g > max) {
                max = g;
            }
        }

        return max;

    }

    public double min(ArrayList<Double> list) {
        if (list.size() == 0) {
            return 0.0;
        }
        double min = list.get(0);
        for (Double g : list) {
            if (g < min) {
                min = g;
            }
        }

        return min;

    }

    public Map<Class, ArrayList<Double>> getGrades() {
        return this.grade;
    }

    public ArrayList<Double> getGrades(Class c) {
        return this.grade.get(c);
    }

    public String toString() {

        return "Name: " + this.getFirstname() + "----- id: " + this.getID();
    }

    public ArrayList<Class> getClasses() {
        ArrayList<Class> cs = new ArrayList<Class>();
        for (Class c : this.getGrades().keySet()) {

            cs.add(c);

        }
        return cs;
    }

    //yOU CANNOT SORT GRADES. ORDER MATTERS ie SEM 1 SEM 2

    /**
     * @return the predictedGrades
     */
    public Map<Class, Double> getPredictedGrades() {
        return predictedGrades;
    }

    /**
     * @param predictedGrades the predictedGrades to set
     */
    public void setPredictedGrades(Class c, Double b) {
        this.predictedGrades.replace(c, b);
    }
}
