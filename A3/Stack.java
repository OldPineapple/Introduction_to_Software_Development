//Name: Hanwen Wang   ID: 260778557
public class Stack {

	public ListNode top;

	public void push(String newstring)
	{
		ListNode next_token = new ListNode(newstring);
		
		if(top != null)
		{		
			top.next = next_token;
			next_token.previous = top;		
		}
		top = next_token;
		
	}

	public String pop()
	{
		if(top == null)
		{
			System.out.println("Error: empty stack");
			return null;
		}
		
		String result = top.keyval;		
		if(top.previous == null)
		{
			top = null;  
		}
		else
		{
			ListNode pretop = top.previous;
			pretop.next = null;
			top = pretop;
			
		}			
		return result;
	}

	public boolean isEmpty() {
		if (top==null)
		return true;
		else
		return false;
	}
	

}
