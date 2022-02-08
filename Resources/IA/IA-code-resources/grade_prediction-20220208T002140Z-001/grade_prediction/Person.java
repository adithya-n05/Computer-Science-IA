/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade_prediction;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author sameer
 */
public abstract class Person implements Serializable {

    private String firstname;
    private String surname;
    protected String schoolName;
    private int id;
    private transient String password;
    private transient String username;

    protected Person(String firstname, String surname, String schoolName, int id) {
        this.firstname = firstname;
        this.surname = surname;
        this.schoolName = schoolName;
        this.id = id;
    }

    protected Person() {
    }

    public void setU(String username) {
        this.setUsername(username);
    }

    public void setP(String password) {
        this.setPassword(password);
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String fname) {
        this.firstname = fname;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSchoolName() { //no need to change school... or else the person would even be in the system
        return this.schoolName;
    }

    public int getID() { //no setter cause this is a final
        return this.id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public abstract String toString(); //to make code more modular

}
