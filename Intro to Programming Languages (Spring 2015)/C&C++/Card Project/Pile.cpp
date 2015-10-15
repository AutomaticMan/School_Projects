/************************************************
programmer: John Gardiner
implementation for Pile class
*************************************************/
#include "Pile.h"
#include "Card.h"
#include <iostream>
#include <iomanip>
#include <string>
#include <time.h>
using namespace std;

//default constructor
Pile::Pile()
{
	count = 0;
	size = 10;
	pile = new Card[size];
}

//parameterized constructor
Pile::Pile(int newSize)
{
	count = 0;
	size = newSize;
	pile = new Card[size];
}

//copy constructor
Pile::Pile(const Pile &old)
{
	count = old.count;
	size = old.size;
	pile = copyPile(old.pile, size);
}

//receives valid index, then returns a copy of card at that index in pile
Card Pile::getCard(int location)
{
	if (location >= 0 && location < count)
		for (int i = 0; i < count; i++)
			if (i == location)
				return Card(pile[i]);
			return Card();
}

//returns count
int Pile::getCount()
{
	return count;
}

//returns card from top of pile, then removes that card from pile
Card Pile::dealCard()
{
	if (count == 0)
		return Card();
	return pile[--count];
}

//add card to pile if room is left in array
bool Pile::addCard(Card c)
{
	if (count == size)
		return false;
	pile[count++] = Card(c);
	return true;
}

//receives another pile, then merges it with this one if the space is available
bool Pile::addPile(const Pile &p)
{
	if (count + p.count > size)
		return false;
	for (int i = 0; i < p.count; i++)
		addCard(p.pile[i]);
	return true;
}

//returns true if the received card is already in pile
bool Pile::isDuplicate(Card c)
{
	for (int i = 0; i < count; i++)
		if (pile[i] == c)
			return true;
	return false;
}

//shuffles pile using the same basic method a human would use to shuffle a deck of cards.
void Pile::shuffle()
{
	const int SHUFFLE_TIMES = 25;
	srand(time(NULL));
	for (int i = 0; i < SHUFFLE_TIMES; i++)
	{
		int cut = rand() % count / 2 + 1;
		Card temp;
		//cut the pile
		for (int j = 0; j < cut; j++)
		{
			temp = pile[j];
			pile[j] = pile[count - cut + j];
			pile[count - cut  + j] = temp;
		}
		//shuffle the pile
		Card *a = copyPile(pile, count);
		int index = 0;
		for (int j = 0; j < count - 1; j = j + 2)
		{
			Card *temp = &pile[j], *temp2 = &pile[j + 1];
			pile[j] = a[index];
			pile[j + 1] = a[count / 2 + index++];
		}
		delete[] a;
	}
}

//receives an array and returns a copy of that array
Card* Pile::copyPile(Card* p, int size)
{
	Card *a = new Card[size];
	for (int j = 0; j < size; j++)
		a[j] = Card(p[j]);
	return a;
}

//overloads the == operator to compare two piles
bool Pile::operator ==(const Pile &p) const
{
	if (count != p.count)
		return false;
	for (int i = 0; i < count; i++)
		if (!(pile[i] == p.pile[i]))
			return false;
	return true;
}

//overloads the << operator to concatinate a pile of cards to ostream
ostream& operator << (ostream& out, const Pile& p)
{
	const int WIDTH = 3;
	for (int i = 0; i < p.count; i++)
	{
		out << setw(WIDTH) << p.pile[i];
		if ((i + 1) % 13 == 0)
			out << endl;
	}
	return out;
}

//delete pile array from stack
Pile::~Pile()
{
	delete[] pile;
}