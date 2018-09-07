/* daily coding problem #67 */
/* not strictly O(1) because inserting into TreeMap takes O(lgn)

/* Implement an LFU (Least Frequently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:
* set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least frequently used item. If there is a tie, then the least recently used key should be removed.
* get(key): gets the value at key. If no such key exists, return null.
* Each operation should run in O(1) time.
*/

import java.util.*;

public class LFUCache
{
	int size;

	// keeps track of the keys in the cache
	HashMap<Integer, Node> map = new HashMap<>();

	// keeps track of LinkedList of nodes with same frequencies (sorted by frequency)
	SortedMap<Integer, LinkedList> sortedFrequencyList = new TreeMap<>();

	private class Node
	{
		int key;
		int value;
		Node prev = null;
		Node next = null;
		int frequency = 1;

		public Node(int key, int value)
		{
			this.key = key;
			this.value = value;
		}
	}

	// double ended doubly linkedlist
	private class LinkedList
	{
		Node head = null;
		Node tail = null;

		// keeps track of nodes within linkedlist
		HashMap<Integer, Node> map = new HashMap<>();

		public void remove(Node node)
		{
			map.remove(node.key);

			if(head == tail)
			{
				head = null;
				tail = null;
			}
			else if(node == tail)
			{
				tail = node.prev;
				tail.next = null;
			}
			else if(node == head)
			{
				head = head.next;
			}
			else
			{
				node.prev.next = node.next;
				node.next.prev = node.prev;
			}
			node.next = null;
			node.prev = null;
		}

		public void addFirst(Node node)
		{
			if(map.isEmpty())
			{
				head = node;
				tail = node;
			}
			else
			{
				node.next = head;
				head.prev = node;
				head = node;
			}
			map.put(node.key, node);
		}
	}

	public LFUCache(int size)
	{
		this.size = size;
	}

	public void set(int key, int value)
	{
		// update value
		if(map.containsKey(key))
		{
			Node node = map.get(key);
			node.value = value;
			
			// update frequency
			int freq = node.frequency;
			node.frequency = freq + 1;

			// update sortedFrequencyList
			LinkedList list = sortedFrequencyList.get(freq);
			list.remove(node);

			if(list.map.isEmpty())
			{
				sortedFrequencyList.remove(freq);
			}
	
			addIntoSortedFrequencyList(freq+1, node);
		}

		// add new key value pairs
		else
		{
			Node node = new Node(key, value);
			map.put(key, node);
			
			// cache is full - remove LFU or if tie exists remove LRU
			if(map.size() > size)
			{
				int LFUKey = sortedFrequencyList.firstKey();
				LinkedList list = sortedFrequencyList.get(LFUKey);
				Node tail = list.tail;
				list.remove(tail);
				if(list.map.isEmpty())
				{
					sortedFrequencyList.remove(LFUKey);
				}

				map.remove(tail.key);
			}
			addIntoSortedFrequencyList(1, node);
		}
	}

	private void addIntoSortedFrequencyList(int key, Node node)
	{
		if(sortedFrequencyList.get(key) == null)
		{
			LinkedList list = new LinkedList();
			list.addFirst(node);
			sortedFrequencyList.put(key, list);
		}
		else
		{
			LinkedList list = sortedFrequencyList.get(key);
			list.addFirst(node);
		}
	}
		
	public Integer get(int key)
	{
		Integer value;

		if(!map.containsKey(key))
		{
			value = null;
		}
		else
		{
			Node node = map.get(key);
			value = node.value;
			
			// update frequency
			int freq = node.frequency;
			node.frequency = freq + 1;
			//map.put(key, node);

			// update sortedFrequencyList
			LinkedList list = sortedFrequencyList.get(freq);
			list.remove(node);	

			if(list.map.isEmpty())
			{
				sortedFrequencyList.remove(freq);
			}

			addIntoSortedFrequencyList(freq+1, node);
		}

		return value;
	}	

	public static void main(String[] args)
	{
		LFUCache cache = new LFUCache(3);

		cache.set(1,1);
		cache.set(2,2);
		cache.set(3,3);
		cache.set(4,4);
		cache.set(3,3);
		cache.set(1,1);
		cache.get(4);
		cache.get(4);
		cache.get(3);
		cache.set(5,5);
		cache.set(5,6);
		cache.set(1,1);
		cache.set(1,1);
		cache.set(1,1);
		cache.set(2,2);
		cache.get(2);
		cache.set(7,7);
		cache.set(7,8);
		cache.set(7,9);
		cache.set(10,10);
		

		System.out.println("lowest frequency " + cache.sortedFrequencyList.firstKey());
		
		HashMap<Integer, Node> map = cache.map;

		for(int n : map.keySet())
		{
			Node node = map.get(n);
			System.out.println(n + ":" + node.frequency);
		}
	}
}
