import java.util.Random;
import java.util.Scanner;

public class GameControl {

    GameView view;

    public GameControl(GameView view) {
        this.view = view;
    }

    public void gamePlay() {
        view.introductionText();
        decideWinner(playerInput(), computerInput());
    }

    public int decideWinner(HandSign h, HandSign c) {
        HandSign human = h;
        HandSign computer = c;
        int a;
        int b;

        a = human.getID() - computer.getID();
        b = a % 5;

        if (b == 1 || b == 3) { // human wins
            view.declareWinner(human.getName(), computer.getName(), true);
            return 1;
        } else if (b == 2 || b == 4) { // computer wins
            view.declareWinner(computer.getName(), human.getName(), false);
            return -1;
        } else { // draw
            System.out.println(human.getName());
            view.declareDraw(human.getName());
            return 0;
        }
        
        
    }

    public HandSign computerInput() {

        SignFactory signFactory = new SignFactory();
        Random r = new Random();
        int a = r.nextInt(4);

        return signFactory.getSign(a);

    }

    public HandSign playerInput() {

        String userInput = null;
        int signSelection;
        boolean validUserInput = false;
        Scanner s = new Scanner(System.in);
        HandSign humanSign = null;
        SignFactory signFactory = new SignFactory();

        while (!validUserInput) {
            userInput = s.next();

            if (userInput.contains("q") || userInput.contains("Q")) {
                System.out.println("Quitting...");
                System.exit(0);
            } else if (userInput.matches("^[0-5]$")) {
                return humanSign = signFactory.getSign(Integer.parseInt(userInput));
            }
        }
        return humanSign;
    }
}
