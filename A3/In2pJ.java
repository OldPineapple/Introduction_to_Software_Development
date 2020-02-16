//Name: Hanwen Wang   ID: 260778557
import java.util.StringTokenizer; 
import acm.program.ConsoleProgram;

public class In2pJ extends ConsoleProgram { 
	public void run() {
		Queue output= new Queue();
		Stack operator= new Stack();

		String str = readLine("Enter string: ");
		StringTokenizer st = new StringTokenizer(str,"+-*/()",true); 
		while (st.hasMoreTokens()) {
			String token=st.nextToken(); 

			if (token.equals("+") || 
					token.equals("-") || 
					token.equals("*") || 
					token.equals("/")){

				if (operator.isEmpty()==true){
					operator.push(token);
				}
				else if(token_pre(token)<=top_pre(operator.top)){
					while(operator.top!=null&&token_pre(token)<=top_pre(operator.top)){
						String opout=operator.pop();
						output.Enqueue(opout);
					}
					operator.push(token);
				}
				else{
					operator.push(token);
				}
			}

			else if (token.equals("(")){
				operator.push(token);
			}
			else if (token.equals(")")){
				while (operator.top!=null&&!operator.top.keyval.equals("(")){
					output.Enqueue(operator.pop());
				}
				operator.pop();
			}

			else{
				output.Enqueue(token);
			}
		}
		while (operator.isEmpty()!=true){
			output.Enqueue(operator.pop());
		}
		print("Postfix:");
		while(output.front!=null){
			print(output.Dequeue()+" ");
		}
	}
	public int top_pre(ListNode top) {
		int precedence = 0;
		if(top.keyval.equals("+")|| top.keyval.equals("-")) {
			precedence = 2;
		}
		else if(top.keyval.equals("*") || top.keyval.equals("/")) {
			precedence = 3;
		}


		return precedence;
	}

	public int token_pre(String token) {
		int precedence = 0;
		if(token.equals("+")|| token.equals("-")) {
			precedence = 2;
		}
		else if(token.equals("*") || token.equals("/")) {
			precedence = 3;
		}

		return precedence;
	}
}