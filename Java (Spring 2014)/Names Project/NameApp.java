//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 6
//    Date: April 28, 2014
//    Description: NameApp reads name and popularity ranks from an input 
//       file, and stores data in an array as Name objects.  Methods for
//       displaying, and comparing name data are also contained in NameApp.
//       Finally, the program reports anomalies contained in input file.
//**********************************************************************

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

class NameApp
{

   // menuOption contains data for displaying main menu
   private final static String[][] menuOption = {{"A","B","C","D"},
      {"Print histogram for a name","Compare two names in a decade",
      "Print top ten names for a decade","Quit (display file anomalies)"}};      


   //**********************************************************************
   //    Name: getFileName
   //    Description: This method returns input or output file name depending 
   //       on boolean value of anomalies.
   //    Parameters: anomalies, boolean
   //       -false if input filename is requested
   //       -true if output filename is requested
   //    Returns: fileName
   //       -as string
   //       -either output filename or input filename depending on input
   //        parameter
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static String getFileName(boolean anomalies)
   // Begin
   //    Set string fileName to "names.txt"
   //    If anomalies 
   //       Set fileName to "anomalies.txt"
   //    End If
   //    Return fileName
   // End
   //**********************************************************************
   private static String getFileName(boolean anomalies)
   {
      // input filename
      String fileName = "names.txt";
      
      // output filename
      if(anomalies) fileName = "anomalies.txt";
      
      return fileName;
   }

   
   //**********************************************************************
   //    Name: accessFile
   //    Description: This method returns a scanner object that allows the
   //       input file to be read into the program. 
   //    Preconditions: Input file should exist and permissions should allow
   //       for file read or exception will be thrown. Input filename 
   //       should be updated in getFileName.
   //    Returns: streamer
   //       -as Scanner
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static Scanner accessFile()
   // Begin
   //    Set string fileName to getFileName(false)
   //    Set scanner streamer to null
   //    Try
   //       Set streamer to new Scanner(new File(fileName)
   //    Catch FileNotFoundException e
   //       Display "Error opening the file" + fileName)
   //    End Try Catch
   //    Return streamer
   // End
   //**********************************************************************      
   private static Scanner accessFile()
   {
         String fileName = getFileName(false);
         Scanner streamer = null;
         
         // streamer is inilialized in try block incase file IO error is 
         // encountered
         try
         {
            streamer = new Scanner(new File(fileName));
         }
         catch(FileNotFoundException e)
         {
            System.out.println("Error opening the file" + fileName);
         }
         
         return streamer;
   }

   
   //**********************************************************************
   //    Name: writeFile
   //    Description: This method returns a printwriter object that allows
   //       for output to file. 
   //    Preconditions: output file name should be updated in getFileName.
   //    Returns: outputStreamer
   //       -as PrintWriter
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static PrintWriter writeFile()
   // Begin
   //    Set string fileName to getFileName(true)
   //    Set PrintWriter outputStreamer to null
   //    Try
   //       Set outputStreamer to new PrintWriter(fileName)
   //    Catch FileNotFoundException e
   //       Display "Error creating the file " + fileName
   //    End Try Catch
   //    Return outputStreamer
   // End
   //**********************************************************************
   private static PrintWriter writeFile()
   {
      String fileName = getFileName(true);
      
      PrintWriter outputStreamer = null;
      
      
      // outputStreamer is inilialized in try block incase file IO error is 
      // encountered
      try
      {
         outputStreamer = new PrintWriter(fileName);
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Error creating the file " + fileName);
      }
      
      return outputStreamer;
   }



   //**********************************************************************
   //    Name: writeAnomaliesToFile
   //    Description: This method writes any anomalies in input data to
   //       output file.  Anomalies are ranks with only one or zero
   //       corresponding names.
   //    Parameters: nameList, Name[]
   //       -nameList should be populated with data
   //    Post Conditions: Any anomalies in file are written to output
   //       file.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static void writeAnomaliesToFile(Name[] nameList)
   // Begin
   //    Set PrintWriter outputStreamer to writeFile()
   //    Set integer[][] decadeData to getDecadeList()
   //    Set constant int MAX_RANK to getMaxRank(nameList)
   //    Set integer resultCounter to 0
   //    
   //    Set Name to firstResult
   //    Set boolean to secondResult
   //      
   //    For integer rank = 1 While rank <= MAX_RANK Do rank = rank + 1
   //       For integer decade = 1 While decade < decadeData[0].length 
   //          Do decade = decade + 1
   //          Set firstResult to null
   //          Set secondResult to false
   //          Set integer x to 0
   //          While firstResult == null AND x < nameList.length
   //             If nameList[x].getPop(decade) == rank
   //                Set firstResult to nameList[x]
   //             End If
   //             x = x + 1
   //          End While
   //          For x = 0 While x < nameList.length Do x = x + 1
   //             If nameList[x].getPop(decade) == rank AND 
   //                nameList[x].getName() != firstResult.getName()
   //                Set secondResult to true
   //             End If
   //          End For Loop
   //          If firstResult != null AND !secondResult
   //             resultCounter = resultCounter + 1
   //             Print to outputStreamer resultCounter + " - One name(" + 
   //                firstResult.getName() + ") for " + decadeData[1][decade] 
   //                + "-" + decadeData[2][decade] + ", rank " + rank
   //          Else If firstResult == null
   //             resultCounter = resultCounter + 1
   //             outputStreamer.println(resultCounter + " - No names for " 
   //                + decadeData[1][decade] + "-" + decadeData[2][decade] +
   //                ", rank " + rank + "."
   //       End For Loop
   //    End For Loop    
   //    Close outputStreamer
   // End   
   //**********************************************************************           
   public static void writeAnomaliesToFile(Name[] nameList)
   {
      
      PrintWriter outputStreamer = writeFile();
      
      // get decade data
      int[][] decadeData = getDecadeList();
      
      // get max rank
      final int MAX_RANK = getMaxRank(nameList);
      int resultCounter = 0;
      
      Name firstResult = null;
      boolean secondResult;
    
      // search each rank one by one  
      for(int rank = 1; rank <= MAX_RANK; rank++)
      {
         // search each decade for each rank
         for(int decade = 1; decade < decadeData[0].length; decade++)
         {
            firstResult = null;
            secondResult = false;
            
            // search each name to find anomalies
            for(Name name : nameList)
            {
               // if result is found, set it to firstName 
               if(name.getPop(decade) == rank && firstResult == null)
               {
                  firstResult = name;
               }
               // determine if second result exists in array
               else if(name.getPop(decade) == rank && firstResult != null)
               {
                  secondResult = true;
               }
            }
               
            // write anomalies to output file
            //if one result is found:
            if(firstResult != null && !secondResult)
            {
               resultCounter++;
               
               outputStreamer.println(resultCounter + " - One name(" + firstResult.getName() + ") for "
                  + decadeData[1][decade] + "-" + decadeData[2][decade] + ", rank " + rank);
            }
            //if no result is found:
            else if(firstResult == null)
            {
               resultCounter++;
               
               outputStreamer.println(resultCounter + " - No names for " 
                  + decadeData[1][decade] + "-" + decadeData[2][decade] + ", rank " + rank + ".");
            }
         }
      }
      
      // close outputStreamer
      outputStreamer.close();
   }
   

   //**********************************************************************
   //    Name: getMaxRank
   //    Description: This method determines the highest rank in array.
   //    Parameters: nameList, Name[]
   //       -nameList should be populated with data
   //    Returns: maxRank
   //       -as integer
   //       -as the highest rank in first decade
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static int getMaxRank(Name[] nameList)
   // Begin
   //    Set integer maxRank to 0
   //    For Each Name name in nameList
   //       If maxRank < name.getPop(1)
   //          Set maxRank to name.getPop(1)
   //       End If
   //    End For Each Loop
   //    Return maxRank
   // End   
   //**********************************************************************           
   public static int getMaxRank(Name[] nameList)
   {
      int maxRank = 0;
      for(Name name : nameList)
      {
         if(maxRank < name.getPop(1))
         {
            maxRank = name.getPop(1);
         }
      }
      return maxRank;
   }


   //**********************************************************************
   //    Name: getNameCount
   //    Description: This method returns the number of names in input file.
   //    Preconditions: Input file exists and contains name data.
   //    Returns: count
   //       -as integer
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static int getNameCount(Scanner streamer) 
   // Begin
   //    Set integer count to 0
   //    While streamer.hasNextLine()
   //       count = count + 1
   //       streamer.nextLine()
   //    End While
   //    
   //    Return count 
   // End
   //**********************************************************************
   private static int getNameCount(Scanner streamer) 
   {
      int count = 0;
      
      while (streamer.hasNextLine())
      {
         // increment counter for each name in input file
         count++;
         streamer.nextLine();
      }
      
      return count; 
   }


   //**********************************************************************
   //    Name: fillNameArray
   //    Description: This method returns an array of name objects populated
   //       with data from input file.
   //    Parameters: streamer, Scanner
   //       -streams input file.
   //       -input file exists and contains name data
   //    Returns: nameList
   //       -as Name array
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static Name[] fillNameArray(Scanner streamer)
   //   Set integer count to 0
   //   Set Scanner lineCounter to accessFile()
   //   Set Name[] nameArray to new Name[getNameCount(lineCounter)]
   //   Close lineCounter
   //   While streamer.hasNextLine()
   //       Set string line to streamer.nextLine()
   //       Set string[] input to line.split(" ")
   //       Set integer[] rank to new int[input.length]
   //       For integer x = 1 While x < input.length Do x = x + 1
   //          Set rank[x] to input[x]
   //       End For Loop  
   //       Set nameArray[count] to new Name(input[0], rank)
   //       count = count + 1
   //    End While
   //    Return nameArray  
   // End   
   //**********************************************************************   
   private static Name[] fillNameArray(Scanner streamer)
   {
     int count = 0;
     
     // get line count and initialize array
     Scanner lineCounter = accessFile();
     Name[] nameArray = new Name[getNameCount(lineCounter)];
     lineCounter.close();
     
     while(streamer.hasNextLine())
     {
     
         String line = streamer.nextLine();
         
         // split input to create an array from current line's data
         String[] input = line.split(" ");
         
         int[] rank = new int[input.length];
         
         //fill rank array from values in line array
         for(int x = 1; x < input.length; x++)
         {
            rank[x] = Integer.parseInt(input[x]);
         }
         
         // add name object to nameArray
         nameArray[count] = new Name(input[0], rank);
         count++;
      }
            
      return nameArray;
        
   }


   //**********************************************************************
   //    Name: showError
   //    Description: This method displays message with input error is 
   //       encountered.
   //    Parameters: message, string
   //       -should be error message to be displayed
   //    Post Conditions: Error message is displayed to user in console
   //       window.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static void showError(String message)
   // Begin
   //    Display "Error, invalid input.  " + message
   // End   
   //**********************************************************************
   public static void showError(String message)
   {
      System.out.println("Error, invalid input.  " + message);
   }


   //**********************************************************************
   //    Name: displayMenu
   //    Description: This method displays main menu options to user.
   //    Parameters: menuOption array should contain valid menu options
   //       and their descriptions.
   //    Post Conditions: Menu options are printed to console window.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static void displayMenu()
   // Begin
   //    Display "Enter the character corresponding to your choice. "
   //    For integer x = 0 While x < menuOption[0].length Do x = x + 1
   //       Display menuOption[0][x] + " - " + menuOption[1][x]
   //    End For Loop
   // End
   //**********************************************************************
   private static void displayMenu()
   {
      System.out.println("Enter the character corresponding to your choice. ");
      for(int x = 0; x < menuOption[0].length; x++)
      {
         System.out.println("\t" + menuOption[0][x] + " - " + menuOption[1][x]);
      }
   }


   //**********************************************************************
   //    Name: getUsersChoice
   //    Description: This method returns the user's menu item choice.
   //    Preconditions: displayMenu should be called to first to print
   //       menu options to console.
   //    Returns: output
   //       -as char
   //       -only valid char inputs will be returned, otherwise '/'
   //        is returned
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static char getUsersChoice()
   // Begin
   //    Declare string usersChoice
   //    Set char output to '/'
   //    Set Scanner stdin to new Scanner(System.in)
   //    Display "Enter your selection: "
   //    Set usersChoice to stdin.next()
   //    If usersChoice.length() == 1
   //       Set output to usersChoice.charAt(0)
   //    End If
   //    Return output
   // End   
   //**********************************************************************
   private static char getUsersChoice()
   {
      String usersChoice;
      
      // default char '/' is returned if invalid selection
      char output = '/';
      
      Scanner stdin = new Scanner(System.in);
      
      System.out.println("Enter your selection: ");
      
      usersChoice = stdin.next();
      
      // only inputs of one character are accepted
      if(usersChoice.length() == 1)
      {
         // convert string into char
         output = usersChoice.charAt(0);
      }
      
      return output;
   }


   //**********************************************************************
   //    Name: getNameInput
   //    Description: This method returns a verified name based off user's 
   //       input.
   //    Parameters: nameList, Name[]
   //       -should be populated with data
   //    Returns: nameInput
   //       -as string
   //       -input should exist as name in nameList
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static string getNameInput(Name[] nameList)
   //    Set string to nameInput
   //    Do While searchList(nameList, nameInput) != 0
   //       Display "Enter a name: "
   //       Set Scanner stdin to new Scanner(System.in)
   //       Set nameInput to stdin.nextLine()
   //       If searchList(nameList, nameInput) != 0
   //          Display "Name not found.  "
   //       End If
   //    End Do While
   //    Return nameInput 
   // End
   //**********************************************************************   
   private static String getNameInput(Name[] nameList)
   {
      String nameInput;
      
      do
      {
         System.out.println("Enter a name: ");
         
         Scanner stdin = new Scanner(System.in);
         
         nameInput = stdin.nextLine();
         
         // if searchList returns 0 then name was not found
         if(searchList(nameList, nameInput) != 0)
         {
            showError("Name not found.  ");
         }
         
      // continue to prompt user for input until valid entry is made
      } while(searchList(nameList, nameInput) != 0);
      
      return nameInput;
      
   }
   

   //**********************************************************************
   //    Name: searchList
   //    Description: This method uses a linear method to search an array 
   //       for a target string value.
   //    Parameters: nameList, Name[] | targetName, string
   //       -nameList should be populated with name data
   //       -targetName should be name to be searched for
   //    Returns output, integer
   //       -(-1) if targetName is not found
   //       -0 if targetName is found
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static integer searchList(Name[] nameList, String targetName)
   // Begin
   //    Set integer output to -1
   //    For Each Name name in nameList
   //       If name.getName().toLowerCase().equals(targetName.toLowerCase())
   //          output = 0;
   //    End For Each
   //    Return output
   // End   
   //**********************************************************************
   public static int searchList(Name[] nameList, String targetName)
   {
      // returns -1 if no result is found
      int output = -1;
      
      for(Name name : nameList)
      {
         
         // names are searched ignoring letter case
         if(name.getName().toLowerCase().equals(targetName.toLowerCase()))
         {
            output = 0;
         }
      }
      
      return output;
   }


   //**********************************************************************
   //    Name: getDecadeInput
   //    Description: This method prompts for and gets user's decade 
   //       selection.
   //    Parameters: none
   //    Returns: decadeInput
   //       -as integer
   //       -returns only valid inputs
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static integer getDecadeInput()
   // Begin
   //    Set Scanner stdin to new Scanner(System.in)
   //    Set integer[][] decadeData to getDecadeList()
   //    Display "Enter number corresponding to your decade: "
   //    For integer x = 1 While x < decadeData[0].length Do x = x + 1
   //       Display "   " + decadeData[0][x] + " - " + decadeData[1][x] + 
   //          "-" + decadeData[2][x]
   //    End For Loop
   //    Set integer decadeInput to 0
   //    Do While !isValidDecade(decadeInput)
   //       Display "Enter a decade: "
   //       If stdin.hasNextInt()
   //          Set decadeInput to stdin.nextInt()
   //       Else
   //          showError("Input must be an integer.  ")
   //          stdin.next()
   //       End If
   //       If !isValidDecade(decadeInput)
   //          showError("Enter an integer between " + decadeData[0][1] + " and "
   //             + decadeData[0][decadeData[0].length - 1]);
   //       End If
   //    Return decadeInput
   // End
   //**********************************************************************   
   private static int getDecadeInput()
   {
      Scanner stdin = new Scanner(System.in);
      
      // get decade data
      int[][] decadeData = getDecadeList();
      
      int decadeInput;
      
      System.out.println("Enter number corresponding to your decade: ");
      
      //display decade data
      for(int x = 1; x < decadeData[0].length; x++)
      {
         System.out.println("   " +decadeData[0][x] + " - " + decadeData[1][x] + 
            "-" + decadeData[2][x]);   
      }
              
      do
      {
         decadeInput = 0;
         System.out.print("Enter a decade: ");
      
         // verify user's input is an integer
         if(stdin.hasNextInt())
         {
            decadeInput = stdin.nextInt();
         }
         else
         {
            showError("Input must be an integer.  ");
            stdin.next();
         }
         
         // verify user's input is valid decade representation
         if(!isValidDecade(decadeInput) && decadeInput != 0)
         {
            showError("Enter an integer between " + decadeData[0][1] + " and "
               + decadeData[0][decadeData[0].length - 1]);
         }
      
      // continue to prompt user until valid entry is made
      }while(!isValidDecade(decadeInput));
      
      return decadeInput;      
   }


   //**********************************************************************
   //    Name: isValidDecade
   //    Description: This method verifies user input is a valid decade 
   //       representation.
   //    Parameters: decade, int
   //    Returns: validDecade
   //       -as boolean
   //       -true if valid
   //       -false if invalid
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private static boolean isValidDecade(int decade)
   // Begin
   //    Set integer[][] decadeData to getDecadeList()
   //    Set boolean validDecade to false
   //    If decade > decadeData[0][0] && decade <= 
   //       decadeData[0][decadeData[0].length - 1]
   //       Set validDecade to true
   //    End If
   //    Return validDecade
   // End
   //**********************************************************************         
   private static boolean isValidDecade(int decade)
   {
      int[][] decadeData = getDecadeList();
      boolean validDecade = false;
      
      if(decade > decadeData[0][0] && decade <= decadeData[0][decadeData[0].length - 1])
      {
         validDecade = true;
      }
      return validDecade;
   }
   
   
   //**********************************************************************
   //    Name: getDecadeList
   //    Description: This method returns an array of integers pertinent to
   //       decade data.
   //    Preconditions: none
   //    Returns: decadeList
   //       -as 2 dimensional integer array
   //       -column 1 contains decade id (1 - 11)
   //       -column 2 & 3 contain actual decade span
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static int[][] getDecadeList()
   // End
   //    Set constant integer DECADE_COUNT to 11
   //    Set constant integer REAL_DECADE_START to 1900
   //    Set constant integer REAL_DECADE_INCREMENT to 10
   //    Set integer decadeEnd
   //    Set integer realDecade to REAL_DECADE_START
   //    Set integer[][] decadeList to new int[3][DECADE_COUNT + 1]
   //    For integer x = 1 While x < decadeList[0].length Do x = x + 1
   //       Set decadeList[0][x] to x
   //       Set decadeList[1][x] to realDecade
   //       Set decadeEnd to 9
   //       If x == decadeList[0].length - 1
   //          Set decadeEnd to 5
   //       End If
   //       Set decadeList[2][x] to realDecade + decadeEnd
   //       realDecade = realDecade + REAL_DECADE_INCREMENT
   //    End For Loop
   //    Return decadeList
   // End
   //**********************************************************************
   public static int[][] getDecadeList()
   {
      // total number of decades
      final int DECADE_COUNT = 11;
      
      // start decade
      final int REAL_DECADE_START = 1900;
      
      // decade will be increase by for each iteration of the loop
      final int REAL_DECADE_INCREMENT = 10;
      
      // end values of decade. is different in last decade
      final int END = 9;
      final int END_LAST = 5;
      
      int decadeEnd;
      
      int realDecade = REAL_DECADE_START;
      
      int[][] decadeList = new int[3][DECADE_COUNT + 1];
      
      for(int x = 1; x < decadeList[0].length; x++)
      {
         decadeList[0][x] = x;
         decadeList[1][x] = realDecade;
         
         decadeEnd = END;
         
         // if last decade then set decadeEnd to END_LAST
         if(x == decadeList[0].length - 1) decadeEnd = END_LAST;
         
         decadeList[2][x] = realDecade + decadeEnd;
         
         realDecade += REAL_DECADE_INCREMENT;
      }
      
      return decadeList;
   }


   //**********************************************************************
   //    Name: displayHistogram
   //    Description: This method prompts for and gets a valid name from user
   //       and then displays a histogram for inputted name.
   //    Parameters: nameList, Name[]
   //       -should be populated with name and corresponding popularity rank 
   //        data
   //    Post Conditions: Histogram is printed to console window depending on
   //       user's input.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static void displayHistogram(Name[] nameList)
   // Begin
   //    Set string input to getNameInput(nameList)
   //    Set Name name to getName(nameList, input)
   //    Display "Historgram for name, " + name.getName()
   //    Display name.getHistogram()
   // End
   //**********************************************************************
   public static void displayHistogram(Name[] nameList)
   {
      String input = getNameInput(nameList);
      
      Name name = getName(nameList, input);
      
      System.out.println("Historgram for name, " + name.getName());
      
      System.out.print(name.getHistogram());
   }
   

   //**********************************************************************
   //    Name: getName
   //    Description: This method returns a name object from name.
   //    Parameters: nameList, Name[] | targetName, string
   //       -nameList should be populated with name data
   //       -targetName should be verified name
   //    Returns output, Name
   //       -name object where name is equal to targetName
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static Name getName(Name[] nameList, String targetName)
   // Begin
   //    Set Name output to null
   //    For Each Name name in nameList
   //       If name.getName().toLowerCase().equals(targetName.toLowerCase())
   //          Set output to name
   //       End If
   //    End For Each
   //    Return output
   // End
   //**********************************************************************
   public static Name getName(Name[] nameList, String targetName)
   {
      Name output = null;
      
      // search each for name for match ignoring letter case
      for(Name name : nameList)
      {
         if(name.getName().toLowerCase().equals(targetName.toLowerCase()))
         {
            output = name;
         }
      }
      
      return output;
   }
   

   //**********************************************************************
   //    Name: compareTwoNames
   //    Description: This method displays histolines for two names for a
   //       specific decade.
   //    Parameters: nameList
   //       -should be populated with valid data
   //    Post Conditions: Two histolines for two different names are displayed
   //       for a specific decade based off user's input.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static void compareTwoNames(Name[] nameList)
   // Begin
   //    Set string firstInput to getNameInput(nameList)
   //    Set string secondInput to getNameInput(nameList)
   //    Set Name firstName to getName(nameList, firstInput)
   //    Set Name secondName to getName(nameList, secondInput)
   //    Set int decade to getDecadeInput()
   //    Display "Data for " + firstName.getName()
   //    Display firstName.getHistoLine(decade)
   //    
   //    Display "Data for " + secondName.getName()
   //    Display secondName.getHistoLine(decade)
   // End
   //**********************************************************************   
   public static void compareTwoNames(Name[] nameList)
   {
      String firstInput = getNameInput(nameList);
      String secondInput = getNameInput(nameList);
      
      // get Name objects corresponding to user's selection
      Name firstName = getName(nameList, firstInput);
      Name secondName = getName(nameList, secondInput);
      
      int decade = getDecadeInput();
      
      System.out.println("Data for " + firstName.getName());
      System.out.println(firstName.getHistoLine(decade));
      
      System.out.println("Data for " + secondName.getName());
      System.out.println(secondName.getHistoLine(decade));
     
   }
   

   //**********************************************************************
   //    Name: displayTopTenNames
   //    Description: This method displays the top ten names for a specific
   //       decade.
   //    Parameters: nameList
   //       -should be populated with valid data
   //    Post Conditions: Twenty names are displayed to console in ascending
   //       order
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static void displayTopTenNames(Name[] nameList)
   //    Set integer maxLimit to 10
   //    Set integer decade to getDecadeInput()
   //    Set integer count to 0
   //    Declare integer y
   //    Declare integer z
   //    Set Name[] topList to new Name[maxLimit * 2]
   //    For Each Name name in nameList
   //       If name.getPop(decade) <= maxLimit && name.getPop(decade) > 0
   //          Set topList[count] to name
   //          count = count + 1;
   //       End If
   //    End For Loop
   //    sortNamesByDecade(topList, decade)
   //    For integer x = 0 While x < topList.length Do x += 2
   //       Set y to x
   //       Set z to x + 1
   //       If topList[x + 1].getName().compareTo(topList[x].getName()) < 0
   //          Set y to x + 1
   //          Set z to x
   //       Display
   //          topList[y].getName() + "(" + topList[y].getPop(decade) + ")" + 
   //          topList[z].getName() + "(" + topList[z].getPop(decade) + ")"
   //    End For Loop
   // End   
   //**********************************************************************   
   public static void displayTopTenNames(Name[] nameList)
   {
      // max limit determine how many ranks are displayed
      int maxLimit = 10;
      
      int decade = getDecadeInput();
      int count = 0;
      int y;
      int z;
      
      // create Name array to hold results
      Name[] topList = new Name[maxLimit * 2];
      
      for(Name name: nameList)
      {
         if(name.getPop(decade) <= maxLimit && name.getPop(decade) > 0)
         {
            topList[count] = name;
                
            count++;
         }
      }
      
      // resulting array is unsorted, so the array must be sorted for display purposes
      sortNamesByDecade(topList, decade);
      
      for(int x = 0; x < topList.length; x += 2)
      {
         y = x;
         z = x + 1;
         
         // results on each line are display in alphabetical order
         if(topList[x + 1].getName().compareTo(topList[x].getName()) < 0)
         {
            y = x + 1;
            z = x;
         }
         
         // results displayed formatted into columns
         System.out.printf("%-15s %-15s \n", 
            topList[y].getName() + "(" + topList[y].getPop(decade) + ")", 
            topList[z].getName() + "(" + topList[z].getPop(decade) + ")");
      }
      
   }
   
   
   //**********************************************************************
   //    Name: sortNamesByDecade
   //    Description: This method sorts an array of name objects by ranking
   //       in a specific decade.
   //    Parameters: nameList, Name[] | decade, int
   //       -nameList should be populated with valid data
   //       -decade should be valid decade (1 - 11)
   //    Post Conditions: Twenty names are displayed to console in ascending
   //       order
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static Name[] sortNamesByDecade(Name[] nameList, int decade)
   // Begin
   //    Set integer to indexOfNextSmallest 
   //    For integer index = 0 While index < nameList.length - 1 
   //       Do index = index + 1 
   //       Set indexOfNextSmallest to getIndexOfNextSmallest
   //          (index, nameList, decade)
   //       Set nameList to interchange(index, indexOfNextSmallest, nameList)
   //    End For Loop
   //    Return nameList
   // End      
   //**********************************************************************   
   public static Name[] sortNamesByDecade(Name[] nameList, int decade)
   {
      int indexOfNextSmallest; 
      
      // sort array so that nameList[0] is smallest value, nameList[1] is next
      // smallest, and so on until end of array contains highest value.
      for(int index = 0; index < nameList.length - 1; index++)
      {
         // find smallest value in remaining portion of the array
         indexOfNextSmallest = getIndexOfNextSmallest(index, nameList, decade);
         
         // switch the positions of smallest value and current value
         nameList = interchange(index, indexOfNextSmallest, nameList);  
      }
      
      return nameList;
   }

   
   //**********************************************************************
   //    Name: getIndexOfNextSmallest
   //    Description: This method searches an array of name objects for the
   //       smallest rank for a specific decade starting at a specific index.
   //    Parameters: start, int | nameList, Name[] | decade, int
   //       -start should be first index of unsorted portion of an array
   //       -nameList should be populated with valid data
   //       -decade should be valid decade (1 - 11)
   //    Returns: Index of smallest value with-in the unsorted portion
   //       of a name array
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static integer getIndexOfNextSmallest
   //    (int start, Name[] nameList, int decade)
   // Begin
   //    Set integer min to nameList[start].getPop(decade)
   //    Set integer indexOfMin to start
   //    For integer index = start + 1 While index < nameList.length 
   //       Do index = index + 1
   //       If min > nameList[index].getPop(decade)
   //          min = nameList[index].getPop(decade);
   //          indexOfMin = index;
   //       End If
   //    End For Loop
   //    Return indexOfMin
   // End
   //**********************************************************************        
   public static int getIndexOfNextSmallest(int start, Name[] nameList, int decade)
   {
      int min = nameList[start].getPop(decade);
      int indexOfMin = start;
      
      // find smallest value in array starting at the index of start
      for(int index = start + 1; index < nameList.length; index++)
      {
         if(min > nameList[index].getPop(decade))
         {
            min = nameList[index].getPop(decade);
            
            indexOfMin = index;
         }
      }
      
      return indexOfMin;
   }

      
   //**********************************************************************
   //    Name: interchange
   //    Description: This method switches the location of two name objects
   //       with an array.
   //    Parameters: x, int | y, int | nameList, Name[]
   //       -x should be the index of first name
   //       -y should be the index of second name
   //       -nameList should be populated with data
   //    Returns: nameList, Name[]
   //       -names at index x and index y are switched in returned array
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static Name[] interchange(int x, int y, Name[] nameList)
   // Begin
   //    Set Name temp to nameList[x]
   //    Set nameList[x] to nameList[y]
   //    Set nameList[y] to temp
   //    Return nameList
   // End
   //**********************************************************************        
   public static Name[] interchange(int x, int y, Name[] nameList)
   {
      Name temp = nameList[x];
      
      nameList[x] = nameList[y];
      
      nameList[y] = temp;
      
      return nameList;
   }


   //**********************************************************************
   //    Name: main
   //    Description: Main method switches user option to determine 
   //       appropriate action.
   //    Preconditions: none
   //    Post Conditions: Appropriate method is called depending on user's
   //       valid selection.
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public static void main(String[] args)
   // Begin
   //    Set Scanner inputStreamer to accessFile()
   //    Set Name[] nameList to fillNameArray(inputStreamer)
   //    Close inputStreamer
   //    Declare char choice
   //    Set boolean stillWorking to true
   //    Do While stillWorking
   //       displayMenu()
   //       Set choice to getUsersChoice()
   //       Switch choice 
   //          case 'A'
   //             displayHistogram(nameList)
   //          case 'B'
   //             compareTwoNames(nameList)
   //          case 'C'
   //             displayTopTenNames(nameList)
   //          case 'D'
   //             Display "Terminating... but first the anomalies " +
   //                "in the data file: "
   //             writeAnomaliesToFile(nameList)
   //             Display "Anomolies written to " + 
   //                getFileName(true) + "."
   //             Set stillWorking to false;
   //          default
   //             showError("Please select an option " + menuOption[0][0] + 
   //                "-" + menuOption[0][menuOption[0].length - 1] + ". "          
   //       End Switch
   //    End While
   // End
   //**********************************************************************           
   public static void main(String[] args)
   {
      Scanner inputStreamer = accessFile();
      Name[] nameList = fillNameArray(inputStreamer);
      inputStreamer.close();  
      char choice;
      boolean stillWorking = true;
      
      do 
      {
         displayMenu();
         choice = getUsersChoice();
         
         // switch users choice to determine appropriate action
         switch( choice ) 
         {
            case 'A': 
            case 'a':
               displayHistogram(nameList);
               break;
            case 'B':
            case 'b':
               compareTwoNames(nameList);
               break;  
            case 'C':
            case 'c':
               displayTopTenNames(nameList);
               break;
            case 'D':
            case 'd':
               System.out.println("Terminating... but first the anomalies " +
                  "in the data file: ");
  
               writeAnomaliesToFile(nameList);
               
               System.out.println("Anomolies written to " + 
                  getFileName(true) + ".");
               
               stillWorking = false;
               break;
            default:
               showError("Please select an option " + menuOption[0][0] + 
                  "-" + menuOption[0][menuOption[0].length - 1] + ". ");
               break;          
         }
      // program terminates when stillWorking is set to false
      } while(stillWorking);  
   }
}