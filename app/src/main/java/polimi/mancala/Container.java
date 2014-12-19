package polimi.mancala;

/**
 * @author Giacomo Bianchini
 */


public abstract class Container {

    public int numSeeds;
    public int index;
    public User owner;

    public Container () {

    }

    public boolean isBowl () {
        if (this instanceof Bowl)
            return true;
        else
            return false;
    }

    public boolean isTray (){
        if (this instanceof Tray)
            return true;
        else
            return false;
    }

    public void setNumSeeds (Integer seeds) {
        this.numSeeds = seeds;
    }

    public int getNumSeeds () {
        return numSeeds;
    }

    public void addOneSeed () {
        this.setNumSeeds(this.getNumSeeds()+1);
    }

    public void addSeeds (int seeds) {
        this.setNumSeeds(this.getNumSeeds()+seeds);
    }

    public void setIndex (int givenIndex) {
        this.index = givenIndex;
    }

    public int getIndex () {
        return this.index;
    }

}
