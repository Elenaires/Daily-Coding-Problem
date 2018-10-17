/* daily coding problem #108 */
// Given two strings A and B, return whether or not A 
// can be shifted some number of times to get B.

// For example, if A is abcde and B is cdeab, return true.
// If A is abc and B is acb, return false.

// note - circular permutation
// 0) check that both strings have the same length
// 1) iterate through string a comparing each char with char(0) of string b
// 2) once a match is found, check subsequent characters of a and b
//    rotate string a once the end is reached until we come back to the rotation point
// 3) if every single character is the same then string b is a circuler permutation of a and we can stop checking. otherwise repeat step 2 until all char in a has been evaluated

// OR (a+a).indexOf(b) - concatenate a+a and check if b is a substring of a+a

public class ShiftString
{
	public static void main(String[] args)
	{
		String a = "xyyzzab";
		String b = "zabxyyz";

		System.out.println("circular permutation: " + isCircularPermutation(a,b));
	}

	public static boolean isCircularPermutation(String a, String b)
	{
		if(a.length() != b.length())
		{
			return false;
		}
		
		boolean found = false;
		
		int i = 0;
		while(!found && i < a.length())
		{
			if(a.charAt(i) == b.charAt(0))
			{
				int j = (i + 1) % a.length();
				int indexB = 1;
				boolean circularPermutation = true;
				while(j != i && circularPermutation)
				{
					if(a.charAt(j) != b.charAt(indexB))
					{
						circularPermutation = false;
					}
					indexB++;
					j++;
					j %= a.length();
				} 

				if(circularPermutation)
				{
					found = true;
				}
			}
			i++;
		}

		return found;
	}
}
