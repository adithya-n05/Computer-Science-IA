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
public class ArrayListHelper {

    public ArrayListHelper() {
    }
    
    public int partition(ArrayList<ArrayList<Integer>> arrayinput, int low, int high)
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
  
    public void sort(ArrayList<ArrayList<Integer>> arrayinput, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arrayinput, low, high);
            sort(arrayinput, low, pi-1);
            sort(arrayinput, pi+1, high);
        }
    }

}
