/* daily coding problem #107 */

// print a binary tree level wise 

// using a queue

import java.util.*;

public class BTLevelWise
{
	public static class TreeNode
	{
		int value;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int value)
		{
			this.value = value;
		}
	}

	public static void main(String[] args)
	{
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		node1.right = node2;
		node2.left = node3;
		node2.right = node4;
		node3.left = node5;
		node5.left = node6;
		node4.right = node7;
	
		List<Integer> list = printBTLevelWise(node1);
		for(int a : list)
		{
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static List<Integer> printBTLevelWise(TreeNode node)
	{
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);

		helper(queue, list);

		return list;
	}

	public static void helper(Queue<TreeNode> queue, List<Integer> list)
	{
		while(!queue.isEmpty())
		{
			TreeNode curr = queue.remove();
			list.add(curr.value);

			if(curr.left != null)
			{
				queue.add(curr.left);
			}
			if(curr.right != null)
			{
				queue.add(curr.right);
			}		
		}
	}	
}
