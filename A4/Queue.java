//Name: Hanwen Wang   ID: 260778557
public class Queue {
	
	
	public ListNode back;
	public ListNode front;
//add a string to the front of a queue and continue to add to the back of each front
	public void Enqueue(String newstring)
	{
		ListNode new_node = new ListNode(newstring);
		if(back == null)
		{
			back = new_node;
			front = new_node;
			
		}else
		{
			new_node.next = back;
			back.previous = new_node;
			back = new_node;
		}
	}
	//put string out of the queue from front to back
	public String Dequeue()
	{
		if(front == null)
		{
			System.out.println("Error: the queue is empty");
			return null;
		}

		String result = front.keyval;
		
		if(front.previous == null)
		{			
			front = null;
			back = null;
		}else
		{
			ListNode prefront = front.previous;
			prefront.next = null;
			front = prefront;
		}
		
		return result;
	}
	//check whether queue is empty
	public boolean isEmpty() {
		if (front==null)
		return true;
		else
		return false;
	}
}
