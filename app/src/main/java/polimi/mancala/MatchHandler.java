package polimi.mancala;

import android.util.Log;

/**
 * Created by Giacomo Bianchini on 21/11/2014.
 *
 * this class contains all the constrains for the game
 *
 */
public class MatchHandler {


    User player1 = new User();
    User player2 = new User();
    TableHandler table = new TableHandler();

    public MatchHandler() {

    }


    public void playGame () {

        Log.i("MatchHandler", " " + String.valueOf(player1.getScore())  );
        Log.i("MatchHandler", "Seeds " + String.valueOf(table.getNumOfSeeds(3))  );

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

    public String endOfTheGame () { //this method perform the end of the game and return the name of the winner
        int i;
        for (i=0; i<14; i++)
            if (i!=6 && i!= 13)
                pickAndPush(i);

        if (this.player1.getScore() < this.player2.getScore())
            return "Player2";
        else
            if (this.player2.getScore() < this.player1.getScore())
                return "Player1";
        else
                return "Tie";
    }

    public void pickAndPush (int indexOfBowl) { //this method picks all the seeds from a bowl and put them in the tray
        int points = this.table.getNumOfSeeds(indexOfBowl);

        if (table.isPlayerOneBowl(indexOfBowl))
            player1.setScore(player1.getScore()+ points);

        if (table.isPlayerTwoBowl(indexOfBowl))
            player2.setScore(player2.getScore()+ points);

        this.table.clearBowls(indexOfBowl);
    }

    public void stealAndPush (int indexOfBowl) {
        int points = this.table.getNumOfSeeds(indexOfBowl);

        if (table.isPlayerOneBowl(indexOfBowl))
            player2.setScore(player2.getScore()+ points);

        if (table.isPlayerTwoBowl(indexOfBowl))
            player1.setScore(player1.getScore()+ points);

        this.table.clearBowls(indexOfBowl);
    }


    public boolean isPossibleToMove (int index) {
        if (this.player1.isHisTurn &&  this.table.isPlayerOneBowl(index))
            return true;
        else if (this.player2.isHisTurn && this.table.isPlayerTwoBowl(index))
            return true;
            else return false;
    }

    public boolean isEmptyBowl (int index) { //returns true if the bowl in the index has NO MORE SEEDS
        if (table.getNumOfSeeds(index) == 0)
            return true;
        else
            return false;
    }

    public int makeAMove (int index) {
        int tmp;
        tmp = table.getNumOfSeeds(index); //tmp is the number of seeds in the selected bowl
        this.table.clearBowls(index);
        int i;
        for (i = 1; i <= tmp; ) {
            //TODO: HANDLE THE EXCEPTION: THE NEXT BOWL HAS TO BE THE NUMBER 0
            this.table.addSeed(i + index);
            i++;
        }

        return tmp+index;
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