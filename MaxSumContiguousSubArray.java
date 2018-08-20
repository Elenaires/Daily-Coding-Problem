/* Daily coding problem #49
* Given an array of numbers, find the max sum of any
* contiguous subarray of the array.
* if all elements are negative then return 0
*/


import java.util.*;

public class MaxSumContiguousSubArray
{
	public static void main(String[] args)
	{
		int[] array = new int[]{34,-50,42,14,-5,86};
		int output = maxSum(array);
		System.out.println(output);		
	}

	public static int maxSum(int[] array)
	{
		int maxPrefixSum = 0;
		int maxSubArraySum = Integer.MIN_VALUE;

		for(int i = 0; i < array.length; i++)
		{
			maxPrefixSum += array[i];
			if(maxPrefixSum > maxSubArraySum)
			{
				maxSubArraySum = maxPrefixSum;	
			}
			if(maxPrefixSum < 0)
			{
				maxPrefixSum = 0;
			}
		}
		
		if(maxSubArraySum < 0)
		{
			maxSubArraySum = 0;
		}

		return maxSubArraySum;
	}
}
