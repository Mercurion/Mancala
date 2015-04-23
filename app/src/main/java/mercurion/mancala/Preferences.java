package mercurion.mancala;

/**
 * Created by Giacomo Bianchini on 13/01/2015.
 */
public class Preferences {

    private static Preferences instance;
    private boolean humanComputerGame = false;
    private String userName;

    private Preferences () {
    }


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
