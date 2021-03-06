package mercurion.mancala.logic;

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

    public ArrayList getContainers () {
        return this.updatedBowls;
    }

    public Container getContainerByIndex (int index) {
        Iterator<Container> temp = getContainers().iterator();
        do {
            Container c = temp.next();
            if (c.getIndex()==index)
                return c;
        }while (temp.hasNext());

        return null;
    }

    public Tray getTrayByPlayerId(int playerId) {
        Iterator<Container> temp = getContainers().iterator();
        while (temp.hasNext()) {
            Container c = temp.next();
            if (c.isTray() && c.ownerId == playerId) {
                return (Tray) c;
            }
        }
        return null;
    }

    public void createInitialBoard(int p1Id, int p2Id) {
        int [] initialBoard = {IN_S,IN_S,IN_S,IN_S,IN_S,IN_S,0,IN_S,IN_S,IN_S,IN_S,IN_S,IN_S,0};
        ArrayList<Container> cont = new ArrayList<>();
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

    public void setAllNextContainers () {
        int i;
        for (i=0; i<13; i++)
            this.getContainerByIndex(i).setNextContainer(getContainerByIndex(i+1));
        this.getContainerByIndex(13).setNextContainer(getContainerByIndex(0));
    }

    public int [] getGameBoardStatus() {
        int [] actualState = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        for (i =0; i<14; i++ )
            actualState[i] = getNumOfSeedByIndex(i);
        return actualState;
    }

    public boolean checkPlayerGameIsOverById(Integer playerId) {
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

    public Integer getPlayerIdByIndex (int index) {
        Container c = this.getContainerByIndex(index);
        return c.getOwnerId();
    }

    public Integer clearBoardByPlayerId (Integer idPlayer) {
        Iterator<Container> tempIter = this.getContainers().iterator();
        Container c = this.getContainerByIndex(0);
        Integer points = 0;
        do {
            if (c.isBowl() && c.getOwnerId().equals(idPlayer))
                points = points + pickAndPush(c.getIndex());
            c= tempIter.next();
        } while (tempIter.hasNext());
        return points;
    }

    public Integer pickAndPush (Integer index) {
        Integer idPlayer = getPlayerIdByIndex(index);
        Container c = this.getContainerByIndex(index);
        Tray t = getTrayByPlayerId(idPlayer);
        Integer points = c.getNumSeeds();
        t.addSeeds(points);
        c.setNumSeeds(0);
        return points;
    }

    public Integer stealAndPush (Integer index) {
        Bowl c = (Bowl)this.getContainerByIndex(index);
        Bowl opposite = c.getOppositeBowl();
        Integer points = opposite.getNumSeeds();
        opposite.setNumSeeds(0);
        Integer idPlayer = c.getOwnerId();
        Tray t = getTrayByPlayerId(idPlayer);
        t.addSeeds(points);
        return points;
    }

    public int move (int initialIndex) {
        Bowl initial = (Bowl) getContainerByIndex(initialIndex);
        Container c = initial;
        int seeds = initial.pickAllSeeds();
        for (i=1; i<=seeds; i++) {
            c = c.getNextContainer();
            c.addOneSeed();
        }
        return c.getIndex();
    }

}
