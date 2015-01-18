package polimi.mancala;

import java.util.ArrayList;

/**
 * Created by jack on 10/01/2015.
 */
public class Computer {


    private Integer id;
    private static Computer instance;

    public Computer(int id) {
        this.id = id;
    }


    private Integer getStealAndPush(TableHandler board) { //check if i can do a steal&push
        int i, seed, j;
        ArrayList<Integer> candidate = new ArrayList();
        Container c = board.getContainerByIndex(0);
        for (i = 0; i < 14; i++) {
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
        Container c = board.getContainerByIndex(0);
        for (i = 0; i < 14; i++) {
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
        Container c = board.getContainerByIndex(0);
        for (i = 0; i < 14; i++) {
            if (c.getOwnerId().equals(this.id)) {
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
        Container c = board.getContainerByIndex(0);
        for (i = 0; i < 14; i++)
            if (c.getOwnerId().equals(this.id))
                return c.getIndex();

        return -1;
    }


    public Integer getBestMove (TableHandler board) {
        if (getStealAndPush(board)!=-1)
            return getStealAndPush(board);
        else if (getMovePlayAgain(board) !=-1)
            return getMovePlayAgain(board);
        else if (getBowlToHavePoints(board) !=-1)
            return getBowlToHavePoints(board);
        else
        return getFirstAvailableBowl(board);
    }


    public Integer getId () {
        return this.id;
    }

}
