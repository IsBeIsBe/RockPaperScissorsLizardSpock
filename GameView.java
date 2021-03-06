/**
 * Class to handle the bulk of the console output, leaving the game logic
 * clear
 */

public class GameView {

	/**
	 * Displayed at the start of the game
	 */
    public void introductionText() {
        System.out.println("What do you choose? \r\n");
        System.out.println("[Please enter 1, 2, 3, 4 or 5] \r\n");
        System.out.println("1: Rock \r\n2: Paper \r\n3: Scissors \r\n4: Spock \r\n5: Lizard");
    }

    /**
     * Displays text corresponding to who wins
     * @param winningSign
     * @param losingSign
     * @param humanWin
     */
    public void declareWinner(String winningSign, String losingSign, boolean humanWin) {

        if (humanWin)
            System.out.println(winningSign + " beats " + losingSign + "! You win!");
        else if (!humanWin)
            System.out.println(winningSign + " beats " + losingSign + "! You lose!");
    }

    public void declareDraw(String drawingSign) {
        System.out.println("You both threw " + drawingSign + "! This round was a draw");
    }

}