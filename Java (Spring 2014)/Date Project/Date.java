//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 5b
//    Date: April 7, 2014
//    Description: Instances of the Date class store a date as three  
//       separate parts: year, month, and day.  Methods for modifying, 
//       comparing, and formatting date objects are also contained 
//       with-in this class.
//**********************************************************************

class Date
{
   public static final int JAN = 1;
   public static final int FEB = 2;
   public static final int MAR = 3;
   public static final int APR = 4;
   public static final int MAY = 5;
   public static final int JUN = 6;
   public static final int JUL = 7;
   public static final int AUG = 8;
   public static final int SEP = 9;
   public static final int OCT = 10;
   public static final int NOV = 11;
   public static final int DEC = 12;
   
   private int day;
   private int month;
   private int year;


   //**********************************************************************
   //    Name: Date
   //    Description: Default constructor for the date class.
   //    Post Condition: Sets date to JAN-01-2000.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public Date()
   // Begin
   //    Set day to 1
   //    Set month to 1
   //    Set year to 2000
   // End
   //**********************************************************************   
   public Date()
   {
      day = 1;
      month = 1;
      year = 2000;
   }


   //**********************************************************************
   //    Name: Date
   //    Description: Overloaded constructor for the date class allows for
   //       date objects to be initialized to custom values.
   //    Post Conditions: Sets date to valid date.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public Date(int day, int month, int year)
   // Begin
   //    setYear(year)
   //    setMonth(month)
   //    setDay(day)
   // End   
   //**********************************************************************   
   public Date(int day, int month, int year)
   {
      
      setYear(year);
      
      setMonth(month);
      
      setDay(day);
   }


   //**********************************************************************
   //    Name: Date
   //    Description: Overloaded constructor for the date class allows for
   //       copying of other date objects.
   //    Post Conditions: Date set from values of another date object.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public Date(Date d)
   // Begin
   //    Set year to d.getYear();
   //    Set month to d.getMonth();
   //    Set day to d.getDay();
   // End   
   //**********************************************************************   
   public Date(Date d)
   {
      year = d.getYear();
      month = d.getMonth();
      day = d.getDay();
   }

   
   //**********************************************************************
   //    Name: getMonth
   //    Description: Public accessor for month.
   //    Preconditions: Month should be set to valid value.
   //    Returns: month
   //       -as integer
   //       -raw value, unformatted
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public int getMonth()
   // Begin
   //    Return month
   // End
   //**********************************************************************   
   public int getMonth()
   {
      return month;
   }


   //**********************************************************************
   //    Name: getDay
   //    Description: Public accessor for day.
   //    Preconditions: Day should be set to valid value.
   //    Returns: day
   //       -as integer
   //       -raw value, unformatted
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public int getDay()
   // Begin
   //    Return day
   // End
   //**********************************************************************
   public int getDay()
   {
      return day;
   }   
   

   //**********************************************************************
   //    Name: getYear
   //    Description: Public accessor for year.
   //    Preconditions: Year should be set to valid value.
   //    Returns: year
   //       -as integer
   //       -raw value, unformatted
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public int getYear()
   // Begin
   //    Return year
   // End   
   //**********************************************************************   
   public int getYear()
   {
      return year;
   }
   

   //**********************************************************************
   //    Name: setMonth
   //    Description: Public mutator for month.
   //    Parameters: m, int
   //       -should be valid month
   //    Post Conditions: If valid, month is set to m, if not, an
   //       exception is thrown to handle the error. 
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public void setMonth( int m )
   // Begin
   //    If isValidMonth(month)
   //       Set month to m
   //    Else
   //       Throw IllegalArgumentException("Month must be between 1 " +
   //          "and 12, inclusive")
   //    End If   
   // End
   //**********************************************************************     
   public void setMonth( int m )
   {
      if(isValidMonth(m))
      {
         month = m;
      }
      else
      {
         throw new IllegalArgumentException("Month must be between 1 and 12, " + 
            "inclusive");
      }   
   }
  


   //**********************************************************************
   //    Name: setDay
   //    Description: Public mutator for day.
   //    Parameters: d, int
   //       -should be valid day for month
   //       -year and month should be updated before day to ensure
   //        day remains valid for date.
   //    Post Conditions: If valid, day is set to d, if not, an
   //       exception is thrown to handle the error. 
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public void setDay( int d )
   // Begin
   //    If isValidDay(day)
   //       Set day to d
   //    Else
   //       Throw IllegalArgumentException("Day value " + d + 
   //            " is invalid for month value " + month);
   //    End If
   // End   
   //**********************************************************************  
   public void setDay( int d )
   {
      if(isValidDay(d))
      {
         day = d;
      }
      else
      {
         throw new IllegalArgumentException("Day value " + d + 
            " is invalid for month value " + month);
      }
   }
   
   
   //**********************************************************************
   //    Name: setYear
   //    Description: Public mutator for year.
   //    Parameters: y, int
   //       -should be non-negative number
   //    Post Conditions: If valid, year is set to y, if not, an
   //       exception is thrown to handle the error. 
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public void setYear( int y )
   // Begin      
   //    If isValidYear(year)
   //       Set year to y
   //    Else
   //       Throw IllegalArgumentException("Year must be positive ( > 0 )")
   //    End If
   // End
   //**********************************************************************   
   public void setYear( int y )
   {      
      if(isValidYear(y))
      {
         year = y;
      }
      else
      {
         throw new IllegalArgumentException("Year must be positive ( > 0 )");
      }  
   }
 
   
   //**********************************************************************
   //    Name: equals
   //    Description: This method determines if this date object and another
   //       contain the same date.
   //    Parameters: other, Date
   //       -method requires another date object to compare to this date 
   //        object
   //    Returns: equals
   //       -as boolean
   //       -true if the two date objects contain the same date
   //       -false if not
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public boolean equals(Date other)
   //    Set boolean equals to day == other.getDay() AND month == other.getMonth() 
   //      AND year == other.getYear()    
   //    Return equals
   // End   
   //**********************************************************************
   public boolean equals(Date other)
   {
      // Use boolean statement to determine if the instance variables in the 
      // two date objects are equal
      boolean equals = (day == other.getDay()) && (month == other.getMonth()) &&
         (year == other.getYear());
      
      return equals;
   }
   
   
   //**********************************************************************
   //    Name: toString
   //    Description: This method returns a formatted string of this date.
   //    Preconditions: Date should be initialized to valid date.
   //    Returns: monthAsString, day, and year
   //       -monthAsString as string
   //          -three character abbreviation of this month
   //       -day and year as integers
   //          -day formatted with two digit place-holders
   //          -year formatted with four digit place-holders
   //       -ex: returns: "FEB-3-2000"
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public string toString()
   // Begin
   //    Set string monthAsString to getMonthAsString()
   //    Return monthAsString, day, and year Formatted as MMM-DD-YYYY
   // End   
   //**********************************************************************
   public String toString()
   {
      String monthAsString = getMonthAsString();
      
      // Return date as string with two numeric places for day and four for year
      return String.format("%s-%02d-%04d", monthAsString, day, year);
   }


   //**********************************************************************
   //    Name: getDayNumber
   //    Description: This method determines the day number of date in
   //       this date's year.
   //    Preconditions: Date should be initialized to valid date.
   //    Returns: dayNumber.
   //       -as integer
   //       -number of days in month + day
   //       -ex: "FEB-3-2000" returns: 34
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public int getDayNumber()
   // Begin
   //    Set integer dayNumber to 0
   //    Set integer monthCount to 1
   //    While monthCount < month
   //       Set dayNumber to dayNumber + getLastDay(monthCount)
   //       Set monthCount to monthCount + 1
   //    End While
   //    Set dayNumber to dayNumber + day
   //    Return dayNumber
   // End
   //**********************************************************************
   public int getDayNumber()
   {
      int dayNumber = 0;
      
      // For every month in date, add getLastDay() to dayNumber
      for(int monthCount = 1; monthCount < month; monthCount++)
      {
         dayNumber += getLastDay(monthCount);
      }
      
      dayNumber += day;
      
      return dayNumber;
   }


   //**********************************************************************
   //    Name: addDays
   //    Description: This method adds any number of days to this 
   //       date object.
   //    Parameters: amt, Date
   //       -should be the number of days to increment date by
   //    Post Conditions: Instance variables are updated to represent
   //       new values determined by the number of days added to date.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public void addDays(int amt)
   // Begin
   //    Set integer dateInDays to getDateInDays()
   //    Set dateInDays to dateInDays + amt
   //    setDateFromDaysCount(dateInDays)
   // End
   //**********************************************************************   
   public void addDays(int amt)
   {
      // Convert date into days
      int dateInDays = getDateInDays();
      
      // Add amt of days
      dateInDays += amt;
      
      // Set date from days count
      setDateFromDaysCount(dateInDays);
   }  


   //**********************************************************************
   //    Name: compareTo
   //    Description: This method subtracts the smaller of this date
   //       object and a different date object.
   //    Parameters: other, Date
   //       -input should be another Date object
   //    Returns: compareTo
   //       -as integer
   //       -returns -1 if other date is more recent
   //       -returns 1 if this date is more recent
   //       -returns 0 is the two dates are the same
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public int compareTo(Date other)
   // Begin
   //    Set integer to compareTo 
   //    If getDateInDays() < other.getDateInDays()
   //       Set compareTo to -1
   //    Else If getDateInDays() > other.getDateInDays()
   //       Set compareTo to 1
   //    Else
   //       Set compareTo to 0
   //    End If
   //    Return compareTo
   // End  
   //**********************************************************************   
   public int compareTo(Date other)
   {
      int compareTo;
      
      // Use getDateInDays() to get total numbers of days in Date object then
      // compare this object to other object to determine which one is larger 
      if(getDateInDays() < other.getDateInDays())
      {
         compareTo = -1;
      }
      else if(getDateInDays() > other.getDateInDays())
      {
         compareTo = 1;
      }
      else
      {
         compareTo = 0;
      }
      
      return compareTo;
   }


   //**********************************************************************
   //    Name: getDaysApart
   //    Description: This method subtracts the smaller of this date
   //       object and a different date object from the larger.
   //    Parameters: other, Date
   //       -input should be another Date object
   //    Returns: result
   //       -as integer
   //       -number of days between the two dates
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public int getDaysApart(Date other)
   // Begin
   //    Set integer compareTo to compareTo(other)
   //    Declare integer result
   //    If compareTo == 1
   //       Set result to getDateInDays() - other.getDateInDays()
   //    Else If compareTo == -1 
   //       Set result to other.getDateInDays() - getDateInDays()         
   //    Else
   //       Set result to 0
   //    End If
   //    Return result
   // End  
   //**********************************************************************
   public int getDaysApart(Date other)
   {
      // Use compareTo() to determine the larger Date object.  If compareTo is 
      // returned as 1 then this date object is larger, -1 is returned if 
      // other is larger, and 0 is returned if they are equal
      int compareTo = compareTo(other);
      int result;
      
      
      // Convert date to days using getDateInDays() 
      // Subtract the smaller Date object from the larger
      if(compareTo == 1)
      {
         result = getDateInDays() - other.getDateInDays();
      }
      else if(compareTo == -1)
      {
         result = other.getDateInDays() - getDateInDays();         
      }
      else
      {
         result = 0;
      }
      
      // Then return result
      return result;
   
   }


   //**********************************************************************
   //    Name: setDateFromDaysCount
   //    Description: This method sets instance variables of a date object  
   //      to appropriate values from a date value in days.
   //    Parameters: dateInDays, int
   //    Post Conditions: Month, date, and year are set to valid entries.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private void setDateFromDaysCount(int dateInDays)
   // Begin
   //    Set constant integer DAYS_IN_YEAR to 365
   //    Set integer yearCount to 0
   //    While dateInDays > DAYS_IN_YEAR + 1
   //       Set dateInDays to dateInDys - DAYS_IN_YEAR
   //       If isLeapYear(yearCount)
   //          Set dateInDays to dateInDays - 1
   //       Set yearCount to yearCount + 1
   //    End While
   //    Set year to yearCount
   //    Set integer monthCount to JAN
   //    While dateInDays > getLastDay(monthCount)
   //       Set dateInDays to dateInDays - getLastDay(monthCount)
   //       Set yearCount to yearCount + 1
   //    End While
   //    Set month to monthCount 
   //    Set day to dateInDays 
   // End   
   //**********************************************************************        
   private void setDateFromDaysCount(int dateInDays)
   {
   
      final int DAYS_IN_YEAR = 365;
      
      int yearCount = 0;
      
      // DAYS_IN_YEAR is incremented by 1 to account for the possibly of 
      // the final year being a leap year.  yearCount determines the current
      // year that the loop is counting.  Every time a years worth of days are 
      // subtracted, yearCount is incremented to determine total years
      while(dateInDays > DAYS_IN_YEAR + 1)
      {
         dateInDays -= DAYS_IN_YEAR;
         
         if(isLeapYear(yearCount))
         {
            dateInDays -= 1;
         }
         
         yearCount++;
      }
      
      year = yearCount;
      
      // monthCount is set to JAN and each month's getLastDay() total is 
      // subtracted as monthCount increments.  If fewer days remain then 
      // there are days in the current month, then all months have been 
      // accounted for and loop terminates
      int monthCount = JAN;
      
      while(dateInDays > getLastDay(monthCount))
      {
         dateInDays -= getLastDay(monthCount);
         monthCount++;
      }
   
      month = monthCount;
      
      // Remaining dateInDays is equal to the number of days 
      day = dateInDays; 
   }


   //**********************************************************************
   //    Name: getDateInDays
   //    Description: This method a date into days for processing.  
   //    Preconditions: Date should be initialized with valid values.
   //    Returns: dateInDays
   //             -as integer
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private int getDateInDays()
   // Begin
   //    Set integer yearInDays to 0
   //    Set integer yearCount to 0
   //    While yearCount < year
   //       yearInDays += 365
   //       If isLeapYear(yearCount)
   //          Set yearInDays to yearsInDays + 1
   //       End If
   //       Set yearCount to yearCount + 1
   //    End While
   //    Set integer dateInDays to yearInDays + getDayNumber()
   //    Return dateInDays
   // End  
   //**********************************************************************        
   private int getDateInDays()
   {
      int yearInDays = 0;
      
      // Convert years to days by running loop for number of years.  Add 
      // 365 days for each year, and add an extra day if it's a leap year
      for(int yearCount = 0; yearCount < year; yearCount++)
      {
         yearInDays += 365;
         
         if(isLeapYear(yearCount))
         {
            yearInDays += 1;
         }
      }
      
      // Use getDayNumber() to determine number of days remaining in date
      int dateInDays = yearInDays + getDayNumber();
      
      return dateInDays;
   }  


   //**********************************************************************
   //    Name: getLastDay
   //    Description: This method this method determines the last day of a 
   //       month while accounting for leap years.  
   //    Parameters: month, int
   //       -month should be valid value
   //       -year should be set to valid value
   //    Returns: lastDay
   //             -as integer
   //             -ex: if month is 12, then return 31
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public int getLastDay(int month)
   // Begin
   //    Set integer lastDay to 0
   //    If month == FEB
   //       Set lastDay to 28
   //       If isLeapYear(year)
   //          Set lastDay to lastDay + 1
   //       End If
   //    Else If month >= JAN AND month <= JUL
   //       Set lastDay to 31
   //       If month % 2 == 0
   //          Set lastDay to 30
   //       End If
   //    Else If month >= AUG AND month <= DEC
   //       Set lastDay to 30
   //       If month % 2 == 0
   //          Set lastDay to 31
   //       End If
   //    Else
   //       Set lastDay to -1
   //    End If
   //    Return lastDay
   // End
   //**********************************************************************        
   public int getLastDay(int month)
   {
      int lastDay = 0;
      
      // FEB has 28 days and 29 if it's a leap year
      if(month == FEB)
      {
         lastDay = 28;
         
         if(isLeapYear(year))
         {
            lastDay += 1;
         }
      }
      // Between JAN and JUL inclusive odd months have 31 days and even months
      // have 30
      else if((month >= JAN) && (month <= JUL))
      {
         lastDay = 31;
         
         if(month % 2 == 0)
         {
            lastDay = 30;
         }
      }
      // Between AUG and DEC inclusive odd months have 30 days and even months
      // have 31
      else if((month >= AUG) && (month <= DEC))
      {
         lastDay = 30;
         
         if(month % 2 == 0)
         {
            lastDay = 31;
         }
      }
      // All user inputs are verified before processing, so else statement
      // should never be reached.  Still, should something go wrong, 
      // lastDay's returned as -1
      else
      {
         lastDay = -1;
      }
      
      return lastDay;
   }


   //**********************************************************************
   //    Name: getMonthAsString
   //    Description: This method converts a month from integer form to
   //       a the character string abbreviation of that specific month.  
   //    Preconditions: Month should be assigned to a valid value.
   //    Returns: monthToPrint
   //             -as string
   //             -three string abbreviation of month
   //             -ex: if month 12, then return "DEC"
   //             -all three characters are capitalized
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private string getMonthAsString()
   // Begin
   //    String monthToPrint
   //    Switch month 
   //       Case JAN:
   //          Set monthToPrint to "JAN"
   //          Break
   //       Case FEB:
   //          Set monthToPrint to "FEB"
   //          Break
   //       Case MAR:
   //          Set monthToPrint to "MAR"
   //          Break
   //       Case APR:
   //          Set monthToPrint to "APR"
   //          Break
   //       Case MAY:
   //          Set monthToPrint to "MAY"
   //          Break
   //       Case JUN:
   //          Set monthToPrint to "JUN"
   //          Break
   //       Case JUL:
   //          Set monthToPrint to "JUL"
   //          Break
   //       Case AUG:
   //          Set monthToPrint to "AUG"
   //          Break
   //       Case SEP:
   //          Set monthToPrint to "SEP"
   //          Break
   //       Case OCT:
   //          Set monthToPrint to "OCT"
   //          Break
   //       Case NOV:
   //          Set monthToPrint to "NOV"
   //          Break
   //       Case DEC:
   //          Set monthToPrint to "DEC"
   //          Break
   //       Default:
   //          Set monthToPrint to "ERROR"
   //          Break
   //    End Switch
   //    Return monthToPrint
   // End
   //**********************************************************************   
   private String getMonthAsString()
   {
      String monthToPrint;
      
      // Switch month as integer to determine appropriate string representation
      switch(month) 
      {
         case JAN:
            monthToPrint = "JAN";
            break;
         case FEB:
            monthToPrint = "FEB";
            break;
         case MAR:
            monthToPrint = "MAR";
            break;
         case APR:
            monthToPrint = "APR";
            break;
         case MAY:
            monthToPrint = "MAY";
            break;
         case JUN:
            monthToPrint = "JUN";
            break;
         case JUL:
            monthToPrint = "JUL";
            break;
         case AUG:
            monthToPrint = "AUG";
            break;
         case SEP:
            monthToPrint = "SEP";
            break;
         case OCT:
            monthToPrint = "OCT";
            break;
         case NOV:
            monthToPrint = "NOV";
            break;
         case DEC:
            monthToPrint = "DEC";
            break;
         // Default case should never be reached as inputs are verified to be 
         // between 1 and 12 inclusive
         default:
            monthToPrint = "ERROR";
            break;
      }
      
      return monthToPrint;
   }


   //**********************************************************************
   //    Name: isValidYear
   //    Description: This method determines if the value to be assigned to 
   //       year is valid and should be called whenever year is modified.  
   //    Parameters:  year, int
   //    Returns: isValidYear
   //             -as boolean
   //             -true if year is valid (non-negative)
   //             -false if not 
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static boolean isValidYear(int year)
   // Begin
   //    Set boolean isValidYear to false
   //    If year > 0
   //       Set isValidYear to true
   //    End If
   //    
   //    Return isValidYear
   // End
   //**********************************************************************          
   private static boolean isValidYear(int year)
   {
      boolean isValidYear = false;
      
      // Valid years are positive
      if (year > 0)
      {
         isValidYear = true;
      }
      
      return isValidYear;
   }


   //**********************************************************************
   //    Name: isValidMonth
   //    Description: This method determines if the value to be assigned to 
   //       month is valid and should be called whenever month is modified.  
   //    Parameters:  month, int
   //       -year should be set to a valid year prior to calling this 
   //        method
   //    Returns: isValidMonth
   //             -as boolean
   //             -true if month is valid (1-12, inclusive)
   //             -false if not 
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static boolean isValidMonth(int month)
   // Begin
   //    Set boolean isValidMonth to false
   //    If month >= JAN AND month <= DEC
   //       Set isValidMonth to true
   //    End If
   //    Return isValidMonth
   // End
   //**********************************************************************       
   private static boolean isValidMonth(int month)
   {
      boolean isValidMonth = false;
      
      // Valid months are between 1 and 12 inclusive
      if(month >= JAN && month <= DEC)
      {
         isValidMonth = true;
      }
      
      return isValidMonth;
   }


   //**********************************************************************
   //    Name: isValidDay
   //    Description: This method determines if the value to be assigned to 
   //       day is valid and should be called whenever day is modified.  
   //    Parameters:  day, int
   //       -month should be set to a valid month prior to calling this 
   //        method
   //       -year should be set to a valid year as well
   //    Returns: isValidDay
   //             -as boolean
   //             -true if day is valid (1 - last day in specific month, 
   //              inclusive)
   //             -false if not 
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private boolean isValidDay(int day)
   // Begin
   //    Set boolean isValidDay to false
   //    Set integer lastDay to getLastDay(month);
   //    If day >= 1 AND day <= lastDay
   //       Set isValidDay to true
   //    End If
   //    Return isValidDay
   // End
   //**********************************************************************    
   private boolean isValidDay(int day)
   {
      boolean isValidDay = false;
      
      // Call getLastDay() to determine the last day of the month
      int lastDay = getLastDay(month);
      
      // Valid days fall between 1 and lastDay inclusive
      if((day >= 1) && (day <= lastDay))
      {
         isValidDay = true;
      }
      
      return isValidDay;
   }

   
   //**********************************************************************
   //    Name: isLeapYear
   //    Description: This method determines if the input year is a leap year  
   //    Parameters:  year, char
   //                 -should be valid and non-negative 
   //    Returns: isLeapYear
   //             -as boolean
   //             -true if leap year
   //             -false if not 
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private boolean isLeapYear(int year)
   // Begin
   //   Set boolean isLeapYear to year % 4 == 0 AND year % 100 != 0 OR 
   //      year % 400 == 0
   //   Return isLeapYear
   // End
   //********************************************************************** 
   private boolean isLeapYear(int year)
   {
      // If year is divisible by 4 and not by 100 OR if year is divisible 
      // by 400 then it is a leap year
      boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0)) || 
         (year % 400 == 0);
      
      return isLeapYear;
   }
}