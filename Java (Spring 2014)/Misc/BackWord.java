//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 4
//    Date: February 24, 2014
//    Description: This program gets a word from user then determines 
//       whether the word is spelled the same with all but its first
//       letter reversed.  Letter casing is ignored. 
//    Input:  User is continually prompted to enter a word, string
//    Output: boolean result
//                -true if word meets criteria
//                -false if it doesn't
//                -example: in >> assess
//                    >> Result: true
// --------------------------------------------------------------
// Pseudocode for this solution:
// Begin
// 	//QUIT is the control from main loop
// 	Declare constant string QUIT "quit"
// 
// 	Declare string inputWord
// 	Declare string newWord
// 	
//    Prompt for and Get inputWord from user
// 	While inputWord does not equal QUIT
// 	
// 		Set newWord to substring of inputWord at letter 1
// 		
// 		Set integer x to the length of inputWord
// 		While x is greater than 1
// 			newWord = newWord + substring of inputWord at letter x
// 			x = x - 1
// 		End While
// 		
//       // Display Results
// 		If newWord equals inputWord
// 			Display "Result: true"
// 		Else
// 			Display "Result: false"
// 		End If
// 		
// 		Prompt for and Get inputWord from user
// 	
// 	End While
// 	
// End
//**********************************************************************

import java.util.Scanner;

class BackWord
{
   public static void main(String[] args)
   {
      // Determines main loop's control variable
      final String QUIT = "quit";
      
      String inputWord;
      String newWord;
      
      Scanner stdin = new Scanner(System.in);      
      
      // Do while loop executes until QUIT string is entered
      do
      {
         System.out.println("Check a word to if it's spelled the same with all " +
         "but the first letter reversed (ex. potato)"); 
         System.out.print("Enter a word or type '" + QUIT + "' to terminate " + 
         "program >> ");
      
         inputWord = stdin.next();
         
         // Following code does not need to execute if the program 
         // is going to terminate
         if(!inputWord.toLowerCase().equals(QUIT))
         {
            // Begin newWord with first letter of inputWord
            newWord = inputWord.substring(0, 1);
            
            // Concatenate rest of the letters from inputWord to newWord 
            // starting from the end
            for(int x = inputWord.length(); x > 1; x--)
            {
               newWord += inputWord.substring(x - 1, x);
            }
            
            // Display results with letter casing ignored
            System.out.println("Result: " + newWord.toLowerCase()
               .equals(inputWord.toLowerCase()));
         }    
         
      }while(!inputWord.toLowerCase().equals(QUIT));
   } // End method
} // End class