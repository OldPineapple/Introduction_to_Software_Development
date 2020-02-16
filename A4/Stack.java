//Name: Hanwen Wang   ID: 260778557
public class Stack {

	public ListNode top;
//push string to the bottom of stack and continue to assemble on the top of another
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
//form top to bottom, pop string out
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
//check whether stack is empty
	public boolean isEmpty() {
		if (top==null)
		return true;
		else
		return false;
	}
}