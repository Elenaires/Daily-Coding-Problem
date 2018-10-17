/* daily coding problem #106 */

/* Given an integer list where each number represents
* the number of hops you can make, determine whether you
* can reach to the last index starting at index 0.
*
* For example, [2, 0, 1, 0] returns true while [1, 1, 0, 1] returns false.
*/

public class AdvancingArray
{
	public static void main(String[] args)
	{
		int[] array = new int[]{1,1,0,1};
		System.out.println(canAdvance(array));
	}

	public static boolean canAdvance(int[] array)
	{
		int maxSteps = 0;
		int i = 0;
	
		while(i <= maxSteps && maxSteps < array.length)
		{
			maxSteps = Math.max(maxSteps, array[i] + i);
			i++;
		}

		return maxSteps >= array.length-1;
	}
}
