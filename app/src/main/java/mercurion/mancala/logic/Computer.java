package mercurion.mancala.logic;

import java.util.ArrayList;

/**
 * Created by jack on 10/01/2015.
 *
 * this class handles the H-C game. here it's decided the best move to be performed.
 */
public class Computer {


    private Integer id;
    private static Computer instance;


    private Computer(int id) {
        this.id = id;
    }

    public static synchronized Computer getComputer (int id) {
        if (instance == null)
            instance = new Computer(id);
        return instance;
    }

    public static synchronized Computer getComputer () {
        if (instance == null)
            instance = new Computer();
        return instance;
    }

    private Computer() {
    }

    private Integer getStealAndPush(TableHandler board) { //check if i can do a steal&push
        int i, seed, j;
        ArrayList<Integer> candidate = new ArrayList();
        for (i = 0; i < 14; i++) {
            Container c = board.getContainerByIndex(i);
            if (c.getOwnerId().equals(this.id)) {
                seed = c.getNumSeeds();
                Container temp = c;
                for (j = 0; j < seed; j++)
                    temp = temp.getNextContainer();
                if (temp.getNumSeeds() == 0 && temp.getOwnerId().equals(this.id))
                    candidate.add(c.getIndex());
            }
        }

        if (candidate.isEmpty()) {
            return -1;
        } else {
            ArrayList<Integer> numOppositeSeeds = new ArrayList();
            for (i = 0; i < candidate.size(); i++)
                numOppositeSeeds.add(i, board.getNumOfSeedByIndex(12 - candidate.get(i)));
            Integer max = 0;
            int index = 0;
            for (i = 0; i < numOppositeSeeds.size(); i++)
                if (numOppositeSeeds.get(i) >= max) {
                    max = numOppositeSeeds.get(i);
                    index = i;
                }
            return candidate.get(index);
        }
    }


    private Integer getMovePlayAgain (TableHandler board) {
        int i, seed, j;
        for (i = 0; i < 14; i++) {
            Container c = board.getContainerByIndex(i);
            if (c.getOwnerId().equals(this.id)) {
                seed = c.getNumSeeds();
                Container temp = c;
                for (j = 0; j < seed; j++)
                    temp = temp.getNextContainer();
                    if (temp.isTray() && temp.getOwnerId().equals(this.id))
                        return c.getIndex();
            }
        }
        return -1;
    }


    private Integer getBowlToHavePoints (TableHandler board) {
        int i, seed, j;
        for (i = 0; i < 14; i++) {
            Container c = board.getContainerByIndex(i);
            if (c.getOwnerId()==this.id) {
                seed = c.getNumSeeds();
                Container temp = c;
                for (j = 0; j < seed; j++) {
                    temp = temp.getNextContainer();
                    if (temp.isTray() && temp.getOwnerId().equals(this.id))
                        return c.getIndex();
                }
            }
        }
        return -1;
    }


    private Integer getFirstAvailableBowl (TableHandler board) {
        int i;
        Container c;
        for (i = 0; i < 14; i++) {
            c= board.getContainerByIndex(i);
            if (c.getOwnerId() == this.id && c.getNumSeeds() !=0)
                return c.getIndex();
        }

        return -1;
    }


    public Integer getBestMove (TableHandler board) {
//        if (getStealAndPush(board)>-1 && getStealAndPush(board)<14)
  //          return getStealAndPush(board);
        /*else*/ if (getMovePlayAgain(board) >-1 && getMovePlayAgain(board)<14)
    return getMovePlayAgain(board);
    else if (getBowlToHavePoints(board) >-1 && getBowlToHavePoints(board)<14)
            return getBowlToHavePoints(board);
    else
            return getFirstAvailableBowl(board);
}


    public Integer getId () {
        return this.id;
    }

}
