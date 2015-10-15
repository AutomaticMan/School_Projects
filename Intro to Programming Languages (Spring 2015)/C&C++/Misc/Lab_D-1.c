#include <stdio.h>
#include <string.h>
/**************************************************************************************************
* Student: John Gardiner
* Date: April 22, 2015
* Assignment: Lab D
**************************************************************************************************/

/**************************************************************************************************
* Part 1- Structures
**************************************************************************************************/
struct customer
{
	char lastName[15];
	char firstName[15];
	unsigned int customerNumber;
};

void structDemo()
{
	struct customer customerRecord;
	struct customer* customerPtr;
	struct customer other;

	customerPtr = &customerRecord;
	
	// A)
	strcpy_s(customerRecord.lastName, 7, "Flacco");

	// B)
	strcpy_s(customerPtr->firstName, 4, "Joe");

	// C)
	customerRecord.customerNumber = 5;

	// D)
	printf_s("Name: %s, %s \tCustomer Number: %d \n", customerRecord.lastName,
		customerRecord.firstName, customerRecord.customerNumber);

	// E)
	other = customerRecord;

	// F)
	printf_s("Name: %s, %s \tCustomer Number: %d \n", other.lastName, other.firstName, 
		other.customerNumber);

	// G)
	int lastNameCmp = strcmp(customerRecord.lastName, other.lastName);
	int firstNameCmp = strcmp(customerRecord.firstName, other.firstName);

	if (lastNameCmp == 0 && firstNameCmp == 0 && customerPtr->customerNumber == other.customerNumber)
		printf_s("other has the same data as customerNumber.\n\n");
}

/**************************************************************************************************
* Part 2- Unions
**************************************************************************************************/
#define SIZE 10

union list
{
	char cList[SIZE];
	int iList[SIZE];
};

void unionDemo()
{
	union list myList;
	int i, index = 0;
	for (i = 0; i < SIZE; i++)
	{
		myList.iList[i] = i + 65;
		printf_s("%c\n", myList.cList[i]);
	}
}

/**************************************************************************************************
* Part 3- Bits
**************************************************************************************************/
int power2(int number, int power)
{
	unsigned int power2 = 1 << power;
	return number * power2;
}

/**************************************************************************************************
* Part 4- Enumeration
**************************************************************************************************/
enum days {SUN=0, MONS, TUES, WED, THURS, FRI, SAT};

const char* dayName[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday", 
	"Sunday"};

void enumDemo()
{
	enum days result;
	int startDay, day;

	printf_s("Enter the day the month starts on (0-6, Sunday=0, Monday=1, etc): ");
	scanf_s("%d", &startDay);

	printf_s("Enter a day (1-31): ");
	scanf_s("%d", &day);

	result = (startDay + day - 1) % 7;

	printf_s("This day lands on a %s.\n", dayName[result]);

}

int main()
{
	structDemo();
	unionDemo();
	enumDemo();
	system("pause");
}