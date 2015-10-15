/**********************************************
programmer: John Gardiner
Header file for Point class
**********************************************/
#include <iostream>
using namespace std;
#ifndef Card_H
#define Card_H

class Card
{
private:
	int rank;
	char suit;
	static bool validSuit(char c);
public:
	Card();		// default constructor
	Card(int rank, char suit);		// parameterizes constructor
	Card(const Card& c);	// copy constructor
	void setCard(int rank, char suit);
	char getSuit();
	int getRank();
	int operator + (const Card& c) const;	// caller obejct is not changed
	bool operator == (const Card& c) const;
	friend ostream& operator << (ostream& out, const Card& p);
	~Card();
};

#endif