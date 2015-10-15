//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 2
//    Date: January 27, 2014
//    Description:  This program converts a four digit base-2 number to 
//        its decimal value equivalent.
//    Input:  Prompt user to enter a four digit base-2 number, integer
//    Output: The base-2 number in its base-10 form.
//                -as an integer
//                -example: in >> 1001
//                    >> 9
// --------------------------------------------------------------
// Pseudocode for this solution:
// Begin
//     Set constant integer BINARY_FOUR = 8
//     Set constant integer BINARY_THREE = 4
//     Set constant integer BINARY_TWO = 2
//     Declare string baseTwo
//     Declare string tempString
//     Declare integer value
//     Declare integer inputAsBaseTen
// 	 Prompt for and get baseTwo from user
//     Set tempString to substring of baseTwo at character 1
//     Set value to tempString as integer
//     inputAsBaseTen = 8 * value
//     Set tempString to substring of baseTwo at character 2
//     Set value to tempString as integer
//     inputAsBaseTen = inputAsBaseTen + 4 * value
//     Set tempString to substring of baseTwo at character 3
//     Set value to tempString as integer
//     inputAsBaseTen = inputAsBaseTen + 2 * value
//     Set tempString to substring of baseTwo at character 4
//     Set value to tempString as integer
//     inputAsBaseTen = inputAsBaseTen + value 
// 	 Display inputAsBaseTen
// End
//**********************************************************************
import java.util.Scanner;

class BinaryConverter{
   public static void main(String[] args){
      final int BINARY_FOUR = 8;
      final int BINARY_THREE = 4;
      final int BINARY_TWO = 2;
      
      String baseTwo;
      String tempString;
      int value;
      int inputAsBaseTen;
      
      System.out.println("Enter a four digit binary number to see its decimal equivalent >> ");
  
      Scanner stdin = new Scanner(System.in);
      baseTwo = stdin.nextLine();
      
      tempString = baseTwo.substring(0,1);
      value = Integer.parseInt(tempString);
      inputAsBaseTen = BINARY_FOUR * value;
      
      tempString = baseTwo.substring(1,2);
      value = Integer.parseInt(tempString);
      inputAsBaseTen += BINARY_THREE * value;
      
      tempString = baseTwo.substring(2,3);
      value = Integer.parseInt(tempString);
      inputAsBaseTen += BINARY_TWO * value;
      
      tempString = baseTwo.substring(3);
      value = Integer.parseInt(tempString);
      inputAsBaseTen += value;
      
      System.out.println(inputAsBaseTen);
   }
}