//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 2
//    Date: January 27, 2014
//    Description: This program converts a temperature from degrees 
//        Fahrenheit to degrees Celsius using the formula C = 5(F-32)/9.  
//        Answer will be rounded to tenth place.
//    Input:  User is prompted to enter a temperature in degrees
//        Fahrenheit, integer
//    Output: degrees Fahrenheit, degrees Celcius.
//                -degrees F as integer
//                -degrees C as double
//                -example: in >> 212
//                    >> 212 degees F = 100 degrees C. 
// --------------------------------------------------------------
// Pseudocode for this solution:
// Begin
//     Declare integer degreesF
//     Declare double degreesC
// 	 Prompt for and get degreesF from user
// 	 Set degreesC to 5.0(degreesF - 32)/9
// 	 Display degreesF + " degrees Fahrenheit is equal to " + degreesC +
//         "degrees Celcius. "
// End
//**********************************************************************
import java.util.Scanner;

class TemperatureConverter {
 	public static void main(String [] args) {
      int degreesF;
      double degreesC;
      
      System.out.println("Enter a temperature in degrees Fahrenheit to " +
         "see its equivalent in degrees Celcius >> ");
      
      Scanner stdin = new Scanner(System.in);
      degreesF = stdin.nextInt();
      
      degreesC = 5.0 * (degreesF - 32) / 9;
      
      //Display results with degreesF formatted to one decimal place
      System.out.printf("%d degrees Fahrenheit is equivalent to %1.1f " + 
         "degrees Celcius", degreesF, degreesC);
   }
}