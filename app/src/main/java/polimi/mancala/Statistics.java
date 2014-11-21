package polimi.mancala;

/**
 * Created by jack on 21/11/2014.
 */
public class Statistics {

    public void Statistics () {

    }

    public int maxScore;
    public int gamePlayed;

    //TODO: perform setter and getter using a file

    public int getMax (){
        return this.maxScore;
    }

    public void setMax (int value) {
        this.maxScore = value;
    }

    public int getGamePlayed () {
        return this.gamePlayed;
    }

    public void setGamePlayed (int value) {
        this.gamePlayed = value;
    }
}
