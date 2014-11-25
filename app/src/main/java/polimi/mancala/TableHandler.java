package polimi.mancala;

import java.util.ArrayList;

/**
 * Created by jack on 21/11/2014.
 */
public class TableHandler {

    public TableHandler () {

    }
    int i;
    ArrayList<Integer> bowls = new ArrayList<Integer>();

    public void initializeGameBoard() {
        for (i=0; i<12; i++) //this initialize the gameboard
            bowls.add(i, 3);
    }

    public int getSeeds (int position) {
        return bowls.get(position);
    }

    public void addSeed (int position) { //this add 1 seed
        this.bowls.set(position,this.bowls.get(position)+1);
    }

    public void clearBowls(int position) { //this method clears a bow: does not return the number of existing seeds
        this.bowls.set(position, 0);
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
        for (i=6; i<12; i++)
            if (this.bowls.get(i)!=0)
                return false;
        return true;
    }
}
