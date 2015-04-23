package mercurion.mancala.logic;

import mercurion.mancala.logic.Container;

/**
 * @author Giacomo Bianchini
 */
public class Tray extends Container {

    public Tray(int ownerId, int index, int numSeeds) {
        super(ownerId, index, numSeeds);
    }

    public void addSeeds (int seeds) {
        super.setNumSeeds(super.getNumSeeds()+seeds);
    }
}