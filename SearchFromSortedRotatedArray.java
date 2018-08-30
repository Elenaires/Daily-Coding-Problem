/* daily coding problem #58
* assumption: integers in the array are unique
*/

public class SearchFromSortedRotatedArray
{
	public static void main(String[] args)
	{
		int arr[] = new int[]{30,32,20,22,25,28,29};
		int k = 10;
		
		int index = modifiedBinarySearch(arr, k);

		System.out.println(index);
	}
	
	public static int modifiedBinarySearch(int[] arr, int k)
	{
		int left = 0;
		int right = arr.length - 1;

		int index = -1;

		while (left <= right && index == -1)
		{
			int mid = left + (right - left) / 2;
	
			if(arr[mid] == k)
			{
				index = mid;
			}
			
			// left subarray is sorted
			// *** <= bc mid might be left as well at some point
			// *** infinite loop if only <
			else if(arr[left] <= arr[mid])
			{
				// if k is within the range of left subarray
				if(k >= arr[left] && k < arr[mid])
				{
					right = mid - 1;
				}
				else
				{
					left = mid + 1;
				}
			}

			// right subarray is sorted
			else
			{
				// if k is within the range of right subarray
				if(k > arr[mid] && k <= arr[right])
				{
					left = mid + 1;
				}
				else
				{
					right = mid - 1;
				}
			}
		}

		return index;
	}
}		
	
				
