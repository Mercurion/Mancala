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

    /**
     *
     * @param indexOfBowl
     *
     */
    public void stealAndPush (int indexOfBowl) {
        int points = this.table.getNumOfSeeds(indexOfBowl);

        if (table.isPlayerOneBowl(indexOfBowl))
            player2.setScore(player2.getScore()+ points);

        if (table.isPlayerTwoBowl(indexOfBowl))
            player1.setScore(player1.getScore()+ points);

        this.table.clearBowls(indexOfBowl);
    }

    /**
     *
     * @param index
     * @return if it's possible to move
     */
    public boolean isPossibleToMove (int index) {
        if (this.player1.isHisTurn &&  this.table.isPlayerOneBowl(index))
            return true;
        else if (this.player2.isHisTurn && this.table.isPlayerTwoBowl(index))
            return true;
            else return false;
    }


    /**
     *
     * @param index
     * @return true if it's an empy bowl
     * @see this.table.getNumOfSeeds ()
     */
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
        this.player1.setScore(0);
        this.player2.setScore(0);
        this.player1.setHisTurn(true);
        this.player2.setHisTurn(false);
        this.table.initializeGameBoard();
    }

    public boolean isFinished () { //check if the match is over
        if (this.table.checkPlayer1Finished() || this.table.checkPlayer2Finished())
            return true;
        else
            return false;
    }

}