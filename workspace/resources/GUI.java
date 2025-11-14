package resources;
import javax.imageio.ImageIO;
import javax.swing.*;

//import resources.Poker.gameStates;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Stack;


public class GUI extends JFrame implements ActionListener {

	Poker game;
	public static ArrayList<Card> community = new ArrayList<Card>();

	// List of things
	JPanel gameArea;
	JPanel communityCards;
	JLayeredPane communityPane;
	JPanel player1;
	JPanel buttonsAndDeck;
	JPanel buttons;
	JButton callCheck;
	JButton raise;
	JButton fold;
	JPanel drawPile;
	JLayeredPane drawingCards;
	JPanel discard;
	JLayeredPane discardPane;
	JPanel player2;


	int frameWidth = 1080;
	int frameHeight = 840;
	//frameWidth, frameHeight/2)
	int communityPanelSizeX = frameWidth;
	int communityPanelSizeY = frameHeight / 2;

	Stack<Card> deck = new Stack<Card>();
	
	enum action
	{
		ADD,
		REMOVE
	}

	public GUI(Poker game){
		this.game = game;
		//deck = game.getPile();
		setTitle("Texas Holdem");
		
		setSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		gameArea = new JPanel();
        gameArea.setLayout(new GridBagLayout());

        communityCards = new JPanel();
        communityCards.setSize(new Dimension(frameWidth, frameHeight/2));
        communityCards.setPreferredSize(new Dimension(frameWidth, frameHeight/2));
        communityCards.setBackground(Color.yellow);
		communityCards.setLayout(new FlowLayout());

        player1 = new JPanel();
        player1.setSize(new Dimension(frameWidth/3, frameHeight/2));
        player1.setPreferredSize(new Dimension(frameWidth/3, frameHeight/2));
        player1.setBackground(Color.ORANGE);
        


        // -------------------------------------------------------------- \
        // SPECIAL CASE - CURRENTLY NOT FINISHED
        buttonsAndDeck = new JPanel();
        buttonsAndDeck.setSize(new Dimension(frameWidth/3, frameHeight/2));
        buttonsAndDeck.setPreferredSize(new Dimension(frameWidth/3, frameHeight/2));
        //buttonsAndDeck.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        buttonsAndDeck.setLayout(new GridBagLayout());
        
		int buttonSize = 6;
        // INSIDE BUTTONSANDDECK
        buttons = new JPanel();
        buttons.setBackground(Color.BLUE);
        buttons.setSize(new Dimension(frameWidth/3, frameHeight/buttonSize));
        buttons.setPreferredSize(new Dimension(frameWidth/3, frameHeight/buttonSize));
        buttons.setMinimumSize(new Dimension(frameWidth/3, frameHeight/buttonSize));
		buttons.setLayout(new GridBagLayout());

		//		BUTTONS 	 \\
			callCheck = new JButton("Call / Check");
			callCheck.setSize(new Dimension(frameWidth/9, frameHeight/buttonSize));
			callCheck.setPreferredSize(new Dimension(frameWidth/9, frameHeight/buttonSize));
			raise = new JButton("Raise");
			raise.setSize(new Dimension(frameWidth/9, frameHeight/buttonSize));
			raise.setPreferredSize(new Dimension(frameWidth/9, frameHeight/buttonSize));
			fold = new JButton("Fold");
			fold.setSize(new Dimension(frameWidth/9, frameHeight/buttonSize));
			fold.setPreferredSize(new Dimension(frameWidth/9, frameHeight/buttonSize));

			callCheck.setEnabled(true);
			fold.setEnabled(true);
			raise.setEnabled(true);

        // buttons.setLayout();
        drawPile = new JPanel();
        drawPile.setBackground(Color.MAGENTA);
        drawPile.setSize(new Dimension(frameWidth/6, frameHeight/3));
        drawPile.setPreferredSize(new Dimension(frameWidth/6, frameHeight/3));
        drawPile.setMinimumSize(new Dimension(frameWidth/6, frameHeight/3));
		drawPile.setLayout(new GridBagLayout());
		drawingCards = new JLayeredPane();
		drawingCards.setBackground(Color.GRAY);
		drawingCards.setOpaque(true);
        drawingCards.setSize(new Dimension(frameWidth/6, frameHeight/3));
        drawingCards.setPreferredSize(new Dimension(frameWidth/6, frameHeight/3));
        drawingCards.setMinimumSize(new Dimension(frameWidth/6, frameHeight/3));

        discard = new JPanel();
        discard.setBackground(Color.GREEN);
        discard.setSize(new Dimension(frameWidth/6, frameHeight/4));
        discard.setPreferredSize(new Dimension(frameWidth/6, frameHeight/4));
        discard.setMinimumSize(new Dimension(frameWidth/6, frameHeight/4));
		discard.setLayout(null);

		
        // -------------------------------------------------------------- \



        player2 = new JPanel();
        player2.setSize(new Dimension(frameWidth/3, frameHeight/2));
        player2.setPreferredSize(new Dimension(frameWidth/3, frameHeight/2));
        player2.setBackground(Color.PINK);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;

        changeConstraints(c, 0, 0, 3, 1);
        gameArea.add(communityCards, c);

        changeConstraints(c, 0, 1, 1, 1);
        gameArea.add(player1, c);

        changeConstraints(c, 1, 1, 1, 1);
        gameArea.add(buttonsAndDeck, c);

        changeConstraints(c, 2, 1, 1, 1);
        gameArea.add(player2, c);


        
        //
        GridBagConstraints tempC = new GridBagConstraints();
        tempC.anchor = GridBagConstraints.PAGE_START;
        tempC.fill = GridBagConstraints.BOTH;

       // tempC.insets = new Insets(5, 10, 5, 10);
        changeConstraints(tempC, 0, 0, 2, 1);
        buttonsAndDeck.add(buttons, tempC);
        changeConstraints(tempC, 0, 1, 1, 1);
        buttonsAndDeck.add(drawPile, tempC);
        changeConstraints(tempC, 1, 1, 1, 1);
        buttonsAndDeck.add(discard, tempC);

		// Adding the layered pane
		drawPile.add(drawingCards);
		

		// Adding the buttons!
		GridBagConstraints buttonC = new GridBagConstraints();
		buttonC.fill = GridBagConstraints.BOTH;
		buttonC.fill = GridBagConstraints.PAGE_START;

		changeConstraints(buttonC, 0, 0, 1, 1);
		buttons.add(callCheck, buttonC);
		changeConstraints(buttonC, 1, 0, 1, 1);
		buttons.add(raise, buttonC);
		changeConstraints(buttonC, 2, 0, 1, 1);
		buttons.add(fold, buttonC);

		// BUTTON INTERACTIONS
		callCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				//Call or not
				if (community.size() == 4) {
					callCheck.setEnabled(false);
					fold.setEnabled(false);
					raise.setEnabled(false);
				}
				if(community.size() < 5)
				{
					if(game.raise > 0) {
						System.out.println("Call was pressed");
						game.call();
					} else {
						System.out.println("Check was pressed");
					}
					
					// For flop or not  
					if (community.isEmpty())
					{
						drawDisc();
						drawDisc();
					} 

					drawDisc();
					game.endTurn();
				}
			}
		});

		raise.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Raise was pressed");
				game.raisePot(10);
				game.endTurn();
			}
		});

		fold.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Fold was pressed");
			}
		});

		this.add(gameArea);
		this.setVisible(true);
    }

	private void update(JPanel panel, action type, Card element)
	{
		if (type == action.ADD)
		{
			panel.add(element);
		} else if (type == action.REMOVE)
		{
			panel.remove(element);
		}
		this.revalidate();
		this.repaint();
		
	}

	private void drawDisc()
	{
		//one discard one community
		Card c = game.drawCard();
		c.hide();
		update(discard, action.ADD, c);

		c = game.drawCard();
		community.add(c);
		update(communityCards, action.ADD, c);
	}


	
	private void changeConstraints(GridBagConstraints c, int x, int y, int width, int height)
	{
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		c.gridheight = height;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("It can hear u No It cant");
	}
}

	