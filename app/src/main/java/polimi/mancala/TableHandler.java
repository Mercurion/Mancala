package polimi.mancala;

import java.util.ArrayList;

/**
 * @author Giacomo Bianchini
 */
public class TableHandler {

    private final int INITIAL_SEEDS = 3;

    private static TableHandler instance = null;

    private TableHandler () {
    }

    public static synchronized TableHandler getInstance () {
        if (instance == null)
            instance = new TableHandler();
        return instance;

    }
    int i;
    ArrayList<Integer> bowls = new ArrayList<Integer>();

    public void initializeGameBoard() {
        for (i=0; i<14; i++) //this initialize the gameboard
        if (i!=6 && i!= 13)
            this.bowls.add(i, INITIAL_SEEDS);
            else
                this.bowls.add (i, 0);
    }

    public int getNumOfSeeds(int position) {
        return bowls.get(position);
    }

    public void addSeed (int position) { //this add 1 seed
        this.bowls.set(position,this.bowls.get(position)+1);
    }

    public void clearBowls(int position) { //this method clears a bow: does not return the number of existing seeds
        this.bowls.set(position, 0);
    }

    public boolean isPlayerOneBowl (int index) {
        if (0<=index && index <6)
            return true;
        else
            return false;
    }

    public boolean isPlayerTwoBowl (int index) {
        if (7<=index && index <13)
            return true;
        else
            return false;
    }


    /*this
    this method checks if there are no residual seeds. if there are return FALSE. if there are no more seeds, return TRUE
     */
    public boolean checkPlayer1Finished () {
        for (i=0; i<6; i++)
            if (this.bowls.get(i)!=0)
                return false;
        return true;
    }

    public boolean checkPlayer2Finished () {
        for (i=7; i<13; i++)
            if (this.bowls.get(i)!=0)
                return false;
        return true;
    }
}
