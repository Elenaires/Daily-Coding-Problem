/* daily coding problem #43
*  Implement a stack that has the following methods:
*  1) push(val) which pushes an element onto the stack
*  2) pop() which pops off and returns the topmost element of the stack
*    If there are no elements in the stack then thrown an error or return null
*  3) max() which returns the maximum value in the stack currently.
*    If there is no elements in the stack then throw an error or return null.
*
* Each method should run in constant time
*/

import java.util.*;

public class ImplementAStack
{
	private LinkedList<Integer> myStack;
	private LinkedList<Integer> runningMaxStack; 

	public ImplementAStack()
	{
		myStack = new LinkedList<>();
		runningMaxStack = new LinkedList<>();
	}

	public void push(int value)
	{
		// addFirst adds to the head - O(1)
		myStack.addFirst(value);

		if(runningMaxStack.isEmpty())
		{
			runningMaxStack.addFirst(value);
		}
		else
		{
			// peek() looks at what's pointed by the head - O(1)
			int currentMax = runningMaxStack.peek();
			if (value > currentMax)
			{
				runningMaxStack.addFirst(value);
			}	
		}
	}		

	public Integer pop()
	{
	    Integer value = null;
		if (!myStack.isEmpty())
		{
			// removeFirst() removes from the head - O(1)
			value = myStack.removeFirst();
	
			if(value.equals(runningMaxStack.peek()))
			{
				runningMaxStack.removeFirst();
			}
		}

		return value;
	}

	// O(1)
	public Integer max()
	{
		return runningMaxStack.peek();
	} 

	public static void main(String[] args)
	{
		ImplementAStack myStack = new ImplementAStack();

		// input : 4, 14, 19, 7, 20
		// max in stack are : 4, 14, 19, 19, 20

		myStack.push(4);
		System.out.println("max in stack is " + myStack.max());
	
		myStack.push(14);
		System.out.println("max in stack is " + myStack.max());

		myStack.push(19);
		System.out.println("max in stack is " + myStack.max());

		myStack.push(7);
		System.out.println("max in stack is " + myStack.max());

		myStack.push(20);
		System.out.println("max in stack is " + myStack.max());
	
		System.out.println("removed " + myStack.pop()); // remove 20, max is 19
		System.out.println("max in stack is " + myStack.max());
	
		System.out.println("removed " + myStack.pop()); // remove 7, max is still 19
		System.out.println("max in stack is " + myStack.max());
	
		System.out.println("removed " + myStack.pop()); // remove 19, max is now 14
		System.out.println("max in stack is " + myStack.max());
	
		System.out.println("removed " + myStack.pop()); // remove 14, max is now 4
		System.out.println("max in stack is " + myStack.max());
		
		System.out.println("removed " + myStack.pop()); // remove 4, max is null
		System.out.println("max in stack is " + myStack.max());
		
		System.out.println("removed " + myStack.pop()); // null
		System.out.println("max in stack is " + myStack.max());
	
	
	}
} 
