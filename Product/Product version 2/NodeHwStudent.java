package effortgradepredictor.computerscienceia;

import java.io.*;

public class NodeHwStudent implements Serializable{
	private int HomeworkID;
	private int SetDate;
	private int DueDate;
	private int SetTime;
	private int DueTime;
        private String Description;
	private boolean Completed;
	NodeHwStudent next;

    public int getHomeworkID() {
        return HomeworkID;
    }

    public void setHomeworkID(int HomeworkID) {
        this.HomeworkID = HomeworkID;
    }

    public int getSetDate() {
        return SetDate;
    }

    public void setSetDate(int SetDate) {
        this.SetDate = SetDate;
    }

    public int getDueDate() {
        return DueDate;
    }

    public void setDueDate(int DueDate) {
        this.DueDate = DueDate;
    }

    public int getSetTime() {
        return SetTime;
    }

    public void setSetTime(int SetTime) {
        this.SetTime = SetTime;
    }

    public int getDueTime() {
        return DueTime;
    }

    public void setDueTime(int DueTime) {
        this.DueTime = DueTime;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public boolean isCompleted() {
        return Completed;
    }

    public void setCompleted(boolean Completed) {
        this.Completed = Completed;
    }

    public NodeHwStudent(int HomeworkID, int SetDate, int DueDate, int DueTime, String Description, boolean Completed) {
        this.HomeworkID = HomeworkID;
        this.SetDate = SetDate;
        this.DueDate = DueDate;
        this.DueTime = DueTime;
        this.Description = Description;
        this.Completed = Completed;
        next = null;
    }
	
    public boolean hasNext(){
		if(next == null)
			return false;
		else
			return true;
	}
    
    @Override
    public String toString() {
        return "NodeHwStudent{" + "HomeworkID=" + HomeworkID + ", SetDate=" + SetDate + ", DueDate=" + DueDate + ", SetTime=" + SetTime + ", DueTime=" + DueTime + ", Description=" + Description + ", Completed=" + Completed + '}';
    }
	
}

