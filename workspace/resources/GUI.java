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


public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

	Poker game;
   	public GUI(Poker game){
	   this.game= game;
        //Create and set up the window.
       setTitle("Solitaire");
	   int frameWidth = 1080;
	   int frameHeight = 840;
       setSize(frameWidth, frameHeight);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	   setLayout(new GridBagLayout());

	   JPanel communityCards = new JPanel();
	   communityCards.setBackground(Color.yellow);
	   JPanel player1 = new JPanel();
	   player1.setBackground(Color.ORANGE);
	   JPanel buttonsAndDeck = new JPanel();
	   buttonsAndDeck.setBackground(Color.RED);
	   JPanel player2 = new JPanel();
	   player2.setBackground(Color.PINK);

	   GridBagConstraints c = new GridBagConstraints();
	   c.anchor = GridBagConstraints.NORTHWEST;
	   c.fill = GridBagConstraints.BOTH;
	   changeConstraints(c, 0, 0, 3, 1);

	   this.add(communityCards, c);
	   
	   changeConstraints(c, 0, 1, 1, 1);
	   this.add(player1, c);
	   
	   changeConstraints(c, 1, 1, 1, 1);
	   this.add(buttonsAndDeck, c);

	   changeConstraints(c, 2, 1, 1, 1);
	   this.add(player2, c);
	   










	   
       
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

        this.setVisible(true);
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
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
