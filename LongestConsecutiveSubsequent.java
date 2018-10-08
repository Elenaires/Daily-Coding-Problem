/* daily coding problem #99
* Given an unsorted array of integers, find the length 
* of the longest consecutive elements sequence.
*
* For example, given [100, 4, 200, 1, 3, 2], the longest
* consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.
*
* Your algorithm should run in O(n) complexity.
*/

import java.util.*;

public class LongestConsecutiveSubsequent
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{100,4,200,1,3,2};
		System.out.println(longestSubsequent(arr));
	}
	
	public static int longestSubsequent(int[] arr)
	{
		if(arr == null || arr.length == 0)
		{
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < arr.length; i++)
		{
			set.add(arr[i]);
		}

		int maxLength = 1;
		for(int i = 0; i < arr.length; i++)
		{
			int count = 1;
			if(!set.contains(arr[i]-1))
			{	
				int subsequent = arr[i]+1;
				while(set.contains(subsequent))
				{
					count++;
					subsequent++;
				}
			
				maxLength = Math.max(maxLength, count);
			}
		}

		return maxLength;
	}
}
