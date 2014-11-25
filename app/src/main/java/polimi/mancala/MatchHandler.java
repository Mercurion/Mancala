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

        Log.i("MatchHandler", " " + String.valueOf(player1.getScore())  );
        Log.i("MatchHandler", "Seeds " + String.valueOf(table.getSeeds(3))  );

        while (!isFinished())
        {

            /*
            for (i= position; i<position +number of seed; i++)
                //add 1 seed to i-bowl
                //check if it's going to be "players tray"

            //the cycle is finished
            //check for some contraints: 1. last tray:
                    //if is player tray ---> an other move
                    //if it's an empty bowl ---> pick all the opposite seed and move to tray
                    */
        }
    }


    public void makeAMove (int index) {
        if ((player1.getHisTurn() && 0<=index && index <6) || player2.getHisTurn() && 6 <=index && index <12) { //checks if is possibile to pick the seeds
            int tmp;
            tmp = table.getSeeds(index); //tmp is the number of seeds in the selected bowl
            this.table.clearBowls(index);
            int i;
            for (i = 1 ; i <=tmp; i++) {
                //TODO: HANDLE THE EXCEPTIONS LIKE THE TRAY
                this.table.addSeed(i+index);
            }

        } else {
            //TODO: this is not a good move ---> we have to handle it
        }

    }

    public void beginMatch () {
        player1.setScore(0);
        player2.setScore(0);
        player1.setHisTurn(true);
        player2.setHisTurn(false);
        table.initializeGameBoard();
    }

    public boolean isFinished () { //check if the match is over
        if (this.table.checkPlayer1Finished() || this.table.checkPlayer2Finished())
            return true;
        else
            return false;
    }

}