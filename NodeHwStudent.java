/*
 * Node (element) class: building block of ADTs,
 * specifically for linked (list) implementations
 */
 
public class NodeHwStudent
{
	int  HomeworkID;
	int SetDate;
	int DueDate;
	int SetTime;
	int DueTime;

	boolean Completed;
	NodeHwStudent next; // (self-reference)
	
	public NodeHwStudent(int HomeworkID, boolean Completed)	// constructor <- allows you to create
	{
		HomeworkID = HomeworkID;
		Completed = Completed;
		next = null;
	}
	
	public boolean hasNext()
	{
		if(next == null)
			return false;
		else
			return true;
			
		// OR // return next != null;
	}


	@Override
	public String toString() {
		return "Homework ID:" + HomeworkID;
	}
}

