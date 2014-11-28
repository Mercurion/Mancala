package polimi.mancala;

/**
 * Created by jack on 21/11/2014.
 */
public class User {

    public User () {
        this.score = 0;
    }

    int score;
    boolean isHisTurn;

    public void setScore (int value) {
        this.score = value;
    }

    public int getScore (){
        return this.score;
    }

    public void setHisTurn (boolean turn) {
        this.isHisTurn = turn;
    }

    public void changeTurn () {
        if (this.isHisTurn == true)
            setHisTurn(false);
        else
            setHisTurn(true);
    }

    public boolean getHisTurn () {
        return this.isHisTurn;
    }
}
