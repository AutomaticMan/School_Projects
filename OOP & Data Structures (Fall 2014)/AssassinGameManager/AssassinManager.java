/****************************************************************************************
* Assignment: Assassin Game Manager using a Doubly Linked List
* AssassinManager objects store names of players for an assassination simulation game, in 
* which each member stocks, and is stocked by, another player.  When a player is killed,
* their name is transfered from the killring, which contains names of active players, to 
* a list that stores the names of "dead" players, called the graveyard.
* 
* Programmer: John Gardiner
* Date: Dec 2, 2014
****************************************************************************************/
import java.util.*;

public class AssassinManager {
	// the inner class AssassinNode stores data relevant to each name added by the 
	// constructor 
	private class AssassinNode {
		AssassinNode next;
		AssassinNode previous;
		String killer;
		String name;
		AssassinNode(String s) { this.name = s; }
		public String toString() { return name; }
	}
	// killring stores head node and refers to a doubly linked list of active players 
	// when used in comments
	private AssassinNode killring;
	// graveyard stores head node and refers to a null terminated linked list of "dead"
	// players when used in comments
	private AssassinNode graveyard;
	
    /************************************************************************************ 
    * AssassinManager(List<String> list)
	* AssassinManger constructor receives a list, then adds the names from that list, to 
	* the killring by calling fillKillRing.  If the list is empty, then an exception 
	* will be thrown.  
	************************************************************************************/
	AssassinManager(List<String> list) {
		if(list == null || list.size() == 0)
			throw new IllegalArgumentException("Invalid parameter passed to constructor");
		else
			fillKillRing(list);		
		graveyard = null;
	}

    /************************************************************************************ 
    * private void fillKillRing(List<String> list)
	* Receives a list of names from the constructor, then it creates new AssassinNodes
	* for all names, and sets previous and next fields for each.
	************************************************************************************/	
	private void fillKillRing(List<String> list) {
		AssassinNode temp = killring = new AssassinNode(list.get(0));
		// start at element 1 since we've already added 0 above
		for(int x = 1; x < list.size(); x++) {
			temp.next = new AssassinNode(list.get(x));	
			(temp.next).previous = temp;
			temp = temp.next;
		}
		// complete the doubly linked list by linking the first and last nodes
		temp.next = killring;
		killring.previous = temp;
	}

    /***********************************************************************************
	* public void printKillRing()
	* Calls overloaded printKillRing, which prints the names of all the members of the 
	* killring, one on each line, in the format: "    (name) is stalking (otherName) ".
	***********************************************************************************/
	public void printKillRing() {
		System.out.print(printKillRing(killring));
	}
	
    /***********************************************************************************
	* private void printKillRing(AssassinNode temp)
	* Should be called with the AssassinNode killring.  Steps through each node in the 
	* killring and prints each player's name and their stalker in the proper format.
	***********************************************************************************/
	private String printKillRing(AssassinNode temp) {
		String s = "    " + temp + " is stalking " + temp.next + "\n";
		// if temp = the last node, then we are done(return s)
		return (temp == killring.previous) ? s : s + printKillRing(temp.next);
	}
	
	/***********************************************************************************
	* public void printGraveyard()
	* Call overloaded printGraveyard, which prints the names of all the members of the 
	* killring, one on each line, in reverse order, and in the format: 
	* "    (name) was killed by (killer's name) ".
	***********************************************************************************/
	public void printGraveyard() {
		// no action to perform if graveyard is null
		if (graveyard != null)
			System.out.print(printGraveyard(graveyard));
	}
	
	/***********************************************************************************
	* private void printGraveyard(AssassinNode temp)
	* Should be called with assassin node graveyard.  Steps through each node in the 
	* graveyard, then prints each name and stalker in the proper format.
	***********************************************************************************/
	private String printGraveyard(AssassinNode temp) {
		String s = "    " + temp + " was killed by " + temp.killer + "\n";
		// graveyard is null terminated, so when the next node is null we're done
		return (temp.next == null) ? s : printGraveyard(temp.next) + s;
	}
	
	/************************************************************************************
	* public Boolean killRingContains(String name)
	* Call overloaded killRingContains.  Should return true if name is in the killring
	* (ignore case), and otherwise return false.
	************************************************************************************/
	public Boolean killRingContains(String name) {
		return killRingContains(name, killring);
	}
	
	/************************************************************************************
	* private Boolean killRingContains(String name, AssassinNode temp)
	* Should be called with target name and killring.  Then, step through each node in 
	* killring, and return true if a match is found.
	************************************************************************************/
	private Boolean killRingContains(String name, AssassinNode temp) {
		if(temp.name.equalsIgnoreCase(name))
			return true;
		// if we reach end and no result, return false.
		else if(temp == killring.previous)
			return false;
		else
			return killRingContains(name, temp.next);
	}
	
	/************************************************************************************
	* public Boolean graveyardContains(String name)
	* Call overloaded graveyardContains, and return true if name is in the graveyard 
	* (ignore case).  Otherwise return false.
	************************************************************************************/
	public Boolean graveyardContains(String name) {
		return (graveyard == null) ? false : graveyardContains(name, graveyard);
	}
	
	/************************************************************************************
	* private Boolean graveyardContains(String name, AssassinNode temp)					
	* Should be called with target name and graveyard.  Then, step through each node in 
	* graveyard, and return true if a match is found.									
	************************************************************************************/
	private Boolean graveyardContains(String name, AssassinNode temp) {
		if(temp.name.equalsIgnoreCase(name))
			return true;
		// we are at end when next node is null, so return false
		else if(temp.next == null)
			return false;
		else
			return graveyardContains(name, temp.next);
	}
	
	/************************************************************************************
	* public Boolean gameOver()                                                         
	* Should return true if the game is over, and otherwise return false.               
	************************************************************************************/
	public Boolean gameOver() {
		// when only one node remains in the kill ring, that node points to itself
		return killring == killring.next;
	}
	
	/************************************************************************************
	* public String winner() 															
	* Returns the name of the winner.  	
	************************************************************************************/
	public String winner() {
		// if the game is unfinished, then return null	
		return (gameOver()) ? killring.name : null;
	}
	
	/************************************************************************************
	* public void kill(String name)
	* Calls overloaded kill() to remove a name from kill ring and add it to the 
	* graveyard.  If the game is over or the name does not exist, then an exception will
	* be thrown.
	************************************************************************************/
	public void kill(String name) {
		if(gameOver()) 
			throw new IllegalStateException("There game is over.");
		else
			kill(name, killring);		
	}
	
	/************************************************************************************
	* private void kill(String name, AssassinNode temp)
	* Should receive target name and killring as a parameters, then step through killring
	* until name is found.  If name is found, then skip over it in killring and call 
	* putInGraveyard() to add to graveyard.
	************************************************************************************/
	private void kill(String name, AssassinNode temp) {
		if(temp.name.equalsIgnoreCase(name)) {
			// change the nodes previous of and next to temp so that they point to each 
			// other.
			(temp.previous).next = temp.next;
			(temp.next).previous = temp.previous;
			// if head is removed, then another head must be selected
			killring = (killring == temp) ? killring.next : killring;
			putInGraveyard(temp);
		} else if(temp == killring.previous)
			// throw exception if we reach end, and no result is found
			throw new IllegalArgumentException("Name not found in kill ring.");
		else
			kill(name, temp.next);
	}
	
	/************************************************************************************
	* private void putInGraveyard(AssassinNode temp)
	* Receives an assassin node, which should already be removed from killring and adds
	* that node to graveyard. 
	************************************************************************************/
	private void putInGraveyard(AssassinNode temp) {
		temp.killer = (temp.previous).name;
		temp.next = graveyard;
		temp.previous = null;
		graveyard = temp;
	}
}