import java.util.Random;

public class GameRun {

    public static void main(String[] args) {

    	/*
    	 * Create a view to pass to control, then create a control
    	 */
        GameView view = new GameView();
        GameControl control = new GameControl(view);
        control.gamePlay();
    

    }

}