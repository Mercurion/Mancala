package polimi.mancala;

/**
 * Created by jack on 13/01/2015.
 */
public class Preferences {

    private static Preferences instance;
    private boolean humanComputerGame;

    public static synchronized Preferences getPreferences () {
        if (instance == null)
            instance = new Preferences();
        return instance;
    }


    public boolean isHumanComputerGame() {
        return humanComputerGame;
    }

    public void setHumanComputerGame(boolean humanComputerGame) {
        this.humanComputerGame = humanComputerGame;
    }
}
