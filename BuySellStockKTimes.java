/* daily coding problem #130 */

import java.util.*;

public class BuySellStockKTimes
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{12,14,17,10,14,13,12,15};
		int k = 3;

		int profit = maxProfit(arr, k);
		System.out.println(profit);
	}

	public static int maxProfit(int[] arr, int k)
	{
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		int i = 0;
		while(i < arr.length-1)
		{
			if(arr[i+1] > arr[i])
			{
				int maximumProfit = 0;
				int iter = i+1;
				int diff = 0;
				while(iter < arr.length && arr[iter] > arr[i])
				{
					diff = arr[iter] - arr[i];
					maximumProfit = Math.max(maximumProfit, diff);
					iter++;
				}

				queue.add(maximumProfit);
				i = iter;
			}
			else
			{
				i++;
			}
		}

		int profit = 0;
		while(!queue.isEmpty() && k > 0)
		{
			profit += queue.poll();	
			k--;
		}	

		return profit;
	}
}
