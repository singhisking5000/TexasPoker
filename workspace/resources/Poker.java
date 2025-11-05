package resources;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

import resources.Card.Suit;

/*
 * 52 cards, 13 of each suit
 * 4 of each number and face, 13 different numbers (11 for jack, 12 for queen, 13 for king)
 * ex. there are 4 kings for each suit, 4x13 is 52, 52 total cards
 */

public class Poker {
	Stack<Card> pile = new Stack<Card>();
	//ArrayList<Stack <Card>> columns;
	//Queue<Card> deck;
	
	//the part of your program that's in charge of game rules goes here.

	public int pot = 0;
	public int playerTurn = 0;


	private int player1Cash = 0;
	private int player2Cash = 0;

	

	public void beginGame() {
		pot = 0;
		playerTurn = 1;
		player1Cash = 500;
		player2Cash = 500;


		pile.clear();
		for(int i = 1; i<=13; i++) { pile.push(new Card(i, Suit.Spades)); }
		for(int i = 1; i<=13; i++) { pile.push(new Card(i, Suit.Hearts)); }
		for(int i = 1; i<=13; i++) { pile.push(new Card(i, Suit.Diamonds)); }
		for(int i = 1; i<=13; i++) { pile.push(new Card(i, Suit.Clubs)); }

		Collections.shuffle(pile);
		System.out.println(pile);
	}
	

	public int getPlayer1Cash() {
		return player1Cash;
	}

	public int getPlayer2Cash() {
		return player2Cash;
	}

	public void revealNext()
	{
		// Reveals next community card, no need to code logic for first three, that will be later
	}

	public  void raise(int amount) {
		pot += amount;
	}

	public void fold() {

	}

	public void callCheck() {
		
	}

	public void endTurn() {
		if(playerTurn == 1) {
			playerTurn = 2;
		} else {
			playerTurn = 1;
		}
	}
}
