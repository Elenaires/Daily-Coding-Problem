// Daily Coding Problem: Problem #1
// using 2 pointers - array needs to be sorted
// time complexity is O(nlgn) + O(n) = O(nlgn)

import java.util.*;

public class TwoNumbersSumToK_1 {
    public static void main(String[] args)
    {
        int[] array = new int[]{3,7,11,15};
        int k = 17;
        boolean found = twoNumbersSumToK(array, k);

        System.out.println(found);

    }

    public static boolean twoNumbersSumToK(int[] inputArray, int k)
    {
        boolean found = false;
        Arrays.sort(inputArray); // O(nlgn)

        int i = 0;
        int j = inputArray.length-1;

        int sum;

        while (i < j && !found)
        {
            sum = inputArray[i] + inputArray[j];

            if (sum == k) {
                found = true;
            }
            else if (sum < k)
            {
                i++;
            }
            else if (sum > k)
            {
                j--;
            }
        }

        return found;

    }
}
