/* daily coding problem #96 */

import java.util.*;

public class Permutation
{
	public static void main(String[] args)
	{
		List<Integer> number = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		List<List<Integer>> permutations = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();

		findPermutation(permutations, tempList, number);

		int i = 1;
		for(List<Integer> list : permutations)
		{
			System.out.print(i + ") ");
			for(int a : list)
			{
				System.out.print(a + " ");
			}
			System.out.println();
			i++;
		}			
	}

	public static void findPermutation(List<List<Integer>> permutations, List<Integer> tempList, List<Integer> number)
	{
		
		// tempList started off as empty list
		// when its size is the same as number size, 
		// it's one of the permutations thus adding into list
		if(tempList.size() == number.size())
		{
			List<Integer> myList = new ArrayList<>(tempList);
			permutations.add(myList);
		}	
		else
		{
			for(int i = 0; i < number.size(); i++)
			{
				if(!tempList.contains(number.get(i)))
				{
					tempList.add(number.get(i));
					findPermutation(permutations, tempList, number);
					tempList.remove(tempList.size()-1);
				}
			}
		}
	} 
}
