/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.computerscienceia.effortgradegenerator.Classes;

import java.util.Date;

/**
 *
 * @author adith
 */
public class HomeworkNode {
    private String homeworkName;
    private String description;
    private Date dueDate;

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public HomeworkNode(String homeworkName, String description, Date dueDate) {
        this.homeworkName = homeworkName;
        this.description = description;
        this.dueDate = dueDate;
    }

}
