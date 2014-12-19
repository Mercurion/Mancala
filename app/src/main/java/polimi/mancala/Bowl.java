package polimi.mancala;

/**
 * @author Giacomo Bianchini
 */

public class Bowl extends Container {

    public Bowl oppositeBowl;

    public void Bowl () {

    }


    public void setOppositeBowl (Bowl givenBowl) {
        this.oppositeBowl = givenBowl;
    }

    public Bowl getOppositeBowl () {
        return this.oppositeBowl;
    }
}
