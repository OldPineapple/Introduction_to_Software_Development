//Name: Hanwen Wang   ID: 260778557
import java.util.StringTokenizer; 
import acm.program.ConsoleProgram;

public class JCalcS extends ConsoleProgram { 
	public void run() {
		Queue output= new Queue();
		Stack operator= new Stack();
//read what have entered
		String str = readLine("Enter expression(blank line to exit): ");
		StringTokenizer st = new StringTokenizer(str,"+-*/()",true); 
		while (st.hasMoreTokens()) {
			String token=st.nextToken(); 
//the process of checking whether string entered is an operator
			if (token.equals("+") || 
					token.equals("-") || 
					token.equals("*") || 
					token.equals("/")){
//push the string if the stack is empty
				if (operator.isEmpty()==true){
					operator.push(token);
				}
				//the process of compare the top of the stack's precedence and the token's precedence
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
//bracket situation
			else if (token.equals("(")){
				operator.push(token);
			}
			else if (token.equals(")")){
				while (operator.top!=null&&!operator.top.keyval.equals("(")){
					output.Enqueue(operator.pop());
				}
				operator.pop();
			}
//other situation
			else{
				output.Enqueue(token);
			}
		}
		//enqueue process
		while (operator.isEmpty()!=true){
			output.Enqueue(operator.pop());
		}
		evaluation(output);

	}
	//precedence of stack top
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
//precedence of token
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
	public void evaluation(Queue output)
	{
		Stack dequeue_value=new Stack();
		int number=0;
		while(!output.isEmpty()){
			String val=output.Dequeue();
			//if the string is not an operand, push to stack
			if (!val.equals("+") && !val.equals("-") && !val.equals("*") && !val.equals("/")&&!val.equals("(")&&!val.equals(")"))
			{
				dequeue_value.push(val);
			}
			//if the string is an operand, pop two value from stack
			else
			{
				number++;
				String operand2=dequeue_value.pop();
				String operand1=dequeue_value.pop();
/*				double operand2val=Double.parseDouble(operand2);
				double operand1val=Double.parseDouble(operand1);*/
				String eval_counter="Eval"+number;
				String eval_equal="<"+operand1+val+operand2+">";
				dequeue_value.push(eval_counter);
				System.out.println(eval_counter+":"+eval_equal);
				//precise calculation of this method(which is not required in this assignment)
/*				double result=0;
				if(val.compareTo("+")==0)
					result=operand1val+operand2val;
				else if(val.compareTo("-")==0)
					result=operand1val+operand2val;
				else if(val.compareTo("*")==0)
					result=operand1val*operand2val;
				else if(val.compareTo("/")==0)
					result=operand1val/operand2val;*/
			}
		}
	}
}