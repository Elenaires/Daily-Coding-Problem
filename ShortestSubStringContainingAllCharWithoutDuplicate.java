/* daily coding problem #103 - without duplicate character in pattern */

import java.util.*;

public class ShortestSubStringContainingAllCharWithoutDuplicate
{
	public static void main(String[] args)
	{
		String s = "geeksforgeeks";
		String pattern = "ork";
		String subString = findSubString(s, pattern);
		System.out.println(subString);
	}

	public static String findSubString(String s, String pattern)
	{
		if(s.length() < pattern.length())
		{
			System.out.println("no substring");
			return "";
		}

		Set<Character> set = new HashSet<>();
		for(int i = 0; i < pattern.length(); i++)
		{
			set.add(pattern.charAt(i));
		}
	
		Map<Character, Integer> map = new HashMap<>();
		int minLength = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;

		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if(set.contains(c))
			{
				map.put(c, i);
			}
		
			if(map.size() == pattern.length())
			{
				int minIndex = Integer.MAX_VALUE;
				int maxIndex = Integer.MIN_VALUE;
				char minValueKey = pattern.charAt(0);
				for(char letter : map.keySet())
				{
					int a = map.get(letter);
					if(a < minIndex)
					{
						minIndex = a;
						minValueKey = letter;
					}
					maxIndex = Math.max(a, maxIndex);
				}

				int strLength = maxIndex - minIndex + 1;
				System.out.println("strLength : " + strLength);
				System.out.println("minLength : " + minLength);
				System.out.println(s.substring(minIndex, maxIndex+1));		
				if(strLength < minLength)
				{
					start = minIndex;
					end = maxIndex + 1;
					minLength = strLength;
				}
				System.out.println(s.substring(start, end));		
				map.remove(map.get(minValueKey));
			} 
		}

		return s.substring(start, end);
	}
}
