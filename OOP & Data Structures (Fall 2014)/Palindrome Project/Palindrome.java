/*******************************************************************************
* Palindrome.java
*
* Palindrome receives an array of Strings and determines if each String is a
* a palindrome or not.  A palindrome is a word that is spelled the same backwards 
* as it is forwards- "racecar" is a palindrome.
*
* John Gardiner
*******************************************************************************/

import java.util.*;

public class Palindrome {
	
	// Initialize data structures needed for program
	
	// master will unmolested input words from output.  1 line = 
	private String[][] master;
	// firstHalf stack (LIFO) holds first half of word for palindrome check.
	private Stack<Character> firstHalf;
	// secondHalf queue (FIFO) holds second half of word for palindrome check.
	private Queue<Character> secondHalf;

	// Main constructor for class.  Receives a String array of possible palidromes
	// then calls findPalindromes() to perform processing.
	public Palindrome(String[] s)
	{
		master = new String[2][s.length];
		firstHalf = new Stack<Character>();
		secondHalf = new LinkedList<Character>();
		
		for(int x = 0; x < s.length; x++)
			master[0][x] = s[x];
		
		findPalindromes();
	}

	// Palindrome objects are immutable, therefore class must receive an array object to
	// function correctly.  With further modification, Palindrome could function as a 
	// collection with add, modify, and delete capabilities.
	public Palindrome()
	{
		throw new IllegalArgumentException
			("Error, must initialize Palindrome with an array of Strings. ");
	}
	
	// preWord receives a string and returns a string with casing set lower, 
	// and all special characters removed.
	private static String prepWord(String word)
	{
		word = word.toLowerCase();
		
		// Remove all special characters as they are to be ignored during check
		word = word.replaceAll("\\W", "");
		
		// If odd, then remove middle char since it will not affect palindrome check 
		// either way.
		if(word.length() % 2 != 0)
			word = word.substring(0, word.length() / 2) 
				+ word.substring(word.length() / 2 + 1);
		
		return word;
	}
	
	// findPalindromes() loads each individual palindrome into a stack and 
	// queue (half and half) for comparison
	private void findPalindromes()
	{
		for(int x = 0; x < master[0].length; x++)
		{
			// temp holds current word modified for processing by prepWord()
			String temp = prepWord(master[0][x]);
			
			// Load first half of word into stack, second half into queue
			for(int y = 0; y < temp.length() / 2; y++)
			{
				firstHalf.add(temp.charAt(y));
				secondHalf.add(temp.charAt(temp.length() / 2 + y));
			}
			
			// isPalindrome() will handle the actual check
			if(isPalindrome())
				master[1][x] = " ==> is a palindrome \n";
			else
				master[1][x] = " ==> is NOT a palindrome \n";
		}
	}
	
	// isPalindrome() checks each character in the stack agains each character in 
	// the queue.  If palindrome, then they should match.
	private Boolean isPalindrome()
	{
		boolean isPalindrome = true;
		
		// To be a palindrome, a word must first be word!
		if(firstHalf.empty())
			return false;
		
		// Remove all elements from firstHalf and secondHalf.
		// Thanks to prepWord firstHalf length must equal (always even)
		// secondHalf for proper clearing.  No funny business!
		while(!firstHalf.empty())
		{
			// If at any point the elements do not match, then not a palindrome
			// FIFO contrasted by LIFO allows algorithm to function as intended
			if(firstHalf.pop() != secondHalf.remove())
				isPalindrome = false;
		}
		
		return isPalindrome;
	}

	// equals receives another object and determines if its a Palindrome object, 
	// then compares it to this Palindrome object and returns true if it contains
	// the same elements
	public boolean equals(Object o)
	{
		if(o == null || o.getClass() != getClass())
			return false;
		
		Palindrome p = (Palindrome)o;
		
		// Use toString method for comparison
		if(!toString().equals(p))
			return false;
		
		return true;
	}
	
	// toString returns a string representation of the results of the palindrome check.
	public String toString()
	{
		String s = "";
		
		for(int x = 0; x < master[0].length; x++)
		{
			s += master[0][x] + master[1][x];
		}
		
		return s;
	}
}