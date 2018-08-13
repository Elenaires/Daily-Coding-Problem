// use stack to convert character numbers to integer

import java.util.*;

public class ConvertCharToInt
{
	public static void main(String args[])
	{
		String input = "12345";
		int answer = convertCharToInt(input);
		System.out.println(input + " is " + answer);
	}

	public static int convertCharToInt(String input)
	{
		Stack<Integer> stackOfDigits = new Stack<>();
	
		for(int i = 0; i < input.length(); i++)
		{
			char characterNumber = input.charAt(i);
			if(characterNumber >= '0' && characterNumber <= '9')
			{
				int digit = characterNumber - '0';
				stackOfDigits.push(digit);
			}
		}

		int value = 0;
		int power = 1;

		while(!stackOfDigits.isEmpty())
		{
			int digit = stackOfDigits.pop();
			value += digit * power;
			power *= 10;
		}

		return value;
	}
}
