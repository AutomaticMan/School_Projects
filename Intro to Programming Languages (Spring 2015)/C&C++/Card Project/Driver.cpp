/************************************************
programmer: John Gardiner
Driver
*************************************************/
#include "Deck.h"
#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	Deck d;
	cout << "Unshuffled deck (using overloaded << operator): \n";
	cout << d << endl;

	cout << "Testing dealCard(): \n";
	cout << "Dealt card: " << d.dealCard() << endl;
	cout << d << endl << endl;

	cout << "Testing addCard() with card from deck: \n";
	cout << "Result: " << d.addCard(Card()) << endl;
	cout << d << endl << endl;

	cout << "Testing addCard() with KH: \n";
	cout << "Result: " << d.addCard(Card(13, 'H')) << endl;
	cout << d << endl;

	cout << "Testing addCard() with Full deck: \n";
	cout << "Result: " << d.addCard(Card(13, 'H')) << endl;
	cout << d << endl;

	d.shuffle();
	cout << "Shuffled deck: \n";
	cout << d << endl;
	cout << "Testing getCard() with index 0 and 51: \n";
	cout << d.getCard(0) << "  " << d.getCard(51) << endl;
	cout << "Testing getCard() with index 1 and 52(invalid): \n";
	cout << d.getCard(1) << "  " << d.getCard(52) << endl;

	cout << "Testing copy constructor: \n";
	Pile d1 = d;
	cout << d1 << endl;

	cout << "Testing == operator: \n";
	cout << "deck == deck 2 = " << (d == d1) << endl << endl;

	Pile p;
	Pile p2;

	p.addCard(Card(1, 'H'));
	p.addCard(Card(2, 'H'));
	p.addCard(Card(3, 'H'));
	p2.addCard(Card(1, 'S'));
	p2.addCard(Card(2, 'S'));
	p2.addCard(Card(3, 'S'));

	cout << "Testing addPile(): \n";
	cout << "pile 1 = \n";
	cout << p << endl;
	cout << "pile 2 = \n";
	cout << p2 << endl;
	cout << "pile 1 after addPile(pile 2) = \n";
	p.addPile(p2);
	cout << p << endl << endl;

	cout << "Testing overloaded + operator in Card class: \n";
	Card c;
	cout << "card 1: " << c << endl;
	Card c1(3, 'H');
	cout << "card 2: " << c1 << endl;
	cout << "card 1 + card 2 = " << (c + c1) << endl;

	system("pause");

}