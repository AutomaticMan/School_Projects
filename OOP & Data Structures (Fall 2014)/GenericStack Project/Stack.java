/******************************************************************************
* Stack.java
* John Gardiner
* Oct 21 2014
*
* A stack that works with generics and is built on an array 
******************************************************************************/

public class Stack<E> implements StackADT<E> {
	
	// Constants for program
	private final static int MULTIPLIER = 2;
	private final static int DEFAULT_SIZE = 10;
	
	// Instance variables
	private E[] stack;
	private int sp;
	
	// Constructors
	Stack()
	{
		this(DEFAULT_SIZE);
	}
	
	Stack(int size)
	{
		if(size < 1)
			throw new IllegalArgumentException("Invalid array size. ");
		
		stack = (E[])(new Object[size]);

		sp = -1;
	}
	
	Stack(E ... stack)
	{
		this(stack.length);
		
		for(E e: stack)
			push(e);
	}
	
	/*Adds the specified element to the top of the stack.
	  Returns the item added.*/
	public E push(E e)
	{
		if(sp == stack.length - 1)
			resizeStack();
		
		//increment stack pointer then add element
		stack[++sp] = e;
		
		return e;
	}

	/*Removes and returns the element from the top of the stack*/
	public E pop()
	{
		E e = peek();
		
		sp--;
		
		return e;
	}

	/*Returns without removing the element at the top of the stack*/
	public E peek()
	{
		if(empty())
			throw new java.util.EmptyStackException();
		
		return stack[sp];
	}
	
	public int size()
	{
		return sp + 1;
	}

	/*Returns true if the stack is empty, false otherwise*/
	public boolean empty()
	{
		return size() == 0;
	}

	/*Returns the 1-based position where an object is on this stack
	This means If the object o occurs as an item in this stack, this
	method returns the distance FROM THE TOP OF THE STACK of the
	occurrence nearest the top of the stack - the topmost item on
	the stack is considered to be at distance 1.*/
	public int search(Object o)
	{
		for(int x = sp; x >= 0; x--)
			if(stack[x].equals(o))
				return (sp - x) + 1;
		
		return -1;
	}

	// Equals method compares to stacks to see if they are the same.
	//equals - determines if two queues are equivalent
	//i.e. do they have the same elements in the same sequence
	//ignoring the structure they are stored in
	public boolean equals(Object o)
	{
		if(o == null || o.getClass() != getClass())
			return false;
		
		Stack s = (Stack)o;
		
		if(s.size() != size())
			return false;
		
		for(int x = sp; x >= 0; x--)
			if(!stack[x].equals(s.pop()))
				return false;
		
		return true;
	}
	
	/*Returns a string representation of the */
	public String toString()
	{
		String s = "[";
		
		for(int x = 0; x <= sp; x++)
			if(x == sp)
				s+= stack[x];
			else
				s += stack[x] + ", ";
		
		return s + "]";
	}
	
	private void resizeStack()
	{
		E[] stack = (E[])(new Object[this.stack.length * MULTIPLIER]);
		
		for(int x = 0; x < this.stack.length; x++)
			stack[x] = this.stack[x];
		
		this.stack = stack;
	}
	
//	public static void main(String[] args)
//	{	
//		Stack<Integer> a = new Stack<Integer>();
//		for(int x = 0; x < 101; x++)
//			a.push(x);
//		System.out.println(a);
//		System.out.println(a.search(100));
//		System.out.println(a.search(75));
//		a.pop();
//		System.out.println(a);
//		for(int x = 1; x < 100; x++)
//			a.pop();
//		System.out.println(a);
//		a.pop();
//		System.out.println(a);
//		
//		Stack<Integer> a1 = new Stack<Integer>();
//		Stack<Integer> a2 = new Stack<Integer>();
//		
//		a1.push(1);
//		System.out.println(a1.equals(a2));
//		a2.push(1);
//		System.out.println(a1.equals(a2));
//		
//		
//	}
}
