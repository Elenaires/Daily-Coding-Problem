/* daily coding problem #78 */
/* given k sorted singly linked lists, write a function
* to merge all lists into one sorted single linked list
*/

/* divide and conquer - O(Nklgk) */

public class ListNode
{
	int val;
	int next;
	ListNode(int x) { val = x };
}

public class MergeSortedLinkedList
{
	public ListNode mergeKLists(List<ListNode> lists)
	{
		ListNode node;

		if(lists.size() == 0 || lists == null)
		{
			node = null;
		}
		else
		{
			node = mergeRecurse(lists, 0, lists.size() - 1);
		}
		return node;
	}
		
	public ListNode mergeRecurse(List<ListNode> lists, int leftIdx, int rightIdx)
	{
		ListNode node;

		if(leftIdx < rightIdx)
		{
			int midIdx = leftIdx + (rightIdx - leftIdx) / 2;

			ListNode l1 = mergeRecurse(lists, leftIdx, mid);
			ListNode l2 = mergerecurse(lists, mid + 1, rightIdx);
		
			node = merge(l1, l2);
		} 

		else
		{
			// when 1 list is left
			node = lists.get(leftIdx); 
		}
	}

	public merge(ListNode l1, ListNode l2)
	{
		Listnode head = new ListNode(0);
		ListNode curr = head;

		while(l1 != null && l2 != null)
		{
			
			if(l1.val < l2.val)
			{
				curr.next = l1;			
				l1 = l1.next;
			}
			else
			{
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}

		if(l1 == null)
		{
			curr.next = l2;
		}

		if(l2 == null)
		{
			curr.next = l1;
		}
		
		return head.next;
	}
}

