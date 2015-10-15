//**********************************************************************
//    Programmer: John Gardiner        CSC110 Programming Assignment 5
//    Date: March 24, 2014
//    Description: This program, once initialized with a word, runs
//        a game of Hangman.  The user is prompted to guess a letter,
//        and if the guess matches a letter in the secret work, then its
//        exposed in a hidden word that's then displayed to the user.
//        The game continues until the user correctly guesses the
//        secret word.
//    Input: User is promted to guess a letter, char
//    Output: disguisedWord, guessCount, incorrectGuessCount
//        -disguisedWord as string
//        -characters begin hidden and are revealed as correctly guessed
//         by user
//        -guessCount and incorrectGuessCount as int
//        -guessCount incremented for every guess
//        -incorrectGuessCount incremented for every incorrect guess 
//**********************************************************************

import java.util.Scanner;

class Hangman
{
	private String secretWord;
	
   // disguisedWord is the same length as secretWord but each letter is
   // replaced by a special character that is exposed as the user correctly
   // guesses the corresponding character  
   // Displayed before each prompt for guess from user 
   private String disguisedWord;
	
   // incorrectGuesses is a string list of all incorrect guess stored in
   // alphabetical order
   // Displayed before each prompt for guess from user
   private String incorrectGuesses;
   private int guessCount;
   private int incorrectGuessCount;
      
      
   //**********************************************************************
   //    Name: getSectretWord
   //    Description: Public accessor for secretWord- returns setretWord
   //        to calling method.
   //    Returns: secretWord
   //        -as string
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public string getSecretWord()
   // Begin
   // 	Return secretWord
   // End
   //**********************************************************************
	public String getSecretWord()
	{
		return secretWord;
	}
   
   
   //**********************************************************************
   //    Name: getDisguisedWord
   //    Description: Public accessors for secretWord- returns setretWord
   //        to calling method.
   //    Returns: disguisedWord
   //        -returned as string
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public string getDisguisedWord()
   // Begin
   // 	Return disguisedWord
   // End
   //**********************************************************************
	public String getDisguisedWord()
	{
		return disguisedWord;
	}
	
   
   //**********************************************************************
   // --------------------------------------------------------------
   // Pseudocode for main method:
   // --------------------------------------------------------------
   // Public static void main()
   // Begin
   // 	Set Hangman game to new Hangman()
   //    Display "Lets play a game of hangman. "
   //    Start game by calling playGame()
   // End
   //**********************************************************************
   public static void main(String[] args)
   {
      Hangman game = new Hangman();         
      
      game.initialize("Happiness");         
      
      System.out.println("Lets play a round of hangman. ");                 
      
      // Calling playGame starts the game
      game.playGame(); 
   }
  
  
   //**********************************************************************
   //    Name: initialize
   //    Description: This method initializes the instance variables for
   //        the class, and sets disguisedWord's initial format.
   //    Parameters:  newSecretWord, string
   //                 -used to set sercetWord and determine length of 
   //                  disguisedWord
   //    Sets: secretWord, disguisedWord, guessCount, incorrectGuessCount
   //        incorrectGuesses
   //        -class instance vaible are initialized to default values
   //        -0 for integers and "" for stirngs
   //        -secretWord set to newSecretWord
   //        -disguisedWord set to string of special characters equal in 
   //         length to secretWord
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Begin
   // 	secretWord = newSecretWord
   // 	Set integer charCount to 0
   // 	guessCount = 0
   // 	incorrectGuessCount = 0
   //    incorrectGuesses = "";
   //    disguisedWord = "";
   // 	While charCount is less than the character count of secretWord
   // 		disguisedWord = disguisedWord + "?"
   // 		charCount = charCount + 1
   // 	End While
   // End
   //**********************************************************************
	public void initialize(String newSecretWord)
	{
      // DISGUISE_SYMBOL replaces characters in sectretWord when creating
      // disguisedWord
      final String DISGUISE_SYMBOL = "?";
      
      // Initialize instance variables
		secretWord = newSecretWord;
      disguisedWord = "";
		guessCount = 0;
		incorrectGuessCount = 0;
      incorrectGuesses = "";
      
      // Set disguisedWord to the appropriate number of DISGUISE_SYMBOL's
      for(int charCount = 0; charCount < secretWord.length(); charCount++)
      {
			disguisedWord += DISGUISE_SYMBOL;
		}
	}
	
   
   //**********************************************************************
   //    Name: playGame
   //    Description: This method gets input from the user.  User is 
   //        prompted to guess a letter, while relevant data displayed to 
   //        console window between guesses.
   //    Precondition: game should be initialized
   //    Output: disguisedWord, guessCount, incorrectGuessCount, 
   //        incorrectGuesses
   //        -output to console
   //        -disguisedWord and incorrectGuessCount as strings
   //        -incorrectGuesses in alphabetical order
   //        -guessCount and incorrectGuessCount as integers
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public void playGame()
   // Begin
   //    Declare string tempString
   //    Declare char guess
   //    While isFound() is false
   //       Display "The disguised word is <" + disguisedWord + ">"
   //       Prompt for and Get tempString from user
   //       If isValidGuess(tempString) returns true
   //          Set guess equal to tempString
   //          If isRepeatGuess(guess) returns false
   //             makeGuess(guess)
   //             Display "Guesses made: " + guessCount + " with " + 
   //                incorrectGuessCount + " wrong (" + incorrectGuesses + ")"
   //          Else
   //             Display "Already guessed that one, try again. "
   //          End If
   //       Else
   //          Display "Sorry, bad guess.  Need a single letter."
   //       End If
   //    End While
   //    endGame()
   // End
   //**********************************************************************
   public void playGame()
   {
      // tempString holds user input until it can be validated and converted
      // to a char
      String tempString;
      
      char guess;
      
      Scanner stdin = new Scanner(System.in);
      
      // Repeat until secretWord is found by user
      while(!isFound())
      {
         System.out.println("The disguised word is <" + 
            disguisedWord + ">");
      
         System.out.print("Guess a letter: ");
         tempString = stdin.next().toLowerCase();
         
         // Validate input- only single letter inputs of a to z accepted
         // Error message is displayed if invalid
         if(isValidGuess(tempString))
         {
            // Convert tempString into a char for processing
            guess = tempString.charAt(0);
            
            // If the input is a repeat of previous input then display error
            if(!isRepeatGuess(guess))
            {            
               makeGuess(guess);
               
               System.out.println("Guesses made: " + guessCount + " with " + 
                  incorrectGuessCount + " wrong (" + incorrectGuesses + ")");
            }
            else
            {  
               System.out.println("Already guessed that one, try again. ");
            }
         }
         else
         {
            System.out.println("Sorry, bad guess.  Need a single letter.");
         }
      }
      
      endGame();
   }


   //**********************************************************************
   //    Name: makeGuess
   //    Description: This method checks the user's guess for a match in 
   //        secretWord.  If match is found then each character in secretWord
   //        matching the user's guess is revealed in disguisedWord by
   //        calling updateString().  If no match is found then guess is added
   //        to incorrectGuesses by calling addIncorrectGuesses() and
   //        incorrectGuessCount is incremented by 1.  guessCount is incremented
   //        by one for each guess.  
   //    Parameters: guess, char
   //                -must be from a-z or A-Z
   //    Post Conition: guessCount is incremented by 1 for each guess
   //                  -incorrectGuessCount is incremented by 1 for each 
   //                  incorrect guess
   //                  -guess is added to incorrectGuesses (if not match)
   //                   or its revealed in disguisedWord (if match)
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private void makeGuess(char guess)
   // Begin
   // 	Set integer charCount to 0
   // 	While charCount is less than the character count of secretWord
   // 		If guess is equal to character at charCount in secretWord
   // 			disguisedWord = updateString(disguisedWord, guess, charCount)
   // 		Else If charCount is equal to the character count of secretWord
   // 			incorrectGuessCount = incorrectGuessCount + 1
   // 			addIncorrectGuesses(guess)
   // 		End If
   // 		charCount = charCount + 1
   // 	End While
   // 	guessCount = guessCount + 1
   // End
   //**********************************************************************
	private void makeGuess(char guess)
   {
      boolean resultFound = false;
		
      // Search secretWord one char at a time
      for(int charCount = 0;  charCount < secretWord.length(); charCount++)
      {
         // If guess matches a disguised char then it is revealed
      	if(guess == secretWord.toLowerCase().charAt(charCount))
         {
				updateDisguisedWord(guess, charCount);
            
            resultFound = true;
			}
         // If not, it's added to the string incorrectGuesses in alphabetical 
         // order and incorrectGuess count is incremented
         else if(!resultFound && charCount == secretWord.length() - 1)
         {   
				incorrectGuessCount++;
				
            addIncorrectGuess(guess);
			}
		}
      
		guessCount++;
	}
	
   
   //**********************************************************************
   //    Name: isFound
   //    Description: This method compares sectretWord to disguisedWord and
   //        result is returned.  
   //    Preconditions: game should be initialized
   //    Return: result
   //        -as boolean
   //        -true if seretWord is equal to disguisedWord 
   //        -false if not         
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private boolean isFound()
   // Begin
   // 	Boolean result = disguisedWord.equals(secretWord.toVowerCase())
   // 	return result
   // End
   //********************************************************************** 
	private boolean isFound()
	{
      boolean result = disguisedWord.equals(secretWord.toLowerCase());
      
      return result;
	}
	
   
   //**********************************************************************
   //    Name: isValidGuess
   //    Description: This method verifies that user's guess is a single letter.   
   //    Parameters:  guess, string
   //        -should be input from user
   //    Output: validGuess
   //        -as boolean
   //        -true if guess is a single letter
   //        -false if its not
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private boolean isValidGuess(String guess)
   // Begin
   //    Set boolean validGuess to true if the character count of guess
   //       is equal to 1 AND guess as a char is greater than or equal to
   //       'a' AND less than or equal to 'z'
   //    Return validGuess
   // End
   //**********************************************************************
   private boolean isValidGuess(String guess)
   {
      // Only strings of one character between a-z are accepted
      boolean validGuess = (guess.length() == 1) && 
         (guess.charAt(0) >= 'a' && guess.charAt(0) <= 'z');
      
      return validGuess;
   }
   
   
   //**********************************************************************
   //    Name: isRepeatGuess
   //    Description: This method compares user's guess to each character 
   //    in incorrectGuesses and disguisedWord and determines if guess has
   //    already been made.  
   //    Parameters:  guess, char
   //        -guess should be a valid char a-z
   //    Returns: disguisedWord
   //        -as boolean
   //        -true if guess has already been made
   //        -false if guess has not been made       
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private boolean isRepeatGuess(char guess)
   // Begin
   //    Set boolean result to true
   //    Set integer charCount to 0
   //    While charCount is less than the character count of incorrectGuesses
   //       If guess equals the character at charCount in incorrectGuesses
   //          result = true
   //       End If
   //       charCount = charCount + 1
   //    End While
   //    Set charCount to 0
   //    While charCount is less than the character count of disguisedWord
   //       If guess equals the character at charCount in disguisedWord
   //          result = true
   //       End If
   //       charCount = charCount + 1
   //    End While
   //    Return result
   // End
   //**********************************************************************
   private boolean isRepeatGuess(char guess)
   {
      boolean result = false;
      
      for(int charCount = 0; charCount < incorrectGuesses.length(); charCount++)
      {
         if(guess == incorrectGuesses.charAt(charCount))
         {
            result = true;
         }
      }
      
      for(int charCount = 0; charCount < disguisedWord.length(); charCount++)
      {
         if(guess == disguisedWord.charAt(charCount))
         {
            result = true;
         }
      }
      
      return result;
   }


   //**********************************************************************
   //    Name: updateDisguisedWord
   //    Description: This method reveals each instance of the input char
   //        in disguisedWord based off its position in secretWord.
   //    Parameters:  guess, char
   //                 -should be valid(a-z) and not a repeat of previous guess
   //                 -should be a correct guess 
   //                 charCount, integer
   //                 -should be the count of the character in disguisedWord
   //                  that will be replaced by guess 
   //    Post Condition: guess added to disguisedWord
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private string updateDisguisedWord(char guess, int charCount)
   // Begin
   // 	If charCount is equal to the character count of diguisedWord() -  1
   // 		disguisedWord = substring of disguisedWord from (0 to charCount) 
   //          + guess
   // 	Else If charCount is equal to 0
   // 		diguisedWord = guess + substring of disguisedWord starting at 
   //          (charCount + 1)
   // 	Else
   // 		disguisedWord = substring of disguisedWord from (0 to charCount) 
   // 			+ guess + substring of disguisedWord starting at (charCount + 1)
   // 	End If
   // End   
   //**********************************************************************
 	private void updateDisguisedWord(char guess, int charCount)
	{    
		// First and last character of word must be handled differently.
		if(charCount == 0)
      {
      	disguisedWord = guess + disguisedWord.substring(1);
      }
		else if(charCount == disguisedWord.length() - 1)
      {
			disguisedWord = disguisedWord.substring(0, charCount) + guess;
		}
      // guess is appended between two substrings of disguisedWord to handle
      // chars that are in the middle of the word
      else
      {
			disguisedWord = disguisedWord.substring(0, charCount) + guess + 
            disguisedWord.substring(charCount + 1);
		}	
	}
   
   
   //**********************************************************************
   //    Name: addIncorrectGuess
   //    Description: This method acts as a primer method for 
   //        addIncorrectGuesses since that method requires incorrectGueesses 
   //        to have a length of at least one.  
   //    Parameters:  guess, char
   //                 -should be valid(a-z) and not a repeat of previous guess 
   //                 -should be incorrect guess
   //    Post Condition: if incorrectGuess length is 0 then its set to user's 
   //             if its not then guess is passed to updateIncorrectGuesses
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private void addIncorrectGuess(char guess)
   // Begin   
   // 	If incorrectGuesses character count is equal to 0
   // 		incorrectGuesses = guess
   // 	Else
   //       updateIncorrectGuesses(guess)   
   // 	End If
   // End
   //**********************************************************************
	private void addIncorrectGuess(char guess)
	{
		if(incorrectGuesses.length() == 0)
      {
         // guess is concatenated to the empty incorrectGuesses string 
         // allowing for type conversion
			incorrectGuesses += guess;   
      }
		else
      {
         updateIncorrectGuesses(guess);
		}
	}
   
   
   //**********************************************************************
   //    Name: getDisguisedWord
   //    Description: This method determines the appropriate action required
   //       to append a user's guess to incorrectGuesses.  
   //    Parameters: guess, char
   //                -should called from addIncorrectGuess() and no other
   //                 methods
   //    Post Condition: guess added to incorrectGuesses in alphabetical order
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Public string getDisguisedWord()
   // Private void updateIncorrectGuesses(char guess)
   // Begin
   //    Set integer len to the count of characters in incorrectGuesses
   // 	Set integer charCount to 0
   // 	While charCount is less than len
   // 		If guess is less than the character at charCount in incorrectGuesses
   // 		   If charCount is equal to 0
   //             incorrectGuesses = guess + incorrectGuesses
   //          Else
   //             incorrectGuesses = substring incorrectGuesses at 
   //                (0, charCount) + guess + substring of incorrectGuesses
   //                starting at(charCount)
   //          End If
   // 		Else If charCount is equal to len - 1
   // 		   incorrectGuesses = incorrectGuesses + 1
   // 		End If
   // 	End While
   // End
   //**********************************************************************
   private void updateIncorrectGuesses(char guess)
   {
      int len = incorrectGuesses.length();
      
      boolean resultFound = false;
      
      for(int charCount = 0; charCount < len; charCount++)
      {
         // Check each char in incorrectGuesses.  If, when in alphabetical order,
         // guess is before char (at charCount) a then add it before char  
         if(!resultFound && guess < incorrectGuesses.charAt(charCount))
         {
         
            // When the charCount is zero, concatenation is handled differently.
            if(charCount == 0)
            {
               incorrectGuesses = guess + incorrectGuesses;
            }
            else
            {
               incorrectGuesses = incorrectGuesses.substring(0, charCount) + 
                  guess + incorrectGuesses.substring(charCount);
            }
            
            // Once result is found, loop continues, so resultFound
            // is set to true to prevent the addition of extra characters   
            resultFound = true;
         }
         // If guess is greater than all other results then add it to the end
         // of incorrectGuesses
         else if(!resultFound && charCount == len - 1)
         {
            incorrectGuesses = incorrectGuesses + guess;
         }
      }
   }
   
   
   //**********************************************************************
   //    Name: endGame
   //    Description: This method should be called once the game ends, since
   //        its purpose is to display an ending message.  
   //    Precondition: game has ended and user's revealed disguisedWord
   //    Output: disguisedWord
   //        -as string
   //        -to console
   //        -program terminates
   // --------------------------------------------------------------
   // Pseudocode for this method:
   // --------------------------------------------------------------
   // Private void endGame()
   // Begin
   //    Display "Congratulations, you found the secret word: " + disguisedWord
   //    Display ""
   //    Display "Thanks for playing hangman. "
   // End
   //**********************************************************************
	private void endGame()
	{
      System.out.println("Congratulations, you found the the secret word: " + 
         disguisedWord);
      
      System.out.println();
		
      System.out.println("Thanks for playing hangman. ");
	}
}