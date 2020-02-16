//Name: Hanwen Wang   ID: 260778557
public class Queue {
	
	
	public ListNode back;
	public ListNode front;

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

}
