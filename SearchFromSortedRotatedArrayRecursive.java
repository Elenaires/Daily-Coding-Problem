/* daily coding problem #58 - recursive
* assumption : int array contains unique element
*/

public class SearchFromSortedRotatedArrayRecursive
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{8,9,10,1,2,3,4,5,6,7};
		int k = 18;
		int index = modifiedBinarySearch(arr, k, 0, arr.length-1);
		
		System.out.println(index);
	}

	public static int modifiedBinarySearch(int[] arr, int k , int left, int right)
	{
		int index = -1;
		if(left <= right)
		{
			int mid = left + (right - left) / 2;
	
			if(arr[mid] == k)
			{
				index = mid;
			}

			// left subarray is sorted
			else if(arr[left] <= arr[mid])
			{
				if(k >= arr[left] && k < arr[mid])
				{
					index = modifiedBinarySearch(arr, k, left, mid-1);
				}
				else
				{
					index = modifiedBinarySearch(arr, k, mid+1, right);
				}
			}
			else
			{
				if(k > arr[mid] && k <= arr[right])
				{
					index = modifiedBinarySearch(arr, k, mid+1, right);
				}
				else
				{
					index = modifiedBinarySearch(arr, k, left, mid-1);
				}
			}
		}

		return index;
	}
}
