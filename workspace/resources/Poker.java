package resources;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

import resources.Card.Suit;

// 

/*
 * 52 cards, 13 of each suit
 * 4 of each number and face, 13 different numbers (11 for jack, 12 for queen, 13 for king)
 * ex. there are 4 kings for each suit, 4x13 is 52, 52 total cards
 */

public class Poker {
	private Stack<Card> pile = new Stack<Card>();
	private ArrayList<Card> pulledCards = new ArrayList<Card>();

	public Stack<Card> community = new Stack<Card>();
	//ArrayList<Stack <Card>> columns;
	//Queue<Card> deck;
	
	//the part of your program that's in charge of game rules goes here.

	public int pot;
	public Player currentPlayer;
	public int raise;	
	public Player player1 = new Player(100,1); 
	public Player player2 = new Player(100,2);

	enum gameStates {
		PREFLOP,
		GAME,
		END
	}

	public gameStates stage;

	public void beginGame() {
		pot = 0;
		currentPlayer = player1;
		raise = 0;

		stage = gameStates.PREFLOP;

		pile.clear();
		for(int i = 1; i<=13; i++) { pile.push(new Card(i, Suit.Spades)); }
		for(int i = 1; i<=13; i++) { pile.push(new Card(i, Suit.Hearts)); }
		for(int i = 1; i<=13; i++) { pile.push(new Card(i, Suit.Diamonds)); }
		for(int i = 1; i<=13; i++) { pile.push(new Card(i, Suit.Clubs)); }

		Collections.shuffle(pile);
		System.out.println(pile);


		//sets the players pockets
		for(int i=0; i<2; i++) {
			drawCard();
		}
		player1.setPocket(pulledCards);
		pulledCards.clear();

		for(int i=0; i<2; i++) {
			drawCard();
		}
		player2.setPocket(pulledCards);

		pulledCards.clear();
	}
	

	public Card drawCard()
	{	
		System.out.println("Pile has "+pile.size()+" cards");
		pulledCards.add(pile.peek());
		return pile.pop();
	} 

	public  void raisePot(int amount) {
		call();
		raise = amount;
		pot += raise;
		
		currentPlayer.setCash(currentPlayer.getCash() - raise);
	}

	

	public void fold() {
		raise = 0;
		stage = gameStates.END;
		endTurn();
	}

	public void call() {
		//If the raise is MORE than what you have then you will just give whatever you have left
		if(currentPlayer.getCash() < raise) {
			pot += currentPlayer.getCash();
			currentPlayer.setCash(0);
		} else {
			pot += raise;
			currentPlayer.setCash( currentPlayer.getCash() - raise);
		}
		raise = 0;
	}


	public void endTurn() {
		switchTurn();
		System.out.println(currentPlayer.toString() + " turn ---- POT: " + pot + " ---- RAISE: " + raise + " ---- CASH: " + currentPlayer.getCash());
	}

	public void switchTurn() {
		if(currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
	}

	public Stack getPile() {
		return pile;
	}
}
