/* daily coding problem #104 */

// Determine whether a single linked list is a palindrome

/* 1) determine midpoint of linked list using 2 pointers 
* 2) reverse the 2nd half of the linked list
* 3) compare 1st half and 2nd half of the linked list
* 4) reverse the 2nd half back to original
*/

public class PalindromeSinglyLinkedList
{
	public static class ListNode
	{
		int value;
		ListNode next = null;
		public ListNode(int value)
		{
			this.value = value;
		}
	}

	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(1);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

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
			ListNode slow = head;
			ListNode fast = head;
			ListNode prev = null;

			// find midpoint of linkedlist
			// at the end of the loop, slow is the midpoint
			while(fast != null && fast.next != null)
			{
				prev = slow;
				slow = slow.next;
				fast = fast.next.next;				
			}

			// now we need to reverse the 2nd half of the linkedlist
			// depending on the parity of the length
			// if it's even, the reversal starts from minpoint (slow pointer)
			// else, the reversal starts from minPoint.next
		
			ListNode midPoint;

			// odd
			if(fast != null)
			{
				prev = slow;
				midPoint = slow.next;
			}

			// even
			else
			{
				midPoint = slow;
			}
		
			// reverse linked list starting from curr pointer
			reverse(prev, midPoint);

			// check if first half and second half are the same
			ListNode l1 = head;
			ListNode l2 = prev.next;

			boolean palindrome = true;

			while(l2 != null && palindrome)
			{
				if(l1.value != l2.value)
				{
					palindrome = false;
				}
				l1 = l1.next;
				l2 = l2.next;
			}

			// unreverse linked list
			{
				reverse(prev, prev.next);
			}

			return palindrome;	
		}
	}

	public static void reverse(ListNode prev, ListNode curr)
	{
		// reverse linked list
		ListNode node = curr;
		while(node.next != null)
		{
			ListNode temp = prev.next;
			prev.next = node.next;
			node.next = node.next.next;
			prev.next.next = temp;
		}
	}
}

