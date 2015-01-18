package polimi.mancala;




import java.util.ArrayList;
import android.content.Context;


/**
 * Created by Giacomo Bianchini on 21/11/2014.
 *
 * this class contains all the constrains for the game
 *
 */
public class MatchHandler{

    private static MatchHandler instance = null;
    User player1 = new User(1);
    User player2 = new User(2);
    Computer aI = Computer.getComputer(2);
    int winner = -1;
    int lastBowl;
    Context cont;

    Preferences settings = Preferences.getPreferences();
    TableHandler table = TableHandler.getInstance();

    private MatchHandler(Context ctx) {
        this.cont = ctx;
    }

    public static synchronized MatchHandler getMatchHandler (Context ctx) {
        if (instance == null)
            instance = new MatchHandler(ctx);
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
/*        if (settings.isHumanComputerGame())
            this.aI = new Computer(player2.getId());*/
    }


    private int endOfTheGame () { //this method perform the end of the game and return the name of the winner
        table.clearBoardByPlayerId(player1.getId());
        table.clearBoardByPlayerId(player2.getId());
        updateScoreByPlayerId(player1.getId());
        updateScoreByPlayerId(player2.getId());
        Statistics stat = Statistics.getStatistics(cont);

        if (this.player1.getScore() > this.player2.getScore()) {
            stat.updateMaxScore(player1.getScore());
            stat.oneMorePlayed();
            return this.player1.getId();
        }
        else
            if (this.player2.getScore() > this.player1.getScore()) {
                stat.updateMaxScore(player2.getScore());
                stat.oneMorePlayed();
                return this.player2.getId();
            }
        else
                return 0;
    }

    //TODO: here we have to do something about the return type
    public void playTheGame (int bowlClicked) {
        ArrayList<Integer> gameInfo = new ArrayList<Integer>();
        int[] tmp;
        int tmplastBowl, i;
        if (checkIfCanMove(bowlClicked)) {
            tmplastBowl = makeAMove(bowlClicked);
            this.lastBowl = tmplastBowl;
            updateScoreByPlayerId(player1.getId());
            updateScoreByPlayerId(player2.getId());
            //here an if to handle the case that I put my last seed in an empty bowl
            if (checkIfHasToSteal(tmplastBowl)) {
                table.pickAndPush(tmplastBowl);
                table.stealAndPush(tmplastBowl);
            }
            updateScoreByPlayerId(getActivePlayerId());

            //here we check if we do need to change the turn

            if (checkIfHasToSwapTurn(tmplastBowl)) {
                player1.changeTurn();
                player2.changeTurn();
            }
        }

        updateScoreByPlayerId(getActivePlayerId());

        if (isFinished()) {
            this.winner = endOfTheGame();
        }

        tmp = getActualBoard();
        for (i=0; i<14;i++)
            gameInfo.add(i, tmp[i]);
    }


    public void aIMove () {
        ArrayList<Integer> gameInfo = new ArrayList<Integer>();
        int bowlClicked;
        int[] tmp;
        int tmplastBowl, i;
        bowlClicked = aI.getBestMove(table);
 //       bowlClicked = 7;
        if (checkIfCanMove(bowlClicked)) {
            tmplastBowl = makeAMove(bowlClicked);
            this.lastBowl = tmplastBowl;
            updateScoreByPlayerId(player1.getId());
            updateScoreByPlayerId(player2.getId());
            //here an if to handle the case that I put my last seed in an empty bowl
            if (checkIfHasToSteal(tmplastBowl)) {
                table.pickAndPush(tmplastBowl);
                table.stealAndPush(tmplastBowl);
            }
            updateScoreByPlayerId(getActivePlayerId());

            //here we check if we do need to change the turn

            if (checkIfHasToSwapTurn(tmplastBowl)) {
                player1.changeTurn();
                player2.changeTurn();
            }
        }

        updateScoreByPlayerId(getActivePlayerId());

        if (isFinished()) {
            this.winner = endOfTheGame();
        }

        tmp = getActualBoard();
        for (i=0; i<14;i++)
            gameInfo.add(i, tmp[i]);

    }

    public boolean checkIfAIMove() {
        if (getActivePlayerId().equals(aI.getId()) && settings.isHumanComputerGame())
            return true;
        else
            return false;
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


    public int getWinner () {
        return this.winner;
    }

    private boolean checkIfCanMove (Integer clicked) {
        if (isCorrectTurn(clicked) && !table.getContainerByIndex(clicked).isEmpty() && table.getContainerByIndex(clicked).isBowl())
            return true;
        else
            return false;
    }

    public boolean checkToSwap () {
        if (this.lastBowl == table.getTrayByPlayerId(getActivePlayerId()).getIndex())
            return false;
        else
            return true;
    }

    private boolean checkIfHasToSwapTurn (Integer last) {
        if (last == table.getTrayByPlayerId(getActivePlayerId()).getIndex())
            return false;
        else
            return true;
    }

    private boolean checkIfHasToSteal (Integer lastBowl) {
        if (table.getContainerByIndex(lastBowl).isTray())
            return false;
        else
            if (table.getContainerByIndex(lastBowl).getNumSeeds() !=1)
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
        if (idPlayer.equals(player1.getId()))
            player1.setScore(table.getTrayByPlayerId(player1.getId()).getNumSeeds());
        else
            player2.setScore(table.getTrayByPlayerId(player2.getId()).getNumSeeds());
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
}