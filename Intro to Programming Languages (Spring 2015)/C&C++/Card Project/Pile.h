/************************************************
programmer: John Gardiner
Header file for Pile class
*************************************************/
#include "Card.h"
#include <iostream>
using namespace std;
#ifndef Pile_H
#define Pile_H
class Pile
{
protected:
	int count;
	int size;
	Card *pile;
	static Card* copyPile(Card *p, int size);
public:
	Pile();
	Pile(int newSize);
	Pile(const Pile &old);
	Card dealCard();
	bool addCard(Card c);
	bool addPile(const Pile &p);
	bool isDuplicate(Card c);
	bool operator ==(const Pile &p) const;
	Card getCard(int location);
	int getCount();
	void shuffle();
	friend ostream& operator << (ostream& out, const Pile& p);
	~Pile();
};
#endif