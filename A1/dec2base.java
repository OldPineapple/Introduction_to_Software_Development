//Name: Hanwen Wang
//McGill ID: 260778557

import java.util.Scanner;

public class dec2base 
{	
	//Method that is used to do calculation and store all value in a string.
	private static String dec2B(int number,int base)
	{
		String Num="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int remainder;
		String s="";
		while (number>0)
		{
			remainder=number%base;
			number=number/base;
			s=s+Num.charAt(remainder);
		}
		return s;
	}
	
	//Method that is used to reverse the sequence of numbers store in the string.
	private static String reverseString(String result)
	{
		String news="";
		for(int i=result.length()-1;i>=0;i--)
		{
			news=news+result.charAt(i);
		}
		return news;
	}
	
	//run the program, both input and output are defined here
	public static void main(String[] args)
	{	
		Scanner input=new Scanner(System.in);
		System.out.print("Enter number to be converted: ");
		int number=input.nextInt();
		System.out.print("Enter base to convert to: ");
		int base=input.nextInt();
		String result=dec2B(number,base);
		System.out.println(""+number+" is represented in Base-"+base+" as "+reverseString(result));
	}
}
