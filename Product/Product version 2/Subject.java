package effortgradepredictor.computerscienceia;

import java.util.*;

public class Subject {
    private String NameofSubject;
    private boolean HL;

    public Subject(String nameofSubject, boolean HL) {
        NameofSubject = nameofSubject;
        this.HL = HL;
    }

    public String getNameofSubject() {
        return NameofSubject;
    }

    public void setNameofSubject(String nameofSubject) {
        NameofSubject = nameofSubject;
    }

    public boolean isHL() {
        return HL;
    }

    public void setHL(boolean HL) {
        this.HL = HL;
    }
}
