package polimi.mancala;

/**
 * Created by jack on 21/11/2014.
 */
public class MatchHandler {

    User player1 = new User();
    User player2 = new User();
    TableHandler table = new TableHandler();
    Statistics stats = new Statistics();

    public MatchHandler() {

    }


    public void beginMatch () { //this method will be launched at the very begin of the match
        this.player1.setScore(0);
        this.player2.setScore(0);
        this.table.initializeGameBoard();
    }

    public boolean isFinished () { //check if the match is over
        if (this.table.checkPlayer1Finished() || this.table.checkPlayer2Finished())
            return true;
        else
            return false;
    }

       /*
       method to be executed after the end of match
        */
    public void matchOver (User winner) {
        if (winner == this.player1)
            if (stats.getMax() < winner.score)
                stats.setMax(winner.score);

        stats.oneMorePlayed();
    }

}