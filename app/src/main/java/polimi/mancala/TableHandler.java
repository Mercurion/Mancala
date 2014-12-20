package polimi.mancala;

import java.util.ArrayList;
import java.util.Iterator;

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
    ArrayList<Container> updatedBowls = new ArrayList<>();
    ArrayList<Integer> bowls = new ArrayList<Integer>();

    public ArrayList getContainers () {
        return this.updatedBowls;
    }

    public Container getContainerByIndex (int index) {
        Iterator<Container> temp = getContainers().iterator();
        while (temp.hasNext()) {
            Container c = temp.next();
            if (c.getIndex()==index)
                return c;
        }
        return null;
    }

    public Tray getTrayByPlayer (int playerId) {
        Iterator<Container> temp = getContainers().iterator();
        while (temp.hasNext()) {
            Container c = temp.next();
            if (c.isTray() && c.ownerId == playerId) {
                return (Tray) c;
            }
        }
        return null;
    }

    public void initializeGameBoard() {
        for (i=0; i<14; i++) //this initialize the gameboard
        if (i!=6 && i!= 13)
            this.bowls.add(i, INITIAL_SEEDS);
            else
                this.bowls.add (i, 0);
    }

    public int [] getGameBoardState() {
        int [] actualState = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        for (i =0; i<14; i++ )
            actualState[i] = getContainerByIndex(i).getNumSeeds();
        return actualState;
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
