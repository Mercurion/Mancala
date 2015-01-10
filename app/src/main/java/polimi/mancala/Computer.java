package polimi.mancala;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by jack on 10/01/2015.
 */
public class Computer extends User {


    public Computer(int id) {
        super(id);
    }


    public Integer getStealAndPush(TableHandler board) { //check if i can do a steal&push
        int i, seed, j;
        ArrayList<Integer> candidate = new ArrayList();
        Container c = board.getContainerByIndex(0);
        for (i = 0; i < 14; i++) {
            if (c.getOwnerId().equals(this.getId())) {
                seed = c.getNumSeeds();
                Container temp = c;
                for (j = 0; j < seed; j++)
                    temp = temp.getNextContainer();

                if (temp.getNumSeeds() == 0 && temp.getOwnerId().equals(this.getId()))
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
}
