package resources;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

import resources.Card.Suit;

public class Player {
    private int currentCash;
    private ArrayList<Card> pocket;


    public Player(int cash)
    {
        currentCash = cash;
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

}
