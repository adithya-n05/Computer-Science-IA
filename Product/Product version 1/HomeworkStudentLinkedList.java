public class HomeworkStudentLinkedList
{
	NodeHwStudent start;		// beginning/head/access point of the L. List

	public boolean isEmpty()
	{	return start == null;
	}
	
	public void append(int HomeworkID, boolean Completed)
	{	NodeHwStudent newNode = new NodeHwStudent(HomeworkID, Completed);
		if( isEmpty() )
		{	start = newNode;
			return;
		}
		NodeHwStudent temp = start;
		// while( temp.next != null ) // also, ...
		while( temp.hasNext() )
		{	temp = temp.next;
		}
		temp.next = newNode;
	}
	
	public void printList()
	{	
		if( isEmpty() )
		{	System.out.println("List is empty");
			return;
		}
		NodeHwStudent temp = start;
		System.out.print("Start -> ");
		while(temp != null)
		{	System.out.print(temp.HomeworkID + " ");
			temp = temp.next;
		}
		System.out.println(); //" <- End");
	}
	
	public void remove(int element)
	{
		if( isEmpty() == true )
		{	System.out.println("ERROR - List is empty.");
			return;
		}
		if( element == start.HomeworkID )
		{	start = start.next;
			return;
		}
		NodeHwStudent temp1 = start;
		NodeHwStudent temp2 = start.next;
		while(temp2 != null)
		{	if(temp2.HomeworkID == element)
			{	temp1.next = temp2.next;
				return; // removing this does something!
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
	}
	
	public void insertInOrder(int HomeworkID, boolean Completed)
	{	
		NodeHwStudent newNode = new NodeHwStudent(HomeworkID, Completed);
		if( isEmpty() || HomeworkID < start.HomeworkID )
		{	newNode.next = start;
			start = newNode;
		} else {
			NodeHwStudent previous = start;
			NodeHwStudent current  = start.next;
			while(current != null && 
					current.HomeworkID < newNode.HomeworkID)
			{	previous = previous.next;
				current  = current.next;
			}
			newNode.next = current;
			previous.next = newNode;
		}
	}
	
}

