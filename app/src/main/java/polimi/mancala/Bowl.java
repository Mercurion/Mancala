package polimi.mancala;

/**
 * @author Giacomo Bianchini
 */
/*
the Bowl class has the opposite bowl (not existing in tray class)
and a method to set the number of seeds to 0, that return the number of existing seeds
 */


public class Bowl extends Container {

    public Bowl oppositeBowl;

    public Bowl(int ownerId, int index, int numSeeds) {
        super(ownerId, index, numSeeds);
    }

    public int pickAllSeeds () {
        int tmp = this.getNumSeeds();
        this.setNumSeeds(0);
        return tmp;
    }

    public void setOppositeBowl (Bowl givenBowl) {
        this.oppositeBowl = givenBowl;
    }

    public Bowl getOppositeBowl () {
        return this.oppositeBowl;
    }
}
