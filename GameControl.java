import java.util.Random;
import java.util.Scanner;

public class GameControl {

	GameView view;

	public GameControl(GameView view) {
		this.view = view;
	}

	/**
	 * Gameplay cycle and order
	 */
	public void gamePlay() {
		view.introductionText();
		decideWinner(playerInput(), computerInput());
	}

	/**
	 * getParity determines the parity of input n
	 * 
	 * @param n is the int to be dertermined
	 * @return true for even, false for odd
	 */
	private boolean getParity(int n) {
		boolean parity = false;
		if (n % 2 == 0) { // n % 2 results in 0 if even
			parity = true;
		}
		return parity;

	}

	/**
	 * Determines which HandSign wins
	 *
	 * The winner can be determined by comparing the parity of the choices. If both
	 * choices are either odd or even, then the lower sign wins. If the choices are
	 * opposing parity (odd and even, or even and odd) then the higher choice wins.
	 *
	 * @param p is the human choice
	 * @param c is the computer choice
	 */
	private void decideWinner(HandSign p, HandSign c) {
		HandSign player = p;
		HandSign computer = c;
		boolean a = getParity(p.getID());
		boolean b = getParity(c.getID());

		if (p.getID() == c.getID()) { // declares a draw if the same sign is chosen
			view.declareDraw(player.getName());

		} else if (Boolean.compare(a, b) == 0) { // if the parity is the same...
			if (p.getID() < c.getID()) { // and player sign is lower than computer...
				view.declareWinner(p.getName(), c.getName(), true); // player wins.
				
			} else { // otherwise...
				view.declareWinner(c.getName(), p.getName(), false); // computer wins
			}
			
		} else { // if the parity is different...
			if (p.getID() > c.getID()) { // and player sign is higher than computer
				view.declareWinner(p.getName(), c.getName(), true); // player wins.
				
			} else { // otherwise...
				view.declareWinner(c.getName(), p.getName(), false); // computer wins.
			}
		}

	}

	/**
	 * Creates a random sign for the computer to use
	 * 
	 * @return HandSign, determined randomly
	 */
	private HandSign computerInput() {

		SignFactory signFactory = new SignFactory();
		Random r = new Random();
		int a = r.nextInt(5) + 1;

		return signFactory.getSign(a);

	}

	/**
	 * Player CLI input using scanner. Allows the user to exit if they input "q" or
	 * "Q"
	 * 
	 * @return HandSign as chosen by player
	 */
	private HandSign playerInput() {

		String userInput = null;
		int signSelection;

		Scanner s = new Scanner(System.in);

		HandSign humanSign = null;
		SignFactory signFactory = new SignFactory();

		boolean validUserInput = false;

		while (!validUserInput) {
			userInput = s.next();

			if (userInput.equals("q") || userInput.equals("Q")) { // allows the user to quit
				System.out.println("Quitting...");
				System.exit(0);

			} else if (userInput.matches("^[1-5]$")) { // limits input to 1-5
				return humanSign = signFactory.getSign(Integer.parseInt(userInput));

			} else {
				System.out.println("Please enter 1, 2, 3, 4 or 5");
			}
		}
		
		s.close();
		return humanSign;
	}
}