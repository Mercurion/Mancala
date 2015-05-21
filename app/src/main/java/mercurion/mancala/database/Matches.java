package mercurion.mancala.database;

/**
 * Created by jack on 21/05/2015.
 */
public class Matches {

    int id;
    String winner;

    public Matches (int id, String winner) {
        this.id = id;
        this.winner = winner;
    }

    public int getId() {
        return id;
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
