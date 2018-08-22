/* Daily coding problem #52
* Implement an least recently used cache of size n
* with the following methods:
* set(key, value) - if there are already n items in the cache, 
* remove the recently used item and add the new item
* get(key) - get value at key, if doesn't exist return null
*/

// using doubly linkedlist (like a queue) - O(1) for insert and delete)
// and a hashmap (O(1) look up node in the linkedlist)

// add new item at the head of linkedlist, remove LRU item from tail
// update hashmap accordingly

// both get() and set() operations will move node to the head position
// if it's not already at the head position

public class Node
{
	int key;
	int value;
	Node next = null;
	Node prev = null;

	public Node(int key, int value)
	{
		this.key = key;
		this.value = value;
	}

public class LRUCache
{
	int size;
	HashMap<Integer, Node> map = new HashMap<>();
	Node head = null;
	Node tail = null;

	public LRUCache(int size)
	{
		this.size = size;
	}

	// return Integer because qs says to return null if item doesn't exist
	public Integer get(int key)
	{
		Integer retValue;

		if(map.contains(key))
		{
			Node node = map.get(key);
			retValue = node.value();
			
			//move the node from its current position to the head (most recently used)
			if(node != head)
			{
				remove(node);
				setHead(node);
			}
		}
		else
		{
			retValue = null;
		}
		return retValue;
	}			

	private void remove(Node node)
	{
		// node is the tail
		if(node.next == null)
		{
			tail = node.prev;
			tail.next = null;
			node.prev = null;
		}

		// node is not tail
		else
		{
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
		}
	}

	private void setHead(Node node)
	{
		// empty linkedlist
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
	}

	public void set(int key, int value)
	{
		// key is in the linkedlist/map
		if(map.contains(key))
		{
			Node node = map.get(key);

			// in case value to set is new
			node.value = value;

			if(node != head)
			{
				remove(node);
				setHead(node);
			}
		}

		// key is not in the linkedlist/map but hasn't reached capacity - add Node
		else if(map.size() < size)
		{ 		
			Node node = new Node(key, value);
			setHead(node);
			map.put(key, node);
		}

		// key is not in the linkedlist but capacity is full - remove LRU node then add Node
		else
		{
			map.remove(tail.key);
			remove(tail);
			Node node = new Node(key, value);
			setHead(node);
			map.put(key, node);
		}
	}
}
	
	
