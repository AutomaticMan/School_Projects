/************************************************
programmer: John Gardiner
implementation for Deck class
*************************************************/
#include "Deck.h"
#include <iostream>
#include <iomanip>
using namespace std;

const int SIZE = 52, SUIT_SIZE = 4;
static const char SUITS[] = { 'D', 'S', 'C', 'H' };

//default constructor fills the deck with the standard 52 cards
Deck::Deck() : Pile(SIZE)
{
	for (int i = 0; i < SUIT_SIZE; i++)
		for (int j = 0; j < SIZE / SUIT_SIZE; j++)
			Pile::addCard(Card(j + 1, SUITS[i]));
}

//copy constructor
Deck::Deck(const Deck &old) : Pile(old)
{
}

//receives a card, then adds it to the deck only if its not already present
bool Deck::addCard(Card c)
{
	return (isDuplicate(c)) ? false : Pile::addCard(c);
}

ostream& operator << (ostream& out, const Deck& d)
{
	const int WIDTH = 3;
	for (int i = 0; i < d.count; i++)
	{
		out << setw(WIDTH) << d.pile[i];
		if ((i + 1) % 13 == 0)
			out << endl;
	}
	return out;
}