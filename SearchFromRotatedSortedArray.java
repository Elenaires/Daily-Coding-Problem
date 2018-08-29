/* daily coding problem #58 */
import java.util.*;

public class SearchFromRotatedSortedArray
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{1,3,5,6,7,9,14,15,16,20};
		int value = 19;
	
		int index;

		// if value is out of the array range then no need for binary search
		if(value > arr[arr.length-1] || value < arr[0])
		{
			index = -1;
		}
		else
		{
			//index = binarySearch(arr, value, 0, arr.length-1);
			index = binarySearchIterative(arr, value);
		}

		System.out.println(index); 	
	}

	public static int binarySearch(int[] arr, int value, int left, int right)
	{
		int index = -1;
	
		if(left <= right)	
		{
			int mid = left + (right - left) / 2;
		
			if(value == arr[mid])
			{
				index = mid;
			}
			else if(value < arr[mid])
			{
				index = binarySearch(arr, value, left, mid-1);
			}
			else 
			{
				index = binarySearch(arr, value, mid+1, right);
			}
		}
		return index;
	}

	public static int binarySearchIterative(int[] arr, int value)
	{
		int left = 0;
		int right = arr.length - 1;
		int mid;
		int index = -1;

		while(left <= right && index == -1)
		{
			mid = left + (right-left)/2;

			if(value == arr[mid])
			{
				index = mid;
			}
			else if(value > arr[mid])
			{
				left = mid + 1;
			}
			else
			{
				right = mid - 1;
			}
		}	

		return index;				
	}		
}
