package polimi.mancala;

/**
 * @author Giacomo Bianchini
 */


public abstract class Container {

    public int numSeeds;
    public int index;
    public int ownerId;
    public Container nextContainer;

    public Container (int ownerId, int index, int numSeeds) {
        this.ownerId = ownerId;
        this.index= index;
        this.numSeeds = numSeeds;
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

    public void setOwnerId (int userId) {
        this.ownerId = userId;
    }

    public int getOwnerId () {
        return this.ownerId;
    }

    public void setNextContainer (Container givenContainer) {
        this.nextContainer = givenContainer;
    }

    public Container getNextContainer () {
        return this.nextContainer;
    }

    public boolean isEmpty () {
        if (numSeeds ==0)
            return true;
        else
            return false;
    }

}
