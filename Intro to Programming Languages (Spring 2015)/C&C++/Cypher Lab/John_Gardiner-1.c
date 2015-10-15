#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/**************************************************************************************************
***************************************************************************************************
* Programmer: John Gardiner
* Assignment: C Lab 5- Functions
* Date: April 13 2015
***************************************************************************************************
* Write a program to ecrypt user messages that implements the follow algorithm:
*             Keyword Decipher Algorithm
* 1. Select a word to use as the key
* 2. Remove duplicate letters from the selected keyword
* 3. Convert the selected keyword to uppercase letters
* 4. In the first row, write the alphabet in standard order from A to Z.
* 5. In the second row, directly below the alphabet, write the selected keyword from step 3.
* 6. After finishing with the keyword in step 5, continue by writing the standard alphabet
*    excluding the letters that have already been used in the selected keyword from step 3.
*    The first row is the plaintext alphabet and the second row is the encrypted alphabet.
* 7. Use the encrypted alphabet to encrypt text messages
*
***************************************************************************************************
* (4/10/2014)- Found and fixed bug that resulted in an error when processing empty strings.
*			   Removed error checking from main().
* (4/8/2014)-  Added error checking to verify inputs are not empty strings.  Processing empty 
*              strings can currupt the stack.
* 
***************************************************************************************************
**************************************************************************************************/

//Program Constants//
#define STRING_SIZE 27
#define MESSAGE_SIZE 100

//Function Prototypes//
void getInput(char *string, char *message);
void makeCipher(char *string);
void fillCipherArray(struct Encrypt *cipher, char *string);
void encryptMessage(struct Encrypt *cipher, char *string, char *output);
char trim(char *string);
int stringFormat(char *string);
int notRepeat(char *string, char thisChar);
int isValid(char thisChar);
void makeUpper(char *string);

struct Encrypt { 
	char alpha;      
	char encrypt; 
};

/**************************************************************************************************
int main()- Calls other functions to get input from user and perform operations on this function's
		character arrays
**************************************************************************************************/
int main()
{
	struct Encrypt cipher[STRING_SIZE - 1];
	char string[STRING_SIZE];
	char message[MESSAGE_SIZE];
	char encryptedMessage[MESSAGE_SIZE];

	getInput(string, message);
	makeCipher(string);
	fillCipherArray(cipher, string);
	encryptMessage(cipher, message, encryptedMessage);
	printf_s("The encrypted message is: %s\n", encryptedMessage);
	
	//Pause system to allow user to review output
	system("pause");
}

/**************************************************************************************************
void getInput(char *string, char *message)- Receives strings, the prompts the user for input.  User
input in stored into the received character arrays.
**************************************************************************************************/
void getInput(char *string, char *message)
{
	printf_s("Enter a string (%d characters max & letters only) >> ", STRING_SIZE - 1);
	fgets(string, STRING_SIZE, stdin);
	
	printf_s("Enter a message (%d characters max) >> ", MESSAGE_SIZE - 1);
	fgets(message, MESSAGE_SIZE, stdin);
}

/**************************************************************************************************
void makeCipher(char *string)- Make cipher receives a string and uses that string to create the 
		cipher alphabet needed to encrypt messages.
**************************************************************************************************/
void makeCipher(char *string)
{
	char i;
	int index;
	
	makeUpper(string); //Make uppercase as stated in algorithm
	stringFormat(string); //Remove duplicate characters as stated in algorithm
	index = strlen(string);
	//Fill the remaining character spaces with the remaining unused characters from the alphabet
	for (i = 'A'; i <= 'Z'; i++)
		if (notRepeat(string, i))
			string[index++] = i;
	string[index] = '\0'; //End string
}

/**************************************************************************************************
void fillCipherArray(struct Encrypt *cipher, char *string)- Recevies an array of Encrypt structs,
		then fills it with the standard English aphlabet and each corresponding character from the 
		encrypted alphabet it receives as a parameter.
**************************************************************************************************/
void fillCipherArray(struct Encrypt *cipher, char *string)
{
	char startChar = 'A';
	int i = 0;

	for (i = 0; i < STRING_SIZE-1; i++)
		cipher[i].alpha = startChar + i, cipher[i].encrypt = string[i];
}

/**************************************************************************************************
void encryptMessage(struct Encrypt *cipher, char *string, char *output)- Receives three arrays.  
		One of Encrypts structs containing an alphabet, one containing a string to be encrypted, 
		and the last to store output. 
**************************************************************************************************/
void encryptMessage(struct Encrypt *cipher, char *string, char *output)
{
	int i;

	makeUpper(string);
	for (i = 0; i < strlen(string); i++)
		//Invalid chars(those that can't be made uppercase) are ignored
		output[i] = (isValid(string[i])) ? cipher[string[i] - 'A'].encrypt : string[i];
	output[i] = '\0';
}

/**************************************************************************************************
int stringFormat(char *string)- Receives a string, and removes all invalid and dupilicate
		characters.  Returns the index of the next availible index in the character array.
**************************************************************************************************/
int stringFormat(char *string)
{
	char thisChar;
	int index;

	if (strlen(string) > 1) {
		thisChar = trim(string); //Remove last char from the string
		index = stringFormat(string); //Perform operations on the remainer of the string
		if (notRepeat(string, thisChar) && isValid(thisChar))
			string[index++] = thisChar;
		return index;
	} else if (!isValid(*string)) {
		*string = '\0';
		return 0;
	} else
		return 1;

}

/**************************************************************************************************
char trim(char *string)- Receives a string, then deletes the last character from that string. The
		removed character is returned to the calling function.
**************************************************************************************************/
char trim(char *string)
{
	char *ptr = string + sizeof(char) * (strlen(string) - 1);
	char thisChar = *ptr;
	*ptr = '\0';

	return thisChar;
}

/**************************************************************************************************
void makeUpper(char *string)- Receives a string, then makes each lowercase character in that string
		uppercase.
**************************************************************************************************/
void makeUpper(char *string)
{
	if (strlen(string) > 1) 
		makeUpper(string + sizeof(char)); 
	*string = (*string >= 'a' && *string <= 'z') ? *string + ('A' - 'a') : *string;
}

/**************************************************************************************************
int isValid(char thisChar)-  Returns 1 if the character received is a valid uppercase letter. 
		Otherwise, 0 is returned.
**************************************************************************************************/
int isValid(char thisChar)
{
	return (thisChar >= 'A' && thisChar <= 'Z') ? 1 : 0;
}

/**************************************************************************************************
int notRepeat(char *string, char thisChar)- Returns 1 if the received character is in the received
		string.  Otherwise, 0 is returned.
**************************************************************************************************/
int notRepeat(char *string, char thisChar)
{
	if (*string == '\0') 
		return 1;
	else if (*string == thisChar) 
		return 0;

	return notRepeat(string + sizeof(char), thisChar);
}  