//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 2
//    Date: January 27, 2014
//    Description: This program modifies a sentence by removing the first 
//        word, and concatenating it to end of the sentence.  Capitalize 
//        the first letter in the new sentence.
//    Input:  User is prompted for a sentence of at least two words, string
//    Output: First letter of sentence, sentence, and new last word
//                -each as type String
//                -first letter is capitalized
//                -example: in >> Hello world
//                    >> World Hello
// --------------------------------------------------------------
// Pseudocode for this solution:
// Begin
//    Declare sentence;
//    Declare newLastWord;
//    Declare firstLetter;
// 	Prompt for and Get sentence from user
//    Trim excess whitespace from beginning and end of sentence
// 	Set delim to the character count of the first occurrence of whitespace 
//        in sentence
//    Set string newLastWord to a substring of sentence from character
//        1 to delim
// 	Set sentence to a substring of sentence at the character after 
//        delim 
//    Trim excess whitespace from beginning and end of sentence
// 	Set firstLetter to a substring of sentence at character 1 and Make
//        uppercase
// 	Set sentence to a substring of sentence from character 2 to end 
// 	Display tempLetter + sentence + " " + newLastWord
// End
//**********************************************************************
import java.util.Scanner;

class SentenceMagic {
 	public static void main(String [] args) {
      String sentence;
      String newLastWord;
      String firstLetter;
      int delim;
      
      System.out.println("Enter a sentence to see what I can do >> ");
      
      Scanner stdin = new Scanner(System.in);
 	   sentence = stdin.nextLine();
      
      sentence = sentence.trim();
      
      delim = sentence.indexOf(" ");
      newLastWord = sentence.substring(0, delim);
      
      sentence = sentence.substring(delim + 1);
      
      // Trim once again to account for extra whitespace inbetween words
      // example: "Hello     world" is returned as "World Hello"
      sentence = sentence.trim();
      
      firstLetter = sentence.substring(0,1).toUpperCase();
      
      sentence = sentence.substring(1);
      
      System.out.println(firstLetter + sentence + " " + newLastWord);
   }
}