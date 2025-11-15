package resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

import resources.Card.Suit;


/*
 *  SELF-CREATED CLASS - Stores and keeps track of different player data, very necessary for cleaning up code in GUI and Poker
 *  Worked on both by Jamshed and Luca
 */


public class Player {
    private int currentCash;
    private int id;
    private ArrayList<Card> pocket;
    private int hand;

    public Player(int cash, int num) {
        currentCash = cash;
        id = num;
    }

    public int getCash() {
        return currentCash;
    }

    public void setCash(int amount) {
        currentCash = amount;
    }

    public ArrayList<Card> getPocket() {
        return pocket;
    }

    public void setPocket(ArrayList<Card> p) {
        pocket = p;
    }

    public String toString() {
        return "Player " + id;
    }

    // CURRENTLY IN PROGRESS - Goal is to get the value of the players hand, which will be used to calculate the winner. 
    //                         The return format is the ranking (Flush, Straight, etc.) followed by a decimal then the 
    //                         high card values added up (0.14 if nothing and just an Ace).
    public double getHand() {
        ArrayList<Card> allUseableCards = new ArrayList<Card>();
        allUseableCards.addAll(pocket);
        allUseableCards.addAll(GUI.community);

        ArrayList<Integer> cardValues = new ArrayList<Integer>();

        int numOfClubs = 0;
        int numOfSpades = 0;
        int numOfDiamonds = 0;
        int numOfHearts = 0;
        Card currHighestCard = new Card(2, Suit.Clubs);

        for (Card c : allUseableCards) {
            cardValues.add(c.value);

            // Num of each suits count
            if (c.suit == Suit.Clubs) {
                numOfClubs++;
            } else if (c.suit == Suit.Spades) {
                numOfSpades++;
            } else if (c.suit == Suit.Diamonds) {
                numOfDiamonds++;
            } else if (c.suit == Suit.Hearts) {
                numOfHearts++;
            }
            // update the high card as we go
            if (c.value > currHighestCard.value) {
                currHighestCard = c;
            }
        }
        // To calculate best possible hand
        double curHandVal = 0;

        // Sort high to low
        Collections.sort(cardValues, Collections.reverseOrder());
        boolean hasPair = false;
        boolean hasTriple = false;
        boolean hasFour = false;
        int pairValue = 0;
        int tripleValue = 0;
        int fourValue = 0;
        for (int i = 0; i < cardValues.size()-1; i++)
        {
            // Atleast a pair
            if(cardValues.get(i+1) != null && cardValues.get(i).equals(cardValues.get(i + 1)))
            {
                // Possibly a triple?
                if (cardValues.get(i+2) != null && cardValues.get(i).equals(cardValues.get(i + 2)))
                {
                    // Maybe even a four of a kind?
                    if (cardValues.get(i+3) != null && cardValues.get(i).equals(cardValues.get(i + 3)))
                    {
                        fourValue = cardValues.get(i);
                        hasFour = true;
                    } else {
                        tripleValue = cardValues.get(i);
                        hasTriple = true;
                    }
                } else {
                    pairValue = cardValues.get(i);
                    hasPair = true;
                } 
                // Guess theres nothing :(
            }
        } 



        if (hasFour) //4 of a kind
        {
            curHandVal = 7 + ((double) pairValue / 100);
        } else if (hasTriple && hasPair) //full house
        {
            if (tripleValue > pairValue)
            {
                curHandVal = 6 + ((double)tripleValue / 100);
            } else {
                curHandVal = 6 + ((double)pairValue / 100);
            }
        } else if ((numOfClubs >= 5 || numOfSpades >= 5 || numOfHearts >= 5 || numOfDiamonds >= 5)) //flush
        {
            curHandVal = 5;
        }else if (hasTriple) //3 of a kind
        {
            curHandVal = 3 + ((double) pairValue / 100);
        } else if (hasPair) //pair
        {
            curHandVal = 1 + ((double)pairValue/100);
        }



        return (curHandVal) + ((double) currHighestCard.value / 100);
    }
}
