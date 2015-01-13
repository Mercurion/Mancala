package polimi.mancala;


import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by Giacomo Bianchini on 21/11/2014.
 *
 * this class contains all the constrains for the game
 *
 */
public class MatchHandler {

    private static final Integer num_Seed = 3;
    private static MatchHandler instance = null;
    User player1 = new User(1);
    User player2 = new User(2);
    Computer aI = new Computer(2);

    TableHandler table = TableHandler.getInstance();
    Statistics stat = new Statistics();

    private MatchHandler() {
    }

    public static synchronized MatchHandler getMatchHandler () {
        if (instance == null)
            instance = new MatchHandler();
        return instance;
    }

    public void beginMatch () {
        this.player1.setScore(0);
        this.player2.setScore(0);
        this.player1.setHisTurn(true);
        this.player2.setHisTurn(false);
        this.player1.setId(1);
        this.player2.setId(2);
        table.createInitialBoard(this.player1.getId(), this.player2.getId());

    }


    private int endOfTheGame () { //this method perform the end of the game and return the name of the winner
        player1.addPoints(table.clearBoardByPlayerId(player1.getId()));
        player2.addPoints(table.clearBoardByPlayerId(player2.getId()));

        if (this.player1.getScore() > this.player2.getScore())
            return this.player1.getId();
        else
            if (this.player2.getScore() > this.player1.getScore())
                return this.player2.getId();
        else
                return 0;
    }

    //TODO: here we have to do something about the return type
    public void playTheGame (int bowlClicked) {
        ArrayList<Integer> gameInfo = null;
        int[] tmp;
        int turnScore =0;
        int lastBowl, i;
        if (checkIfCanMove(bowlClicked)) {
            lastBowl = makeAMove(bowlClicked);
            updateScoreByPlayerId(player1.getId());
            updateScoreByPlayerId(player2.getId());
            //here an if to handle the case that I put my last seed in an empty bowl
            if (checkIfHasToSteal(lastBowl)) {
                turnScore = turnScore + table.pickAndPush(lastBowl) + table.stealAndPush(lastBowl);
            }

            //here we check if we do need to change the turn

            if (checkIfHasToSwapTurn(lastBowl)) {
                player1.changeTurn();
                player2.changeTurn();
            }
        }

        updateScoreByPlayerId(getActivePlayerId());

        if (isFinished()) {
            int winner;
            winner = endOfTheGame();
        }

        tmp = getActualBoard();
        for (i=0; i<14;i++)
            gameInfo.add(i, tmp[i]);



    }


    public int[] getActualBoard() {
        return table.getGameBoardStatus();
    }


    public boolean isFinished () { //check if the match is over
        if (table.checkPlayerGameIsOverById(this.player1.getId()))
            return true;
        else
        if (table.checkPlayerGameIsOverById(this.player2.getId()))
            return true;
        else
            return false;
    }


    private boolean checkIfCanMove (Integer clicked) {
        if (isCorrectTurn(clicked) && !table.getContainerByIndex(clicked).isEmpty() && table.getContainerByIndex(clicked).isBowl())
            return true;
        else
            return false;
    }

    private boolean checkIfHasToSwapTurn (Integer last) {
        if (last == table.getTrayByPlayer(getActivePlayerId()).getIndex())
            return false;
        else
            return true;
    }

    private boolean checkIfHasToSteal (Integer lastBowl) {
        if (table.getContainerByIndex(lastBowl).isTray())
            return false;
        else
            if (table.getContainerByIndex(lastBowl).getNumSeeds() !=0)
                return false;
            else if (getActivePlayerId().equals(table.getPlayerIdByIndex(lastBowl)))
                return true;
                else
                return false;
    }

    public Integer getActivePlayerId () {
        if (this.player1.getHisTurn())
            return player1.getId();
        else
            return player2.getId();
    }

    private User getPlayerById(Integer id) {
        if (this.player1.getId().equals(id))
            return player1;
        else
            return player2;

    }

    private void updateScoreByPlayerId (Integer idPlayer) {
        int score = table.getTrayByPlayer(idPlayer).getNumSeeds();
        User player = getPlayerById(idPlayer);
        player.setScore(score);
    }

    private boolean isCorrectTurn(int index) {
        if (getActivePlayerId().equals(table.getPlayerIdByIndex(index)))
            return true;
        else
            return false;
    }

    public int makeAMove (int index) {
        return table.move(index);
    }
    /*
    below here is deprecated
     */

}