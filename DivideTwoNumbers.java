/* daily coding problem #88 
* divide two positive integers without division,
* multiplication and modulus operators
*/

import java.util.*;
import java.lang.*;

public class DivideTwoNumbers
{
	public static void main(String[] args)
	{
		int a = 10;
		int b = 10;
		
		try
		{
			int result = divide(a, b);
			System.out.println(result);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public static int divide(int a, int b)
	{
		if(b == 0)
		{
			throw new IllegalArgumentException("cannot divide by zero");
		}
	
		int quotient = 0;
		
		while(a >= b)
		{
			a -= b;
			quotient++;
		}

		return quotient;

		// for negative integers
		//int sign = ((a < 0) ^ (b < 0)) ? -1 : 1;
		// also need to do Math.abs(a) & Math.abs(b)
		//return quotient * sign;	
	}
}
