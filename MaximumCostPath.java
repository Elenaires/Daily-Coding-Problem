/* daily coding question #122 */

public class MaximumCostPath
{
	public static void main(String[] args)
	{
		int[][] arr = new int[][]{{0,3,1,1},{2,0,0,4},{1,5,3,1}};
		int maxCost = findMaxCost(arr);
		System.out.println(maxCost);
	}
	
	public static int findMaxCost(int[][] arr)
	{
		int[][] temp = new int[arr.length][arr[0].length];
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[0].length; j++)
			{
				if(i-1 >= 0 && j-1 >= 0)
				{
					temp[i][j] = arr[i][j] + Math.max(temp[i-1][j], temp[i][j-1]);
				}
				else if(i-1 >= 0)
				{
					temp[i][j] = arr[i][j] + temp[i-1][j];
				}
				else if(j-1 >= 0)
				{
					temp[i][j] = arr[i][j] + temp[i][j-1];
				}
				else
				{
					temp[i][j] = arr[i][j];
				}
//				System.out.print(temp[i][j] + " ");

			}
//			System.out.println();
		}
		return temp[temp.length-1][temp[0].length-1];
	}
}
