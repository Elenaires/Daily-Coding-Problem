/* daily coding problem #104 */

// Determine whether a doubly linked list is a palindrome

public class PalindromDoublyLinkedList
{
	public static class ListNode
	{
		int value;
		ListNode next = null;
		ListNode prev = null;
		public ListNode(int value)
		{
			this.value = value;
		}
	}

	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.prev = node2;
		node2.prev = node1;

		System.out.println(isPalindrome(node1));
	}

	public static boolean isPalindrome(ListNode head)
	{
		if(head == null)
		{
			return false;
		}
		else if(head.next == null)
		{
			return true;
		}	
		else
		{
			ListNode start = head;
			ListNode end = head;

			// find tail of linked list
			while(end.next != null)
			{
				end = end.next;
			}
		
			// compare start and end nodes 
			while(start != end && end.next != start)
			{		
				if(start.value != end.value)
				{
					return false;
				}
				start = start.next;
				end = end.prev;	
			}

			return true;
		}
	}
}

