/* daily coding problem #102
* 
* Given an array of non-negative numbers,
* find continuous subarray with sum to S.
*
* keyword - non-negative (adding a number will increase the sum, 
* stop adding when the sum is greater than S and think of removing
* previous numbers
* 
* keyword - continuous
*/

import java.util.*;

public class SubArrayWithGivenSum
{
	public static void main(String[] args)
	{
		int s = 0;
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 4, 20, 3, 10, 5));
		List<Integer> result = findSubArray(numbers, s); 

		if(result == null)
		{
			System.out.println("no subarray found");
		}
		else
		{
			for(int a : result)
			{
				System.out.print(a + " ");
			}
			System.out.println();
		}
		
	}

	public static List<Integer> findSubArray(List<Integer> numbers, int s)
	{
		List<Integer> result = new ArrayList<>();

		int start = 0, sum = numbers.get(0);

		int i = 1;

		boolean found = false;

		while(i <= numbers.size() && !found)
		{
			while(sum > s && start < i-1)
			{
				sum -= numbers.get(start);
				start++;
				System.out.println(sum);
			}
		
			if(sum == s)
			{
				found = true;
			}

			if(i < numbers.size())
			{
				sum += numbers.get(i);
				System.out.println(sum);
			}			
			i++;
		}

		if(found)
		{			
			result.add(start);
			result.add(i-2);	
		}
	
		else
		{
			result = null;
		}
		return result;
	}
}
