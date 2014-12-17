package polimi.mancala;

import android.util.Log;

/**
 * Created by Giacomo Bianchini on 21/11/2014.
 *
 * this class contains all the constrains for the game
 *
 */
public class MatchHandler {


    private static MatchHandler instance = null;
    User player1 = new User();
    User player2 = new User();
    TableHandler table = TableHandler.getInstance();

    private MatchHandler() {
    }

    public static synchronized MatchHandler getMatchHandler () {
        if (instance == null)
            instance = new MatchHandler();
        return instance;
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

    //TODO: here we have to do something about the return type
    public void playTheGame (int bowlClicked) {
        int index = bowlClicked;
        int lastBowl;
        if (isPossibleToMove(index) && !isEmptyBowl(index)) { //here we need to set the index and pass index instead of 5
            lastBowl = makeAMove(index);


            //here an if to handle the case that I put my last seed in an empty bowl
            //TODO: CHECK THAT IS THE CURRENT PLAYER BOWL should be done
            if (table.getNumOfSeeds(lastBowl) == 0 && (table.isPlayerOneBowl(lastBowl) && player1.getHisTurn() ||
                    table.isPlayerTwoBowl(lastBowl) && player2.getHisTurn())) {

                pickAndPush(lastBowl);
                stealAndPush(12 - lastBowl);
            }


            //here we check if we do need to change the turn

            if (!((lastBowl == 6 && player1.getHisTurn())||(lastBowl == 13 && player2.getHisTurn()))) {
                player1.changeTurn();
                player2.changeTurn();
            }

        }

        if (isFinished()) {
            String winner = new String();
            winner = endOfTheGame();
            //TODO: graphically do something to make us understand that the game is over
        }

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
            //TODO: HANDLE THE EXCEPTION: THE NEXT BOWL HAS TO BE THE NUMBER 0: should be done
            if ((i + index) == 14) {
                index = -i;
            }
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