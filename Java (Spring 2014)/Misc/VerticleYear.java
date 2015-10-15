//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 2
//    Date: January 27, 2014
//    Description: This program displays a four digit number with each    
//        digit on a separate line.
//    Input:  User is prompted for a four digit number, integer.
//    Output: Each digit of a four digit number.
//                -each as type integer
//                -one per line
//                -example: in >> 1234
//                    >> 1
//                    >> 2
//                    >> 3
//                    >> 4
// --------------------------------------------------------------
// Pseudocode for this solution:
// Begin
//     Declare integer input
//     Declare integer digitOne
//     Declare integer digitTwo
//     Declare integer digitThree
//     Declare integer digitFour
//     Prompt for and Get input from user
//     Set digitOne to input % 10
// 	 input = input / 10
//     Set digitTwo to input % 10
//     input = input / 10
// 	 Set digitThree to input % 10
// 	 input = input / 10
// 	 Set digitFour to input
// 	 Display digitFour + "\n" + digitThree + "\n" + digitTwo + "\n" + 
//         digitOne
// End
//**********************************************************************
import java.util.Scanner;

class DigitDisplay {
 	public static void main(String [] args) {
      int input;
      int digitOne;
      int digitTwo;
      int digitThree;
      int digitFour;
      
      System.out.println("Enter a four digit integer >> ");
      
      Scanner stdin = new Scanner(System.in);
      input = stdin.nextInt();
      
      // integer division to calculate each digit one at a time
      digitOne = input % 10;
      input /= 10;
   	
      digitTwo = input % 10;
      input /= 10;
      
   	digitThree = input % 10;
      input /= 10;
   	
      digitFour = input;
      
      System.out.println(digitFour + "\n" + digitThree + "\n" + digitTwo + 
         "\n" + digitOne);         
   }
}