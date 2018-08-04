/* Daily coding problem #33
* Compute the running median of a sequence of numbers.
*/

import java.util.*;

public class RunningMedian
{
	public static void main(String[] args)
	{
		List<Integer> sequence = new ArrayList<>();
		Collections.addAll(sequence,2,1,5,7,2,0,5);
	
		runningMedian(sequence);		
	}
	
	public static void runningMedian(List<Integer> sequence)
	{
		double median = 0.0;
		int medianIndex = 0;

		List<Integer> myList = new ArrayList<>();

		for (Integer i : sequence) // O(n) where n is the size of sequence
		{
			myList.add(i);
			Collections.sort(myList); // O(nlgn) 
			medianIndex = myList.size() / 2;
			
			if (myList.size() % 2 == 0) // even-numbered list
			{
				int middleNumber1 = myList.get(medianIndex - 1);
				int middleNumber2 = myList.get(medianIndex);
				median = (double)(middleNumber1 + middleNumber2) / 2.0;
			}
			else // odd-numbered list
			{
				median = (double)myList.get(medianIndex);
			}

			System.out.println(median);
		}
	}
}											

// total time complexity = O(n^2 lgn)


