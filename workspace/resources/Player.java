package resources;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

import resources.Card.Suit;

public class Player {
    private int currentCash;
    private int id;
    private ArrayList<Card> pocket;
    private int hand;


    public Player(int cash, int num)
    {
        currentCash = cash;
        id = num;
    }


    public int getCash () {
        return currentCash;
    }
    public void setCash (int amount) {
        currentCash = amount;
    }


    public ArrayList<Card> getPocket() {
        return pocket;
    }
    public void setPocket(ArrayList<Card> p) {
        pocket = p;
    }
    public String toString()
    {
        return "Player " + id;
    }

    // we need the 
    public double getHand(/*ArrayList<Card> publicCards*/)
    {
        ArrayList<Card> allUseableCards = new ArrayList<Card>();
        allUseableCards.addAll(pocket);
        allUseableCards.addAll(GUI.community);

        ArrayList<Integer> cardValues = new ArrayList<Integer>();
        

        int numOfClubs = 0;
        int numOfSpades = 0;
        int numOfDiamonds = 0;
        int numOfHearts = 0;
        Card currHighestCard = new Card(2, Suit.Clubs);
        for(Card c : allUseableCards)
        {
            cardValues.add(c.value);

;           if (c.suit == Suit.Clubs)
            {
                numOfClubs++;
            } else if (c.suit == Suit.Spades)
            {
                numOfSpades++;
            } else if (c.suit == Suit.Diamonds)
            {
                numOfClubs++;
            } else if (c.suit == Suit.Hearts)
            {
                numOfHearts++;
            }

            if (c.value > currHighestCard.value)
            {
                currHighestCard = c;
            }
        }
        // To calculate best possible hand
        int curHandVal = 0;
        ArrayList<Card> royalFlushDiamond = new ArrayList<Card>();
        royalFlushDiamond.add(new Card(14, Suit.Diamonds));
        royalFlushDiamond.add(new Card(13, Suit.Diamonds));
        royalFlushDiamond.add(new Card(12, Suit.Diamonds));
        royalFlushDiamond.add(new Card(11, Suit.Diamonds));
        royalFlushDiamond.add(new Card(10, Suit.Diamonds));
        ArrayList<Card> royalFlushHeart = new ArrayList<Card>();
        royalFlushHeart.add(new Card(14, Suit.Hearts));
        royalFlushHeart.add(new Card(13, Suit.Hearts));
        royalFlushHeart.add(new Card(12, Suit.Hearts));
        royalFlushHeart.add(new Card(11, Suit.Hearts));
        royalFlushHeart.add(new Card(10, Suit.Hearts));
        ArrayList<Card> royalFlushSpades = new ArrayList<Card>();
        royalFlushSpades.add(new Card(14, Suit.Spades));
        royalFlushSpades.add(new Card(13, Suit.Spades));
        royalFlushSpades.add(new Card(12, Suit.Spades));
        royalFlushSpades.add(new Card(11, Suit.Spades));
        royalFlushSpades.add(new Card(10, Suit.Spades));
        ArrayList<Card> royalFlushClub = new ArrayList<Card>();
        royalFlushClub.add(new Card(14, Suit.Clubs));
        royalFlushClub.add(new Card(13, Suit.Clubs));
        royalFlushClub.add(new Card(12, Suit.Clubs));
        royalFlushClub.add(new Card(11, Suit.Clubs));
        royalFlushClub.add(new Card(10, Suit.Clubs));

        

        if (allUseableCards.containsAll(royalFlushDiamond) || allUseableCards.containsAll(royalFlushHeart) || allUseableCards.containsAll(royalFlushClub) || allUseableCards.containsAll(royalFlushSpades))
        {
            curHandVal = 9;
        } else if (true)
        {
            
        }

        // Calculating the value of the highest card - (will be converted to a decimal to note the highest)
        // Current return format = (hand value).(highest card)
        
        return (double)(curHandVal) + (double)(currHighestCard.value / 100);
    }
}
