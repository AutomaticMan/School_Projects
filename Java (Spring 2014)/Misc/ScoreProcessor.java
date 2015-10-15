//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 4
//    Date: February 24, 2014
//    Description: This program continually prompts the user to enter a 
//       score as an integer between 0 and 100 until -1 is entered.  
//       Program counts the number of scores, cumputes their percentage of 
//       the total count, tracks the range of input values, and calculates 
//       their average.
//    Input:  User is continually prompted to enter a score, integer
//    Output: Total count, A (>=90) count, B (>=80) count, C (>=70) count, D  
//       (>=60)count, F (< 60) count, A percentage, B percentage, C percentage, 
//       D percentage, F percentage, maximum score, minimum score, average score
//                -count variables as integers
//                -min/ max score as integers
//                -percentage variables as double rounded to the tenths place
//                -average score as double rounded to the tenths place
//                 
// --------------------------------------------------------------
// Pseudocode for this solution:
// Begin
// 	
// 	// When a score lower than minimum_score is entered, execution of 
// 	// program terminates, and results are displayed.
// 	Set constant integer MINIMUM_SCORE to 0
// 	
// 	Set constant integer MAXIMUM_SCORE to 100
// 	
// 	// Set minimum score for each grade
// 	Set constant integer A_MINIMUM to 90
// 	Set constant integer B_MINIMUM to 80
// 	Set constant integer C_MINIMUM to 70
// 	Set constant integer D_MINIMUM to 60
// 	
// 	// Declare a variable to hold count of each grade
// 	Declare integer aCount
// 	Declare integer bCount
// 	Declare integer cCount
// 	Declare integer dCount
// 	Declare integer fCount
// 	
// 	// Declare a variable to hold percentage of total for each grade 
// 	Declare integer aPercent
// 	Declare integer bPercent
// 	Declare integer cPercent
// 	Declare integer dPercent
// 	Declare integer fPercent
// 	
// 	Declare integer totalCount
// 	Declare integer totalScore
// 	Declare integer averageScore
// 	Declare integer highScore
// 	Declare integer lowScore
// 	
// 	Prompt for and Get integer inputScore from user
//    highScore = inputScore
//    lowScore = inputScore
// 	
// 	// Program runs until a score lower than minimum_score is entered
// 	Repeat while inputScore is greater than or equal to MINIMUM_SCORE
// 		
// 		// If inputScore is higher than maximum_score then stop execution
// 		If inputScore is less than or equal to MAXIMUM_SCORE
// 			
// 			If inputScore is greater than or equal to A_MINIMUM
// 				aCount = aCount + 1
// 			Else If inputScore is greater than or equal to B_MINIMUM
// 				bCount = bCount + 1
// 			Else If inputScore is greater than or equal to C_MINIMUM
// 				cCount = cCount + 1
// 			Else If inputScore is greater than or equal to D_MINIMUM
// 				dCount = dCount + 1
// 			Else
// 				fCount = fCount + 1
// 			End If
// 			
// 			// Determine range of input values for display
// 			If inputScore is greater than highScore
// 				highScore = inputScore
// 			Else If inputScore is less than lowScore
// 				lowScore = inputScore
// 			End If
// 			
// 			totalCount = totalCount + 1
// 			totalScore = totalScore + inputScore
// 		Else
// 			Display "Error, maximum score is " + MAXIMUM_SCORE
// 		End If
// 		
// 		Prompt for and Get inputScore from user
// 	End While
//
//    // Only proceed with execution if data exists to work with
//    If totalCount is greater than 0
//       // Decimal result is multiplied by 100 to produce a percentage   
//    	aPercent = aCount / totalCount * 100
//    	bPercent = bCount / totalCount * 100
//    	cPercent = cCount / totalCount * 100
//    	dPercent = dCount / totalCount * 100
//    	fPercent = fCount / totalCount * 100
//    	
//    	averageScore = totalScore / totalCount
//    	
//    	Display "Number of A's is " + aScore
//    	Display "Percentage of total: " + aPercent
//    	Display "Number of B's is " + bScore
//    	Display "Percentage of total: " + bPercent		
//    	Display "Number of C's is " + cScore
//    	Display "Percentage of total: " + cPercent		
//    	Display "Number of D's is " + dScore
//    	Display "Percentage of total: " + dPercent		
//    	Display "Number of F's is " + fScore
//    	Display "Total Number of Score's: " + totalCount
//    	Display "Percentage of total: " + fPercent
//    	Display "Range: " + lowScore + " - " + highScore
//    	Display "Average Score: " + averageScore
//    End If
// End
//**********************************************************************

import java.util.Scanner;

class ScoreProcessor
{
   public static void main(String[] args)
   {
   	// When a score lower than minimum_score is entered, execution of 
   	// program terminates, and results are displayed.
   	final int MINIMUM_SCORE = 0;
   	final int MAXIMUM_SCORE = 100;
   	
      // Set minimum score for each grade
   	final int A_MINIMUM = 90;
   	final int B_MINIMUM = 80;
   	final int C_MINIMUM = 70;
   	final int D_MINIMUM = 60;
   	
      // Declare a variable to hold count of each grade
   	int aCount = 0;
   	int bCount = 0;
   	int cCount = 0;
   	int dCount = 0;
   	int fCount = 0;
   	
   	// Declare a variable to hold percentage of total for each grade 
   	double aPercent;
   	double bPercent;
   	double cPercent;
   	double dPercent;
   	double fPercent;
   	
      int inputScore;
   	int totalCount = 0;
   	int totalScore = 0;
   	int highScore;
   	int lowScore;
   	double averageScore;
      
      Scanner stdin = new Scanner(System.in);
      
      System.out.print("Enter a score between " + MINIMUM_SCORE + " and " + 
         MAXIMUM_SCORE + " or press " + (MINIMUM_SCORE - 1) + " to quit >> ");
         
      inputScore = stdin.nextInt();
      
      // Initialize starting values for highScore and lowScore
      highScore = inputScore;
      lowScore = inputScore;

	   // Program runs until a score lower than minimum_score is entered
      while(inputScore >= MINIMUM_SCORE)
      {  
   		// If inputScore is higher than maximum_score then stop execution
   		if(inputScore <= MAXIMUM_SCORE)
         {
            if(inputScore >= A_MINIMUM)
            {
               aCount++;
            }
            else if(inputScore >= B_MINIMUM)
            {
               bCount++;
            }
            else if(inputScore >= C_MINIMUM)
            {
               cCount++;
            }
            else if(inputScore >= D_MINIMUM)
            {
               dCount++;
            }
            else
            {
               fCount++;
            }
            
			   // Determine range of input values for display
            if(inputScore > highScore)
            {
               highScore = inputScore;
            }
            else if(inputScore < lowScore)
            {
               lowScore = inputScore;
            }
            
			   totalCount++;
            
			   totalScore = totalScore + inputScore;
         }
   	   else
         {
            System.out.println("Error, maximum score is " + MAXIMUM_SCORE);
         }  
   
         // Prompt user for next input
         System.out.print("Enter a score between " + MINIMUM_SCORE + " and " + 
            MAXIMUM_SCORE + " or press " + (MINIMUM_SCORE - 1) + " to quit >> ");
            
         inputScore = stdin.nextInt(); 
      }
     
      // Only proceed with execution if data exists to work with
      if(totalCount > 0)
      {  
         // Decimal result is multiplied by 100 to produce a percentage    
      	aPercent = ((double)aCount / totalCount) * 100;
      	bPercent = ((double)bCount / totalCount) * 100;
      	cPercent = ((double)cCount / totalCount) * 100;
      	dPercent = ((double)dCount / totalCount) * 100;
      	fPercent = ((double)fCount / totalCount) * 100;
      	
   	   averageScore = (double)totalScore / totalCount;   
            
         // Display results. Double types rounded to the tenths place      
      	System.out.println("Number of A's is " + aCount);
      	System.out.printf("Percentage of total: %1.1f%c\n\n", aPercent, '%');
         
      	System.out.println("Number of B's is " + bCount);
      	System.out.printf("Percentage of total: %1.1f%c\n\n", bPercent, '%');
             		
      	System.out.println("Number of C's is " + cCount);
      	System.out.printf("Percentage of total: %1.1f%c\n\n", cPercent, '%');
               		
      	System.out.println("Number of D's is " + dCount);
      	System.out.printf("Percentage of total: %1.1f%c\n\n", dPercent, '%');
   
      	System.out.println("Number of F's is " + fCount);
      	System.out.printf("Percentage of total: %1.1f%c\n\n", fPercent, '%');
         
         System.out.println("Total Number of Score's: " + totalCount + "\n");
         
      	System.out.println("Range: [" + lowScore + "," + highScore + "]\n");
         
      	System.out.printf("Average Score: %1.1f", averageScore);
      }
   } // End method 
} // End class