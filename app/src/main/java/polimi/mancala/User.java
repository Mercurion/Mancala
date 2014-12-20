package polimi.mancala;

/**
 * @author Giacomo Bianchini
 */

public class User {


    public User (int id) {
        score = 0;
        isHisTurn = false;
        this.id= id;
    }

    int score;
    private Integer id;
    boolean isHisTurn;

    public void setId (int givenId) {
        this.id = givenId;
    }

    public int getId () {
        return this.id;
    }

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
