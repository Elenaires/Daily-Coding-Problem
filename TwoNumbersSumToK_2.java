// Daily Coding Problem: Problem #1
// using HashSet - without sorting
// Time complexity - O(n) - one pass

import java.util.*;

public class TwoNumbersSumToK_2 {
    public static void main(String[] args)
    {
        int[] array = new int[]{10,15,3,7};
        int k = 17;
        boolean found = twoNumbersSumToK(array, k);

        System.out.println(found);
    }

    public static boolean twoNumbersSumToK(int[] inputArray, int k)
    {
        Set<Integer> set = new HashSet<>();
        boolean found = false;

        int i = 0;
        int diff;
        while(i < inputArray.length && !found)
        {
            diff = k - inputArray[i];

            if(set.contains(diff))
            {
                found = true;
            }
            else
            {
                set.add(inputArray[i]);
            }
            i++;
        }

        return found;
    }
}
