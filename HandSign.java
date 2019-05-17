public interface HandSign {


    public String getName();
    public int getID();

}

/*
 * The majority of such proposed generalizations are isomorphic to a simple game
 * of modular arithmetic, where half the differences are wins for player one.
 * For instance, rock-paper-scissors-Spock-lizard (note the different order of
 * the last two moves) may be modeled as a game in which each player picks a
 * number from one to five. Subtract the number chosen by player two from the
 * number chosen by player one, and then take the remainder modulo 5 of the
 * result. Player one is the victor if the difference is one or three, and
 * player two is the victor if the difference is two or four. If the difference
 * is zero, the game is a tie.
 */