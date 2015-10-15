/****************************************************************************************
* Assignment: Assassin Game Manager Tester
* AssassinManagerTester will perform a series of checks on the AssassinManager to check 
* the functionality of features not tested by AssassinMain.  A description of each test
* performed, and the result of the test are printed to the console.
* 
* Programmer: John Gardiner
* Date: Dec 2, 2014
****************************************************************************************/
import java.io.*;
import java.util.*;

public class AssassinManagerTester {
	public static void main(String[] args)
	{
		Boolean failed = true;
		List<String> l1 = new LinkedList<String>();
		List<String> l2 = new LinkedList<String>();
		l2.add("Tom");
		l2.add("Jenny");
		l2.add("Ann");
		l2.add("Bill");
		l2.add("Borris");
		
		System.out.println("Test 1: Pass the constructor an empty list." +
			"  Should throw an IllegalArugmentException. ");
		try {
			AssassinManager a1 = new AssassinManager(l1);
		} catch(IllegalArgumentException e) {
			System.out.println("Passed");
			failed = false;
		}
		if(failed)
			System.out.println("Failed");
		
		System.out.println();
		System.out.println("Test 2: Print an empty graveyard.  Should print nothing. ");
	    AssassinManager a2 = new AssassinManager(l2);
	    // store output using setOut() to redirect S.O.P 
	    ByteArrayOutputStream b = new ByteArrayOutputStream();
	    PrintStream p = new PrintStream(b);
	    PrintStream init = System.out;
	    System.setOut(p);
	    a2.printGraveyard();
	    // reset state
	    System.out.flush();
	    System.setOut(init);
	    if(b.toString().equals(""))
	    	System.out.println("Passed");
	    else
	    	System.out.println("Failed");
	    
	    System.out.println();
	    System.out.println("Test 3: Call gameover() when game is unfinished." + 
	    	"  Should return false. ");
	    failed = a2.gameOver();
	    if(failed)
	    	System.out.println("Failed");
	    else
	    	System.out.println("Passed");
	    
	    System.out.println();
	    System.out.println("Test 4: Call winner() when game is unfinished." + 
	    	"  Should return null. ");
	    if(a2.winner() == null)
	    	System.out.println("Passed");
	    else
	    	System.out.println("Failed");

	    System.out.println();
	    System.out.println("Test 5a: Search for a valid name, then invalid name in kill ring." + 
	    	"  Should return true, then false. ");
	    if(a2.killRingContains("ann") && !a2.killRingContains("dan"))
	    	System.out.println("Passed");
	    else
	    	System.out.println("Failed");

	    System.out.println();
	    System.out.println("Test 5b: Search for a valid name, then invalid name in graveyard." + 
	    	"  Should return true, then false. ");
	    a2.kill("tom");
	    a2.kill("jenny");
	    if(a2.graveyardContains("jenny") && !a2.killRingContains("chelsea"))
	    	System.out.println("Passed");
	    else
	    	System.out.println("Failed");
	    
	    System.out.println();
	    System.out.println("Test 6: Call kill() with invalid name." + 
	    	"  Should throw an IllegalArgumentException. ");
	    failed = true;
	    try {
	    	a2.kill("thor");
	    } catch(IllegalArgumentException e) {
	    	System.out.println("Passed");
	    	failed = false;
	    }
	    if(failed)
		    System.out.println("Failed");
	    
	    System.out.println();
	    System.out.println("Test 7: Call gameover() when game is over.  Should return true.");
	    l1.add("kurt");
	    AssassinManager a1 = new AssassinManager(l1);
	    if(a1.gameOver())
	    	System.out.println("Passed");
	    else
	    	System.out.println("Failed");
	    
	    System.out.println();
	    System.out.println("Test 8: Call winner() when game is over.  Should return winner.");
	    if(a1.winner().equals("kurt"))
	    	System.out.println("Passed");
	    else
	    	System.out.println("Failed");
	    
	    System.out.println();
	    System.out.println("Test 9: Call kill() when game is over." + 
	    	"  Should throw an IllegalStateException. ");
	    failed = true;
	    try{
	    	a1.kill("kurt");
	    } catch(IllegalStateException e) {
	    	System.out.println("Passed");
	    	failed = false;
	    }
	    if(failed)
		    System.out.println("Failed");
	    
		System.out.println();
		System.out.println("Test 10: Print kill list with one name." + 
			"  Should print (final player) is stalking (final player). ");
	    a2.kill("ann");
	    a2.kill("bill");
	    // store output using setOut() to redirect SOP 
		b = new ByteArrayOutputStream();
	    p = new PrintStream(b);
	    System.setOut(p);
	    a2.printKillRing();
	    // reset original state
	    System.out.flush();
	    System.setOut(init);
	    // the check must be performed with the stream trimmed to function correctly
	    // program does not check format of output as a result
	    if(b.toString().trim().equals("Borris is stalking Borris"))
	    	System.out.println("Passed");
	    else
	    	System.out.println("Failed");
	    
	    // let the user know all test successfully completed
	    System.out.println();
	    System.out.print("All tests have been completed. ");
	}
}