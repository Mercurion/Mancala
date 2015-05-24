package mercurion.mancala.database;

/**
 * Created by jack on 21/05/2015.
 */
public class Matches {

    int id;
    int winner;
    int scoreP1;
    int scoreP2;

    public Matches () {
    }

    public Matches (int id, int scoreP1, int scoreP2, int winner) {
        this.id = id;
        this.winner = winner;
        this.scoreP1 = scoreP1;
        this.scoreP2 = scoreP2;
    }

    public Matches (int scoreP1, int scoreP2, int winner) {
        this.winner = winner;
        this.scoreP1 = scoreP1;
        this.scoreP2 = scoreP2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScoreP1() {
        return scoreP1;
    }

    public void setScoreP1(int scoreP1) {
        this.scoreP1 = scoreP1;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    void setScoreP2 (int p2) {
        this.scoreP2 = p2;
    }

    int getScoreP2 () {
        return this.scoreP2;
    }

}
