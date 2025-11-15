package resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

import resources.Card.Suit;

// 

/*
 * This game logic changes every time a button is pressed
 * made by Luca. sorry if the code doesnt make sense.
 */

public class Poker {
	private Stack<Card> pile = new Stack<Card>();
	private ArrayList<Card> pulledCards = new ArrayList<Card>();

	public Stack<Card> community = new Stack<Card>();
	// ArrayList<Stack <Card>> columns;
	// Queue<Card> deck;

	// the part of your program that's in charge of game rules goes here.

	public int pot;
	public Player currentPlayer;
	public int raise;
	public Player player1 = new Player(100, 1);
	public Player player2 = new Player(100, 2);

	/*
	 * enum gameStates {
	 * PREFLOP,
	 * GAME,
	 * END
	 * }
	 */

	// public gameStates stage;

	//set the pockets and shuffle the pile
	public void beginGame() {
		pot = 0;
		currentPlayer = player1;
		raise = 0;

		pile.clear();
		for (int i = 2; i <= 14; i++) {
			pile.push(new Card(i, Suit.Spades));
		}
		for (int i = 2; i <= 14; i++) {
			pile.push(new Card(i, Suit.Hearts));
		}
		for (int i = 2; i <= 14; i++) {
			pile.push(new Card(i, Suit.Diamonds));
		}
		for (int i = 2; i <= 14; i++) {
			pile.push(new Card(i, Suit.Clubs));
		}

		Collections.shuffle(pile);
		//System.out.println(pile);

		// sets the players pockets
		for (int i = 0; i < 2; i++) {
			drawCard();
		}
		player1.setPocket(new ArrayList<>(pulledCards));
		pulledCards.clear();

		for (int i = 0; i < 2; i++) {
			drawCard();
		}
		player2.setPocket(new ArrayList<>(pulledCards));

		pulledCards.clear();

		System.out.println("Pocket1: " + player1.getPocket());
		System.out.println("Pocket1: " + player2.getPocket());
	}

	//Returns the top card and removes it from the pile
	public Card drawCard() {
		System.out.println("Pile has " + pile.size() + " cards");
		pulledCards.add(pile.peek());
		return pile.pop();
	}

	//takes the inputted amount from the player to the pot. currently default is 10
	public void raisePot(int amount) {
		call();
		raise = amount;
		pot += raise;

		currentPlayer.setCash(currentPlayer.getCash() - raise);
	}

	public void fold() {
		raise = 0;
		endTurn();
	}

	//takes the players cash by the raise into the pot
	public void call() {
		// If the raise is MORE than what you have then you will just give whatever you
		// have left
		if (currentPlayer.getCash() < raise) {
			pot += currentPlayer.getCash();
			currentPlayer.setCash(0);
		} else {
			pot += raise;
			currentPlayer.setCash(currentPlayer.getCash() - raise);
		}
		raise = 0;
	}

	//should run everytime someone presses a button. its for switching between each player and checking who won at the end
	public void endTurn() {
		if (currentPlayer == player1) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}

		System.out.println(currentPlayer.toString() + " turn ---- POT: " + pot + " ---- RAISE: " + raise
				+ " ---- CASH: " + currentPlayer.getCash());

		if (GUI.community.size() == 5) {
			if (player1.getHand() > player2.getHand()) {
				System.out.println("Player 1 wins with a value of " + player1.getHand());
				return;
			}

			if (player2.getHand() > player1.getHand()) {
				System.out.println("Player 2 wins with a value of " + player2.getHand());
				return;
			}
			System.out.println("It's a tie with values of " + player1.getHand() + " and " + player2.getHand());
		}
	}

	public Stack getPile() {
		return pile;
	}
}
