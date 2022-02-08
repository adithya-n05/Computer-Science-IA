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
public class Subject implements Serializable {

    private String subjectName;
    private boolean hl;

    public Subject(String name, boolean HL) {
        this.subjectName = name;
        this.hl = HL;
    }

    public Subject(boolean HL, String name) {
        this.subjectName = name;
        this.hl = HL;
    }

    public boolean isHL() {
        return this.hl;
    }

    public void HLSL(String level) { //add validation

        if (level.equalsIgnoreCase("hl")) {
            this.hl = true;
        } else if (level.equalsIgnoreCase("sl")) {
            this.hl = false;
        }
        return;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String name) {
        this.subjectName = name;
    }
}
