//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 5b
//    Date: April 7, 2014
//    Description: This program is used to test methods of the Date class
//       including constructors, addDays, toString, compareTo, 
//       and getDaysApart
//**********************************************************************

class DateTester
{
   private static void testOne()
   {
      // TESTING addDays METHOD
      // Adding 30 days to JAN-01-2000 gives JAN-31-2000
      // Adding 366 days to JAN-01-2000 gives JAN-01-2001
      // Adding -366 days to JAN-01-2000 gives DEC-31-1998
      // Adding -1000 days to JAN-01-2000 gives APR-06-1997
      Date myDate = new Date();
      Date myDate2 = new Date();
      Date myDate3 = new Date();
      Date myDate4 = new Date();
      
      myDate.addDays(30);      
      myDate2.addDays(366);
      myDate3.addDays(-366);   
      myDate4.addDays(-1000);
      
      System.out.println(myDate);
      System.out.println(myDate2);
      System.out.println(myDate3);
      System.out.println(myDate4);
   }
   
   private static void testTwo()
   {
      // TESTING compareTo METHOD
      // -1 if current < other ==> current comes before other
      // 1 if current > other ==> current comes after other
      // 0 if the two are equal ==> dates are equal
      Date myDate = new Date();
      Date myDate2 = new Date(myDate);
      Date myDate3 = new Date();
      myDate3.addDays(-1);
      
      
      int one = myDate3.compareTo(myDate);
      int two = myDate.compareTo(myDate3);
      int three = myDate.compareTo(myDate2);
      
      System.out.println(one);
      System.out.println(two);
      System.out.println(three);
   }
   
   private static void testThree()
   {
      // TESTING getDaysApart METHOD 
      // Returns the difference between two dates in number of days. 
      // The retuned value is always a positive value. Examples:
      // Days between JAN-01-2000 and JAN-01-2000 = 0
      // Days between JAN-01-2000 and JAN-11-2000 = 10
      // Days between JAN-01-2000 and APR-10-2000 = 100
      // Days between JAN-01-2000 and JUL-19-2000 = 200
      // Days between JAN-01-2000 and DEC-31-2000 = 365
      // Days between JAN-01-2000 and SEP-27-2002 = 1000
      Date myDate = new Date();
      Date myDate2 = new Date(11,01,2000);
      Date myDate3 = new Date(01,04,2000);
      Date myDate4 = new Date(19,07,2000);
      Date myDate5 = new Date(31,12,2000);
      Date myDate6 = new Date(27,9,2002);
      
      System.out.println(myDate.getDaysApart(myDate));
      System.out.println(myDate.getDaysApart(myDate2));
      System.out.println(myDate.getDaysApart(myDate3));
      System.out.println(myDate.getDaysApart(myDate5));
      System.out.println(myDate.getDaysApart(myDate6));      
   }

   public static void main(String[] args)
   {   
      testOne();
      testTwo();
      testThree();
   }
}