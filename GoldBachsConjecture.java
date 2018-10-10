/* daily coding problem #101 */

/* Given an even number (greater than 2), 
* return two prime numbers whose sum will be 
* equal to the given number.
*/

// 1) get all the primes smaller than the number
// 2) since the primes are sorted, use 2 pointers
//    to find the 2 primes whose sum is equal to the number

import java.util.*;

public class GoldBachsConjecture
{
	public static void main(String[] args)
	{
		int num = 678340;
		List<Integer> result = findTwoPrimes(num);

		for(int a : result)
		{
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static List<Integer> findTwoPrimes(int num)
	{
		List<Integer> result = new ArrayList<>();
		boolean[] arr = getPrimes(num);
		
		int i = 2;
		int j = arr.length - 1;

		boolean found = false;
		while(i <= j && !found)
		{
			if(!arr[i] || !arr[j])
			{
				if(!arr[i])
				{
					i++;
				}
				if(!arr[j])
				{
					j--;
				}
			}
			else if(i + j != num)
			{
				if(i + j > num)
				{
					j--;
				}
				else
				{
					i++;
				}
			}
			else if(i + j == num)
			{
				found = true;

				// to produce multiple solutions
				//result.add(i);
				//result.add(j);
				//i++;
			}
		}		
		
		result.add(i);
		result.add(j);

		return result;
	}

	public static boolean[] getPrimes(int num)
	{
		// array of size num (not num + 1) because
		// we only need all primes smaller than num
		// for this problem since we are looking for
		// the sum of 2 primes
		boolean[] arr = new boolean[num];
		Arrays.fill(arr, true);

		// mark 0 and 1 as not prime
		arr[0] = false;
		arr[1] = false;

		for(int i = 2; i*i <= num; i++)
		{
			if(arr[i])
			{
				for(int j = i*2; j < arr.length; j += i)
				{
					arr[j] = false;
				}
			}
		} 

		return arr;
	}
}
