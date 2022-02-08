/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author adith
 */
public class Teacher extends Person implements Serializable{
    private ArrayList<Class> classes = new ArrayList<Class>();

    public Teacher(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
    
    
}
