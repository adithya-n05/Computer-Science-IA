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
public class ArrayListHelper{
    
    public static int partitionInt(ArrayList<ArrayList<Integer>> arrayinput, int low, int high)
    {
        int pivot = arrayinput.get(high).get(0); 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arrayinput.get(j).get(0) <= pivot)
            {
                i++;
                ArrayList<Integer> temp = arrayinput.get(i);
                arrayinput.set(i, arrayinput.get(j));
                arrayinput.set(j, temp);
            }
        }

        ArrayList<Integer> temp = arrayinput.get(i+1);
        arrayinput.set(i+1, arrayinput.get(high));
        arrayinput.set(high, temp);
  
        return i+1;
    }
    
    public static int partitionDouble(ArrayList<ArrayList<Double>> arrayinput, int low, int high)
    {
        double pivot = arrayinput.get(high).get(0); 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arrayinput.get(j).get(0) <= pivot)
            {
                i++;
                ArrayList<Double> temp = arrayinput.get(i);
                arrayinput.set(i, arrayinput.get(j));
                arrayinput.set(j, temp);
            }
        }

        ArrayList<Double> temp = arrayinput.get(i+1);
        arrayinput.set(i+1, arrayinput.get(high));
        arrayinput.set(high, temp);
  
        return i+1;
    }
    
    public static int partitionTeacher(ArrayList<Teacher> arrayinput, int low, int high)
    {
        int pivot = arrayinput.get(high).getId(); 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arrayinput.get(j).getId() <= pivot)
            {
                i++;
                Teacher temp = arrayinput.get(i);
                arrayinput.set(i, arrayinput.get(j));
                arrayinput.set(j, temp);
            }
        }

        Teacher temp = arrayinput.get(i+1);
        arrayinput.set(i+1, arrayinput.get(high));
        arrayinput.set(high, temp);
  
        return i+1;
    }
  
    public static void sortInt(ArrayList<ArrayList<Integer>> arrayinput, int low, int high)
    {
        if (low < high)
        {
            int pi = partitionInt(arrayinput, low, high);
            sortInt(arrayinput, low, pi-1);
            sortInt(arrayinput, pi+1, high);
        }
    }
    
    public static void sortDouble(ArrayList<ArrayList<Double>> arrayinput, int low, int high)
    {
        if (low < high)
        {
            int pi = partitionDouble(arrayinput, low, high);
            sortDouble(arrayinput, low, pi-1);
            sortDouble(arrayinput, pi+1, high);
        }
    }
    
    public static void sortTeacher(ArrayList<Teacher> arrayinput, int low, int high)
    {
        if (low < high)
        {
            int pi = partitionTeacher(arrayinput, low, high);
            sortTeacher(arrayinput, low, pi-1);
            sortTeacher(arrayinput, pi+1, high);
        }
    }
    
    public static int binarySearchInt(ArrayList<ArrayList<Integer>> inputArray, int id) {
        boolean found = false;
        int low = 0;
        int high = inputArray.size() - 1;
        int location = -1;
        int index;
        while (low <= high && found == false) {
            index = low + ( high - low ) / 2;
            if (id == inputArray.get(index).get(0)) {
                found = true;
                location = index;
            } else {
                if (id < inputArray.get(index).get(0)){
                    high = index - 1;
                } else {
                    low = index + 1;
                }
            }
        }
        return location;
    }
    
    public static int binarySearchDouble(ArrayList<ArrayList<Double>> inputArray, int id) {
        boolean found = false;
        int low = 0;
        int high = inputArray.size() - 1;
        int location = -1;
        int index;
        while (low <= high && found == false) {
            index = ( low + high ) / 2;
            if ((double) id == inputArray.get(index).get(0)) {
                found = true;
                location = index;
            } else {
                if ((double)id < inputArray.get(index).get(0)){
                    high = index - 1;
                } else {
                    low = index + 1;
                }
            }
        }
        return location;
    }
    
    public static int binarySearchTeacher(ArrayList<Teacher> inputArray, int id) {
        boolean found = false;
        int low = 0;
        int high = inputArray.size() - 1;
        int location = -1;
        int index;
        while (low <= high && found == false) {
            index = ( low + high ) / 2;
            if (id == inputArray.get(index).getId()) {
                found = true;
                location = index;
            } else {
                if (id < inputArray.get(index).getId()){
                    high = index - 1;
                } else {
                    low = index + 1;
                }
            }
        }
        return location;
    }


}
