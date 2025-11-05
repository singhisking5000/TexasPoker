package resources;

public class Main {
	// this was jam HI JAMASHED
	public static void main(String[] args) {
		Poker game = new Poker();
		GUI gui = new GUI(game);
		game.beginGame();
	}
}