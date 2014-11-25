package polimi.mancala;

import android.util.Log;

/**
 * Created by Giacomo Bianchini on 21/11/2014.
 */
public class MatchHandler {


    User player1 = new User();
    User player2 = new User();
    TableHandler table = new TableHandler();

    public MatchHandler() {

    }


    public void playGame () {
        beginMatch();
        Log.i("MatchHandler", " " + String.valueOf(player1.getScore())  );


    }

    public void beginMatch () {
        player1.setScore(0);
        player2.setScore(0);
        table.initializeGameBoard();
    }

    public boolean isFinished () { //check if the match is over
        if (this.table.checkPlayer1Finished() || this.table.checkPlayer2Finished())
            return true;
        else
            return false;
    }

}