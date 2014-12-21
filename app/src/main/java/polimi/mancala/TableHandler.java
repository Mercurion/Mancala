package polimi.mancala;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Giacomo Bianchini
 */


public class TableHandler {

    private final int IN_S = 3;

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
    ArrayList<Integer> bowls = new ArrayList<>();

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
            this.bowls.add(i, IN_S);
            else
                this.bowls.add (i, 0);
    }

    public void createInitialBoard(int p1Id, int p2Id) {
        int [] initialBoard = {IN_S,IN_S,IN_S,IN_S,IN_S,IN_S,0,IN_S,IN_S,IN_S,IN_S,IN_S,IN_S,0};
        ArrayList<Container> cont = new ArrayList<>();
        this.updatedBowls = cont;
        Container tmp;
        for (i=0; i<6; i++) { //here the first 6 bowls: the P1 bowls
            tmp = new Bowl(p1Id,i,initialBoard[i]);
            cont.add(i,tmp);
        }
        tmp = new Tray(1,i,0);
        cont.add(tmp);
        i++;
        for (i=7; i<13; i++) { //here the first 6 bowls: the P1 bowls
            tmp = new Bowl(p2Id,i,initialBoard[i]);
            cont.add(i,tmp);
        }
        tmp = new Tray(2,i,0);
        cont.add(tmp);
        this.updatedBowls = cont;

        setAllOppositeBowls();
        setAllNextContainers();
    }

    private void setAllOppositeBowls() {
        Container tmp;
        Container opposite;
        int i;
        for (i=0;i<14 ;i++) {
            tmp = getContainerByIndex(i);
            if (tmp.isBowl()) {
                opposite =  (this.getContainerByIndex(12-i));
                ((Bowl) this.getContainerByIndex(i)).setOppositeBowl((Bowl) opposite);
            }
        }
    }

    //TODO: CHECK THIS METHOD, COULD NOT BE CORRECT
    public void setAllNextContainers () {
        Iterator<Container> tempIter = this.getContainers().iterator();
        Container c = this.getContainerByIndex(0);
        while (tempIter.hasNext()) {
            c.setNextContainer(tempIter.next());
            c = tempIter.next();
        }
        c = this.getContainerByIndex(13);
        c.setNextContainer(this.getContainerByIndex(0));
    }

    public int [] getGameBoardState() {
        int [] actualState = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        for (i =0; i<14; i++ )
            actualState[i] = getContainerByIndex(i).getNumSeeds();
        return actualState;
    }

    public boolean checkPlayerGameIsOverById(int playerId) {
        Iterator<Container> tempIter = this.getContainers().iterator();
        Container c = this.getContainerByIndex(0);
        while (tempIter.hasNext()) {
            if (c.isBowl() && (c.getOwnerId() == playerId) && (c.getNumSeeds() !=0))
                return false;
            c= tempIter.next();
        }

        return true;
    }

    public int getNumOfSeedByIndex (int index) {
        Container c = this.getContainerByIndex(index);
        return c.getNumSeeds();
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
