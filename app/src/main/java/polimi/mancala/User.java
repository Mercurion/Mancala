package polimi.mancala;

/**
 * Created by jack on 21/11/2014.
 */
public class User {

    public User () {
        this.score = 0;
    }

    int score;

    public void setScore (int value) {
        this.score = value;
    }

    public int getScore (){
        return this.score;
    }

}
