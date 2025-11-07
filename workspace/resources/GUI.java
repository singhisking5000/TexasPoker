package resources;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class GUI extends JFrame implements ActionListener, MouseListener{

	Poker game;
	public GUI(Poker game){
		this.game = game;
		setTitle("Texas Holdem");
		int frameWidth = 1080;
		int frameHeight = 840;
		setSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		JPanel gameArea = new JPanel();
        gameArea.setLayout(new GridBagLayout());

        JPanel communityCards = new JPanel();
        communityCards.setSize(new Dimension(frameWidth, frameHeight/2));
        communityCards.setPreferredSize(new Dimension(frameWidth, frameHeight/2));
        communityCards.setBackground(Color.yellow);

        JPanel player1 = new JPanel();
        player1.setSize(new Dimension(frameWidth/3, frameHeight/2));
        player1.setPreferredSize(new Dimension(frameWidth/3, frameHeight/2));
        player1.setBackground(Color.ORANGE);
        


        // -------------------------------------------------------------- \
        // SPECIAL CASE - CURRENTLY NOT FINISHED
        JPanel buttonsAndDeck = new JPanel();
        buttonsAndDeck.setSize(new Dimension(frameWidth/3, frameHeight/2));
        buttonsAndDeck.setPreferredSize(new Dimension(frameWidth/3, frameHeight/2));
        //buttonsAndDeck.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        buttonsAndDeck.setLayout(new GridBagLayout());
        
        // INSIDE BUTTONSANDDECK
        JPanel buttons = new JPanel();
        buttons.setBackground(Color.BLUE);
        buttons.setSize(new Dimension(frameWidth/3, frameHeight/4));
        buttons.setPreferredSize(new Dimension(frameWidth/3, frameHeight/4));
        buttons.setMinimumSize(new Dimension(frameWidth/3, frameHeight/4));
		buttons.setLayout(new GridBagLayout());

		//		BUTTONS 	 \\
			JButton callCheck = new JButton("Call / Check");
			callCheck.setSize(new Dimension(frameWidth/9, frameHeight/4));
			callCheck.setPreferredSize(new Dimension(frameWidth/9, frameHeight/4));
			JButton raise = new JButton("Raise");
			raise.setSize(new Dimension(frameWidth/9, frameHeight/4));
			raise.setPreferredSize(new Dimension(frameWidth/9, frameHeight/4));
			JButton fold = new JButton("Fold");
			raise.setSize(new Dimension(frameWidth/9, frameHeight/4));
			raise.setPreferredSize(new Dimension(frameWidth/9, frameHeight/4));

        // buttons.setLayout();
        JPanel drawPile = new JPanel();
        drawPile.setBackground(Color.MAGENTA);
        drawPile.setSize(new Dimension(frameWidth/6, frameHeight/4));
        drawPile.setPreferredSize(new Dimension(frameWidth/6, frameHeight/4));
        drawPile.setMinimumSize(new Dimension(frameWidth/6, frameHeight/4));

        JPanel discard = new JPanel();
        discard.setBackground(Color.GREEN);
        discard.setSize(new Dimension(frameWidth/6, frameHeight/4));
        discard.setPreferredSize(new Dimension(frameWidth/6, frameHeight/4));
        discard.setMinimumSize(new Dimension(frameWidth/6, frameHeight/4));
        // -------------------------------------------------------------- \



        JPanel player2 = new JPanel();
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

		// Adding the buttons!
		GridBagConstraints buttonC = new GridBagConstraints();
		buttonC.fill = GridBagConstraints.BOTH;
		buttonC.fill = GridBagConstraints.PAGE_START;

		changeConstraints(buttonC, 0, 0, 1, 1);
		buttons.add(callCheck);
		changeConstraints(buttonC, 1, 0, 1, 1);
		buttons.add(raise);
		changeConstraints(buttonC, 2, 0, 1, 1);
		buttons.add(fold);

		this.add(gameArea);
		this.setVisible(true);

		
		//    // this supplies the background
		//    try {
		// 	System.out.println(getClass().toString());
		// 	Image blackImg = ImageIO.read(getClass().getResource("background.jpg"));
		// 	setContentPane(new ImagePanel(blackImg));

		//    }catch(IOException e) {
		// 	   e.printStackTrace();
		//    }

		//    /*******
		//     * This is just a test to make sure images are being read correctly on your machine. Please replace
		//     * once you have confirmed that the card shows up properly. The code below should allow you to play the solitare
		//     * game once it's fully created.
		//     */
		//    Card card = new Card(2, Card.Suit.Diamonds);
		//    System.out.println(card);
		//    this.add(card);    


    }
	// private void update() {
	// 			columns.removeAll();
	// 			topColumns.removeAll();
			
	// 			ArrayList<Stack<Card>> allColumns = game.getColumns();

	// 			for(Stack<Card> stack: allColumns) {
	// 			topColumns.add(drawPile(stack, false)); 
	// 			}

	// 			columns.add(drawDeck(game.getDeck()));
	// 			columns.add(drawPile(game.getPile(), true));
	// 			columns.add(drawFinal(game.hearts, "hearts"));
	// 			columns.add(drawFinal(game.spades, "spades"));
	// 			columns.add(drawFinal(game.diamonds, "diamonds"));
	// 			columns.add(drawFinal(game.clubs, "clubs"));
	// 			System.out.println("updating");
	// 				this.revalidate();
	// 				this.repaint();
	// 		}
	private void changeConstraints(GridBagConstraints c, int x, int y, int width, int height)
	{
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = width;
		c.gridheight = height;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
