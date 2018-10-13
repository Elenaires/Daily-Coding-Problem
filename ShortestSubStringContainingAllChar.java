/* daily coding problem #103 */
/* return the shortest substring containing all the characters in the set.*/

/* 0) first check if string length is smaller than pattern length --> return
* 1) maintain 2 tables - needToFind and hasFound, and a count, a start pointer,
*    a minSubStringLength = Max int, substring startindex, substring endindex
* 2) store pattern and their occurence in needToFind
* 3) store pattern with 0 occurence in hasFound
* 4) iterate through string, for each character, if it exists within hasFound
*    increment occurence in hasFound
* 5) increment count if occurence in hasFound for that character is <= needToFind
* 6) if count == pattern's length, a window has been found
* 7) try and see if window length can be reduced by repeatedly checking if 
*    i) character at start pointer has greater occurence in hasFound than needToFind
*    if so, remove occurence of that char in hasFound by 1
*    ii) or if the character does not exists in hasFound (thus does not need to be
*        part of substring)
*    in both cases, increment start pointer
*    (if both cases are not met, start pointer will not be incremented)
* 8) get length of substring i - start + 1
* 9) if substring length is smaller than min substring length
*    update min substring length, substring startindex = start, substring endindex = i+1
* 10) repeat step 4 until the last character of string
* 11) return substring from index startIndex to endIndex
*/

import java.util.*;

public class ShortestSubStringContainingAllChar
{
	public static void main(String[] args)
	{
		String s = "geeksforgeeks";
		String pattern = "ork";

		String minSubString = findMinSubString(s, pattern);
		System.out.println(minSubString);
	}

	public static String findMinSubString(String s, String pattern)
	{
		String subString;
		if(s.length() < pattern.length())
		{
			subString = "";
		}

		else
		{
			int start = 0;
			Map<Character, Integer> needToFind = new HashMap<>();
			Map<Character, Integer> hasFound = new HashMap<>();

			for(int i = 0; i < pattern.length(); i++)
			{
				if(!needToFind.containsKey(pattern.charAt(i)))
				{
					needToFind.put(pattern.charAt(i), 1);
					hasFound.put(pattern.charAt(i), 0);
				}
				else
				{
					needToFind.put(pattern.charAt(i), needToFind.get(pattern.charAt(i)) + 1);
				}
			}

			int count = 0;
			int minSubStringLength = Integer.MAX_VALUE;
			int minSubStringStart = 0;
			int minSubStringEnd = 0;

			for(int i = 0; i < s.length(); i++)
			{
				char c = s.charAt(i);

				// if c is in pattern
				if(hasFound.containsKey(c))
				{	
					int occurence = hasFound.get(c) + 1;
					hasFound.put(c, occurence);

					if(hasFound.get(c) <= needToFind.get(c))
					{
						count++;
					}

					if(count == pattern.length())
					{
						c = s.charAt(start);
						
						while(!hasFound.containsKey(c) || hasFound.get(c) > needToFind.get(c))
						{	
							if(hasFound.containsKey(c) && hasFound.get(c) > needToFind.get(c))
							{
								hasFound.put(c, hasFound.get(c) - 1);
							}
							
							start++;
							c = s.charAt(start);
						}

						int subStringLength = i - start + 1;
						if(subStringLength < minSubStringLength)
						{
							minSubStringStart = start;
							minSubStringEnd = i + 1;
							minSubStringLength = subStringLength;
						}


					}
				}				
			}

			subString = s.substring(minSubStringStart, minSubStringEnd);
		}	

		return subString;
	}
}
