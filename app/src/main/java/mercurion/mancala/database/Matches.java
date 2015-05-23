package mercurion.mancala.database;

/**
 * Created by jack on 21/05/2015.
 */
public class Matches {

    int id;
    String winner;
    int best_score;

    public Matches (int id, String winner, int best_score) {
        this.id = id;
        this.winner = winner;
        this.best_score = best_score;
    }

    public int getId() {
        return id;
    }

    public int getBest_score() {
        return best_score;
    }

    public void setBest_score(int best_score) {
        this.best_score = best_score;
    }

    public String getWinner() {
        return winner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }



}
