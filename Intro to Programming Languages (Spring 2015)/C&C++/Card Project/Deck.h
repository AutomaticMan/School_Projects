/************************************************
programmer: John Gardiner
Header file for Deck class
*************************************************/
#include "Pile.h"
#include <iostream>

using namespace std;
#ifndef Deck_H
#define Deck_H
class Deck : public Pile
{
public:
	Deck();
	Deck(const Deck &old);
	bool addCard(Card c);
	friend ostream& operator << (ostream& out, const Deck& d);
};
#endif