//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 6
//    Date: April 28, 2014
//    Description: Instances of the Name class store an actual name and
//       corresponding popularity ranks for 11 decades starting in 1900.
//**********************************************************************

class Name
{
   private int[] popularityRanks;
   private String name;
   
   
   //**********************************************************************
   //    Name: Name
   //    Description: This method is the constructor for class 
   //       on boolean value of anomalies.
   //    Parameters: name, string | popularityRanks int[]
   //       -name should be valid name
   //       -popularityRanks should contain corresponding ranks for each
   //        decade (1 - 11)
   //    Post Conditions: Class instance variables initialized.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public Name( String name, int[] popularityRanks ) 
   // Begin
   //    Set this.name to name
   //    Set this.popularityRanks to popularityRanks
   // End
   //**********************************************************************   
   public Name( String name, int[] popularityRanks ) 
   {
      this.name = name;
      
      this.popularityRanks = popularityRanks;
   }
 

   //**********************************************************************
   //    Name: getName
   //    Description: Public accessor for name.
   //    Preconditions: Name object must be initialized.
   //    Returns: name
   //       -as string
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public String getName()
   // Begin
   //    Return name
   // End
   //**********************************************************************     
   public String getName()
   {
      return name;
   }
   

   //**********************************************************************
   //    Name: getPop
   //    Description: Public accessor for popularityRanks.
   //    Parameters: decade, int
   //       -should be valid decade (1 - 11)
   //       -should correspond to desired popularity rank
   //    Returns: popularityRank
   //       -as int
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public integer getPop( int decade )
   // Begin
   //    Set integer popularityRank to -1
   //    If 1 <= decade AND decade < popularityRanks.length
   //       Set popularityRank to popularityRanks[decade]
   //    End If
   //    Return popularityRank   
   // End
   //**********************************************************************      
   public int getPop( int decade )
   {

      int popularityRank = -1;
      
      // Decade should be between 1 and highest decade, if not then return
      // -1
      if(1 <= decade && decade < popularityRanks.length)
      {
         popularityRank = popularityRanks[decade];
      }
      
      return popularityRank;   
   }
   
   
   //**********************************************************************
   //    Name: getHistoLine
   //    Description: This method returns a histoline for specific decade.
   //    Parameters: decade, int
   //       -should be valid decade (1 - 11)
   //       -should correspond to desired popularity rank
   //    Returns: histoLine
   //       -as string
   //       -the more popular the name, the longer the histoline.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public String getHistoLine( int decade )
   // Begin
   //    Set integer popularityRank to popularityRanks[decade]
   //    Set string histoLine to "Invalid"
   //    If popularityRank != -1
   //       histoLine = popularityRank + ": " + printStars(decade)
   //    End
   //    Return histoLine
   // End
   //**********************************************************************      
   public String getHistoLine( int decade )
   {
      int popularityRank = popularityRanks[decade];
      
      // Decades are validated, so "Invalid" should never be returned
      String histoLine = "Invalid";
      
      if(popularityRank > -1)
      {
         // Output should be formatted for display
         histoLine = String.format(" %3d: %s", popularityRank, printStars(decade));
      }
      
      return histoLine;
   }
   

   //**********************************************************************
   //    Name: getHistoLine
   //    Description: This method returns a histoline for specific decade.
   //    Preconditions: Name object must be initialized.
   //    Returns: histogram
   //       -as string
   //       -one histoline for each decade in popularityRanks
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public String getHistogram()
   // Begin
   //    Declare string histogram
   //    For integer decade = 1 While decade < popularityRanks.length 
   //       Do decade = decade + 1
   //       histogram = histogram + getHistoLine(decade) + "\n"; 
   //    End For Loop
   //    Return histogram
   // End
   //**********************************************************************               
   public String getHistogram()
   {
      String histogram = "";
      
      // call getHistoLine for each decade in popularityRanks
      for(int decade = 1; decade < popularityRanks.length; decade++)
      {
         histogram += getHistoLine(decade) + "\n"; 
      }
      
      return histogram;
   }
   

   //**********************************************************************
   //    Name: printStars
   //    Description: This method returns a string of astricks.
   //    Parameters: decade, int
   //       -should be valid decade (1 - 11)
   //    Returns: printStars
   //       -as string
   //       -star count proportional to rank for given decade
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private String printStars(int decade)
   // Begin
   //    Set constant integer MAX_COUNT to 83
   //    Set constant integer MAX_RANK to 1000
   //    Set constant PROPORTIONAL_CONTROLLER to MAX_COUNT / MAX_RANK
   //    Set integer starsToPrint to (MAX_RANK - popularityRanks[decade]) 
   //       * PROPORTIONAL_CONTROLLER  
   //    Declare string printStars
   //    If popularityRanks[decade] != 0
   //       For integer starCount to 0 While starCount < starsToPrint 
   //          Do starCount = starCount + 1
   //          printStars = printStars + "*"
   //       End For Loop
   //    End If
   //    Return printStars
   // End
   //**********************************************************************   
   private String printStars(int decade)
   {
      // max number of stars to print
      final int MAX_COUNT = 83;
      
      // max rank contained in data set
      final int MAX_RANK = 1000;
      
      // input is too large for out, so proportion control must be used
      final double PROPORTIONAL_CONTROLLER = (double)MAX_COUNT / MAX_RANK;
      final char TO_PRINT =  '*';
      String printStars = "";
      int starsToPrint;
      
      // a value of 0 implies a rank > 1000, so this case must be handled before processing  
      if(popularityRanks[decade] != 0)
      {
         // apply proportion control to input
         starsToPrint = (int)Math.round((MAX_RANK - popularityRanks[decade]) * PROPORTIONAL_CONTROLLER);  
      
         for(int starCount = 0; starCount < starsToPrint; starCount++)
         {
            printStars += TO_PRINT;
         }
      }
      
      return printStars;
   }
}