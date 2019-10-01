/*
Name : Elenaires
College Name : Curtin
Year/Department : I/Comp Sci
E-Mail Id : 15650635@curtin.edu.au
*/

import java.util.*;

public class BalancedParentheses {
	public static void main(String[] args)
	{
		String s = "{(){}{{)}}}";
		System.out.println(balance(s));
	}

	public static boolean balance(String expression)
	{
		if(expression.length() == 0)
		{
			return true;
		}

		if(expression.length() % 2 != 0)
		{
			return false;
		}
		
		Stack<Character> stack = new Stack<>();

		char c;
		for(int i = 0; i < expression.length(); i++)
		{
			c = expression.charAt(i);	

			// opening braces	
			if(c == '(' || c == '[' || c == '{')
			{
				stack.push(c);
			}

			// closing braces
			else 
			{
				if(!stack.isEmpty()) 
				{
					char top = stack.peek();
					if(isMatching(top, c))
					{
						stack.pop();
					}
					else 
					{
						return false;
					}
				}
				else 
				{
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	private static boolean isMatching(char top, char current)
	{
		return (top == '(' && current == ')') ? true : (top == '[' && current == ']') ? true : (top == '{' && current == '}') ? true : false; 
	}
}
