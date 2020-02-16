//Name:Hanwen Wang       ID:260778557
public class Stack {
	
	listNode top;
	//method of push into a stack
	public void push(String str)
	{
		listNode a = new listNode(str);
		a.next=top;
		top = a;
	}
	//method of pop out of a string
	public String pop()
	{
		if(top == null)
		{
			return null;
		}		
		else
		{
			listNode pretop = top;
			top=top.next;
			return pretop.value;
		}		
	}
	//check whether the stack is empty
	public boolean isEmpty() {
		if (top==null)
		return true;
		else
		return false;
	}
}
