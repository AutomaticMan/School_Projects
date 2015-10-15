/*******************************************************************************
* Driver.java
*
* Driver demonstrates the Palindrome class by first loading a collection of
* potential palindromes from a file, then printing the result to a console
* window.
*
* John Gardiner
*******************************************************************************/

import java.io.*;
import java.util.Scanner;

public class Driver {

    private static String FILE_NAME = "PossiblePalindromes.txt"; 

    // accessFile returns a scanner object containing the file to be read.
	private static Scanner accessFile()
	{
		Scanner streamer = null;
		
	    try
	    {
	       streamer = new Scanner(new File(FILE_NAME));
	    }
		catch(FileNotFoundException e)
		{
		   System.out.println("Error opening the file: " + FILE_NAME);
		}
		  
		return streamer;
	}
	
	// getWordCount returns the line count of file to be read.
    private static int getWordCount() 
    {
       int count = 0;
       Scanner streamer = accessFile();
      
       while (streamer.hasNextLine())
       {
          String s = streamer.nextLine();
    	   
          // increment counter for each word in input file
    	  if(!s.equals(""))
    		  count++;
       }
      
       streamer.close();
      
       return count;
    }
	
    // makeWordArray() reads in each word from the file to be read and returns a 
    // string array containing each valid word.
	private static String[] makeWordArray()
	{
		String[] wordList = new String[getWordCount()];
		int x = 0;
		
		Scanner streamer = accessFile();
		
		while (streamer.hasNextLine())
	    {
	        String s = streamer.nextLine();
	        // Ignore empty lines in the file
	        if(!s.equals(""))
	        	wordList[x++] = s;
	    }
		
		streamer.close();
		
		return wordList;
	}
	
	public static void main(String[] args)
	{
		Palindrome p = new Palindrome(makeWordArray());
		System.out.print(p);
	}
}