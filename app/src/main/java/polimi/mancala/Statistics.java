package polimi.mancala;

import java.io.File;

/**
 * Created by jack on 21/11/2014.
 */
public class Statistics {

    File statFile;

    public void Statistics () {
        /* TODO: INSERT SOMETHING LIKE this.maxscore = setMax(default path to file) */

    }

    public int maxScore;
    public int gamePlayed;

    //TODO: perform setter and getter using a file

    public int getMax (){
        return this.maxScore;
    }

    //TODO: has to be done with a pathfile
    public void setMax (int value) {
        this.maxScore = value;
    }

    public int getGamePlayed () {
        return this.gamePlayed;
    }

    public void setGamePlayed (int value) {
        this.gamePlayed = value;
    }

    public void oneMorePlayed () {
        //TODO: here has to be set that the game played value will be increased by one
    }
}
