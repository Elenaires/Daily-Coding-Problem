/* daily coding problem #100
* https://www.geeksforgeeks.org/minimum-steps-needed-to-cover-a-sequence-of-points-on-an-infinite-grid/
*/

// turns out that min steps between 2 points 
// (go diagonal first then vertical/horizontal
// is the Max of (abs(x2-x1), abs(y2-y1))

import java.util.*;

public class MinStepsSequenceOfPoints
{

	public static class Point
	{
		int x;
		int y;
		public Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args)
	{
		Point p1 = new Point(4,6);
		Point p2 = new Point(1,2);
		Point p3 = new Point(4,5);
		Point p4 = new Point(10,12);
		
		List<Point> list = new ArrayList<>(Arrays.asList(p1,p2,p3,p4));

		int minSteps = calcMinSteps(list);

		System.out.println(minSteps);
	}

	public static int calcMinSteps(List<Point> list)
	{
		int minSteps = 0;
		for(int i = 1; i < list.size(); i++)
		{
			Point p1 = list.get(i-1);
			Point p2 = list.get(i);

			int steps = Math.max(Math.abs(p1.x - p2.x), Math.abs(p1.y-p2.y));
			minSteps += steps;
		} 

		return minSteps;
	}
}
