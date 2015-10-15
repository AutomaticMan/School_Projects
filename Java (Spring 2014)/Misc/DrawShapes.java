//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 4
//    Date: February 24, 2014
//    Description: This program prompts user for a selection from a to e.
//        If a - d is selected, user is prompted for a character and a
//        height, which is used to print a shape depending on selection.
//        Selecting e will terminate the program.
//    Input:  User is prompted to enter a selection, string
//        User is prompted to enter a character to be printed and a height,
//        string, integer
//    Output: Shape drawn of characters
//                -character printed determined by input
//                -height of shape determined by input and must be a 
//                 positive number
//                -ex. in >> selection: a
//                     in >> character: @, height: 3   
//                        >> @
//                        >> @@
//                        >> @@@              
// --------------------------------------------------------------
// Pseudocode for this solution:
// Begin
// 	// Prefix of error message that is thrown whenever input is found to
// 	// be invalid
// 	Set constant string ERROR_MESSAGE to "Error: "
// 
// 	// Min line count.  Must be at least 0 for program to run correctly
// 	Set constant integer LINE_COUNT_MIN to 0
// 
// 	Set constant integer CHARACTER_INCREMENT to 2
// 
// 	Set boolean quit to false
// 	Set boolean validEntry to false
// 	Declare string selection
// 	Declare string characterToPrint
// 	Declare integer shapeSize
// 
// 	// Loop control variables
// 	Declare integer lineCount
// 	Declare characterCount
// 	Declare charactersToPrint
// 
// 	While quit is equal to false
// 		 Prompt for and Get selection from user
// 		 
// 		 // If selection meets these parameters then processing can occur
// 		 If selection is greater than or equal to "a" AND selection is less than
// 			or equal to "d"
// 
// 			Prompt for and Get characterToPrint from user
// 			
// 			Prompt for and Get shapeSize from user
// 			
// 			// Strings longer than 1 character are denied instead of trimmed.
// 			Set validEntry to true if characterToPrint's length is equal to 1 
// 				AND shapeSize is greater than or equal to LINE_COUNT_MIN
// 						
// 			// Selection A
// 			If validEntry AND selection equals "a"
// 			   
// 			   // Print each line of the shape based off number of lines input
// 			   lineCount = 0
// 			   
// 			   While lineCount is less than shapeSize
// 				  // Run nested loop lineCount number of times to print desired
// 				  // number of characters
// 				  characterCount = 0
// 				  
// 				  While characterCount is less than or equal to lineCount
// 					 Display characterToPrint
// 					 characterCount = characterCount + 1
// 				  End While
// 				  
// 				  lineCount = lineCount + 1
// 				  
// 				  Display "\n" // Line break
// 			   End While
// 			
// 			// Selection B
// 			Else If validEntry AND selection equals "b"
// 			
// 			    // Print each line of shape based off shapeSize input
// 			    lineCount = 0
// 			   
// 			    While lineCount is less than shapeSize
// 				   // Print character input starting from shapeSize
// 				   // * 2 and in descending order
// 				   characterCount = 0
// 				  
// 				   While characterCount is less than (shapeSize - lineCount) * 2
// 					  Display characterToPrint	
// 					  characterCount = characterCount + 1
// 				   End While
// 
// 				   lineCount = lineCount + 1
// 					
// 				   Display "\n" // Line break
// 			    End While
// 
// 			   
// 			   
// 			// Section C
// 			Else If validEntry AND selection equals "c"
// 			   charactersToPrint = 0
// 			   
// 			   // Shape is created in two parts: top and bottom
// 			   
// 			   // Top
// 			   lineCount = 0
// 			   
// 			   While lineCount is less than shapeSize
// 				  charactersToPrint = charactersToPrint + CHARACTER_INCREMENT
// 				  // Print whitespace based off max characters to be 
// 				  // printed per line minus the number of characters to
// 				  // actually be printed.
// 				  characterCount = 0
// 				  
// 				  While characterCount is less than (shapeSize * 2) - charactersToPrint
// 					 Display " "
// 					 characterCount = characterCount + 1
// 				  End While
// 				  
// 				  // Print characters left based off charactersToPrint
// 				  characterCount = 0
// 				  
// 				  While characterCount is less than charactersToPrint
// 					 Display characterToPrint
// 					 characterCount = characterCount + 1
// 				  End While
// 				  
// 				  lineCount = lineCount + 1
// 				  
// 				  Display "\n" // Line break
// 			   End While
// 			   
// 			   // Bottom
// 			   // Bottom of shape is one less line taller than top since
// 			   // middle line is printed by top loop
// 			   lineCount = 0
// 			   
// 			   While lineCount is less than shapeSize - 1
// 				  // For the bottom charactersToPrint is de-incremented,
// 				  // its already set to the appropriate value
// 				  charactersToPrint = charactersToPrint - CHARACTER_INCREMENT
// 
// 				  // Print characters based off charactersToPrint
// 				  characterCount = 0
// 				  While characterCount is less than charactersToPrint
// 					 Display characterToPrint
// 					 characterCount = characterCount + 1
// 				  End While
// 				  
// 				  Display "\n" // Line break
// 			   End While
// 
// 			// Selection D
// 			Else If validEntry AND selection equals "d"
// 			   // charactersToPrint set to 1 for odd inputs
// 			   charactersToPrint = 1
// 			   
// 			   // If shapeSize is even two characters are printed 
// 			   // on first line so charactersToPrint set to 2
// 			   If shapeSize % 2 == 0
// 				  charactersToPrint = 2;
// 			   End If
// 			   
// 			   // Shape is created in two parts: top and bottom
// 			   
// 			   // Top       
// 			   While charactersToPrint is less than or equal to shapeSize			   
// 				  // Print whitespace based off max characters to be 
// 				  // printed per line 
// 				  characterCount = 0
// 				  
// 				  While characterCount is less than (shapeSize - charactersToPrint)/2
// 					 Display " "
// 					 characterCount = characterCount + 1
// 				  End While
// 				 
// 				  // Print input character
// 				  characterCount = 0
// 				  
// 				  While characterCount is less than charactersToPrint
// 					 Display characterToPrint
// 					 characterCount = characterCount + 1
// 				  End While
// 				  
// 				  charactersToPrint = charactersToPrint + CHARACTER_INCREMENT
// 				  
// 				  Display "\n" // Line break
// 			   End While
// 			   
// 			   // Bottom
// 			   // Increment value subtracted from shapeSized to account
// 			   // for middle line which is printed in top loop.
// 			   charactersToPrint = shapeSize - CHARACTER_INCREMENT;          
// 			   
// 			   While charactersToPrint is greater than 0
// 				  // Print whitespace based off max characters to be 
// 				  // printed per line
// 				  characterCount = 0
// 				  
// 				  While characterCount is less than (shapeSize - charactersToPrint)/2
// 					 Display " "
// 					 characterCount = characterCount + 1
// 				  End While
// 				 
// 				  // Print character input
// 				  characterCount = 0
// 				  
// 				  While characterCount is less than charactersToPrint
// 					 Display characterToPrint
// 					 characterCount = characterCount + 1
// 				  End While
// 				  
// 				  charactersToPrint = charactersToPrint - CHARACTER_INCREMENT;
// 				  
// 				  Display "\n" // Line break
// 			   End While
// 			
// 			// Handle different errors appropriately       
// 			Else
// 			   // Minimum line count not met
// 			   If shapeSize is less than LINE_COUNT_MIN
// 				  Display ERROR_MESSAGE + 
// 					 "Minimum number of lines to be printed is " + LINE_COUNT_MIN
// 			   End If
// 			   
// 			   // Character to be printed is not valid
// 			   Else If characterToPrint length does not equal 1
// 				  Display ERROR_MESSAGE + "Invalid character input "
// 			   End If
//
// 		 // Quit program by terminating loop
// 		 Else If selection equals "e"
// 			quit = true
// 			Display "Program terminated "
// 		 
// 		 // Menu selection input is invalid if this code is reached 
// 		 Else
// 			Display ERROR_MESSAGE + "Invalid selection " 
// 		 End If
// 	End While
// End
//**********************************************************************

import java.util.Scanner;

class DrawShapes
{
   public static void main(String[] args)
   {
      // Prefix of error message that is thrown whenever input is found to
      // be invalid
      final String ERROR_MESSAGE = "Error: ";
      
      // Min line count.  Must be at least 0 for program to run correcty
      final int LINE_COUNT_MIN = 0;
      
      final int CHARACTER_INCREMENT = 2;
      
      boolean quit = false;
      boolean validEntry;
      String selection;
      String characterToPrint;
      int shapeSize;
      
      // Loop control variables
      int lineCount;
      int characterCount;
      int charactersToPrint;
      
      Scanner stdin = new Scanner(System.in);
      
      do
      {  
         System.out.print("Pick an option ('a' - 'd' or 'e' to quit) >> ");
         selection = stdin.next().toLowerCase();

         // If selection meets these parameters then processing can occur
         if(selection.compareTo("a") >= 0 && selection.compareTo("d") <= 0)
         {
            System.out.print("Enter the character to print >> ");
            characterToPrint = stdin.next();
               
            // Get number of lines from user.  Different parts of the program
            // require different slightly inputs from user.  shapeSize
            // set to input.
            if(selection.equals("c"))
            {
                  System.out.print("Enter the height of parallelogram " +
                     "to print >> ");
            }
            else if(selection.equals("d"))
            {   
                  System.out.print("Enter maximum characters per line " +
                     "to print >> ");  
            }
            else
            {
                  System.out.print("Enter numbers of lines to print >> ");
            }
            
            shapeSize = stdin.nextInt();
            
            // Strings longer than 1 character are denied instead of trimmed.
            validEntry = characterToPrint.length() == 1 && 
               shapeSize >= LINE_COUNT_MIN;
                        
            // Selection A
            if(validEntry && selection.equals("a"))
            {
               
               // Print each line of the shape based off number of lines input
               for(lineCount = 0; lineCount < shapeSize; lineCount++)
               { 
                  
                  // Run nested loop lineCount number of times to print desired
                  // number of characters
                  for(characterCount = 0; 
                     characterCount <= lineCount; characterCount++)
                  {
                     System.out.print(characterToPrint);
                  }
                  
                  System.out.println(); // Line break
               }
            }
            
            // Selection B
            else if(validEntry && selection.equals("b"))
            {
               // Print each line of shape based off shapeSize input
               for(lineCount = 0; lineCount < shapeSize; lineCount++)
               {      
                  
                  // Print character input starting from shapeSize
                  // * 2 and in descending order
                  for(characterCount = 0; characterCount < 
                     ((shapeSize - lineCount) * 2); characterCount++)
                  {
                     System.out.print(characterToPrint);
                  }
  
                  System.out.println(); // Line break
                  
               }
            }
            
            // Section C
            else if(validEntry && selection.equals("c"))
            {
               charactersToPrint = 0;
               
               // Shape is created in two parts: top and bottom
               
               // Top
               for(lineCount = 0; lineCount < shapeSize; lineCount++)
               {
                  charactersToPrint += CHARACTER_INCREMENT;
                  
                  // Print whitespace based off max characters to be 
                  // printed per line minus the number of characters to
                  // actually be printed.
                  for(characterCount = 0; characterCount < 
                     ((shapeSize * 2) - charactersToPrint); characterCount++)
                  {
                     System.out.print(" ");
                  }
                  
                  // Print characters left based off charactersToPrint
                  for(characterCount = 0; 
                     characterCount < charactersToPrint; characterCount++)
                  {
                     System.out.print(characterToPrint);
                  }
                  
                  System.out.println(); // Line break
               }
               
               // Bottom
               // Bottom of shape is one less line taller than top since
               // middle line is printed by top loop
               for(lineCount = 0; lineCount < shapeSize - 1; lineCount++)
               {
                  // For the bottom charactersToPrint is de-incremented,
                  // its already set to the appropriate value
                  charactersToPrint -= CHARACTER_INCREMENT;

                  // Print characters based off charactersToPrint
                  for(characterCount = 0; characterCount < 
                     charactersToPrint; characterCount++)
                  {
                     System.out.print(characterToPrint);
                  }
                  
                  System.out.println(); // Line break
               }
            }
            
            // Selection D
            else if(validEntry && selection.equals("d"))
            {
               // charactersToPrint set to 1 for odd inputs
               charactersToPrint = 1;
               
               // If shapeSize is even two characters are printed 
               // on first line so charactersToPrint set to 2
               if(shapeSize % 2 == 0)
               {
                  charactersToPrint = 2;
               }
               
               // Shape is created in two parts: top and bottom
               
               // Top       
               while(charactersToPrint <= shapeSize)
               {
               
                  // Print whitespace based off max characters to be 
                  // printed per line 
                  for(characterCount = 0; characterCount < 
                     (shapeSize - charactersToPrint)/2; characterCount++)
                  {
                     System.out.print(" ");
                  }
                 
                  // Print input character
                  for(characterCount = 0; characterCount < charactersToPrint;
                     characterCount++)
                  {
                     System.out.print(characterToPrint);
                  }
                  
                  charactersToPrint += CHARACTER_INCREMENT;
                  
                  System.out.println(); // Line break
               }
               
               // Bottom
               // Increment value subtracted from shapeSized to account
               // for middle line which is printed in top loop.
               charactersToPrint = shapeSize - CHARACTER_INCREMENT;          
               
               while(charactersToPrint > 0)
               {
                  
                  // Print whitespace based off max characters to be 
                  // printed per line
                  for(characterCount = 0; characterCount < 
                     (shapeSize - charactersToPrint)/2; characterCount++)
                  {
                     System.out.print(" ");
                     
                  }
                 
                  // Print character input
                  for(characterCount = 0; characterCount < charactersToPrint;
                     characterCount++)
                  {
                     System.out.print(characterToPrint);
                  }
                  
                  charactersToPrint -= CHARACTER_INCREMENT;
                  
                  System.out.println(); // Line break
               }
            }
            
            // Handle different errors appropriately    
            else
            {
               // Minimum line count not met
               if(shapeSize < LINE_COUNT_MIN)
               {
                  System.out.println(ERROR_MESSAGE + 
                     "Minimum number of lines to be printed is " + LINE_COUNT_MIN);
               }
               
               // Character to be printed is not valid
               if (characterToPrint.length() != 1)
               {
                  System.out.println(ERROR_MESSAGE + "Invalid character input ");
               }
            }
         }
         
         // Quit program by terminating loop
         else if(selection.equals("e"))
         {
            quit = true;
            System.out.println("Program terminated ");
         }
         else
         {
            // Menu selection input is invalid if this code is reached 
            System.out.println(ERROR_MESSAGE + "Invalid selection ");  
         }
      }while(!quit);
   } // End method 
} // End class