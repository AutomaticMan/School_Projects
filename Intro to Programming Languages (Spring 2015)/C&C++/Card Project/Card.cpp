/************************************************
programmer: John Gardiner
implementation for Card class
*************************************************/
#include "Card.h"
#include <cmath>
#include <iostream>
#include <string>
using namespace std;

static const int SIZE = 4, MAX_SIZE = 13, MIN_SIZE = 1, MAX_RANK = 10;
static const char SUITS[] = { 'D', 'S', 'C', 'H' };
static const string RANKS[] =
	{ "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

// default constructor
Card::Card()
{
	setCard(1, 'A');
}

// parameterized constructor
Card::Card(int rank, char suit)
{
	setCard(rank, suit);
}

// copy constructor
Card::Card(const Card& c)
{
	rank = c.rank;			// member-wise copy -- avoid with Carders
	suit = c.suit;
}

// change the coordinates of a Card
void Card::setCard(int rank, char suit)
{
	if (rank < MIN_SIZE || rank > MAX_SIZE)
		rank = 1;
	if (!validSuit(suit))
		suit = 'S';

	this->rank = rank;
	this->suit = suit;
}

// return rank to other classes besides this one
int Card::getRank()
{
	return rank;
}

// return suit to other classes besides this one
char Card::getSuit()
{
	return suit;
}

// overload + operator to add to Cards
int Card::operator + (const Card& c) const
{
	return (rank + c.rank < MAX_RANK) ? rank + c.rank : MAX_RANK;
}

// overload + operator to add an int to both x and y
bool Card::operator == (const Card& c) const
{
	return rank == c.rank && suit == c.suit;
}

// overload << operator for output
ostream& operator << (ostream& out, const Card& c)
{
	return out << RANKS[c.rank - 1] << c.suit;
}

//returns true if the received suit is valid
bool Card::validSuit(char c)
{
	bool result = false;
	for (int i = 0; i < SIZE; i++)
		result = result || c == SUITS[i];
	return result;
}

// default destructor
Card::~Card()
{
}