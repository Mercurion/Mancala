package polimi.mancala;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by Giacomo Bianchini on 21/11/2014
 */

public class MatchActivity extends Activity {

    MatchHandler game = new MatchHandler();

    @Override
    protected void onCreate (Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_match);
        /*
        delete the next string
         */
        Log.i("matchactivity", "this is an output");
        this.game.beginMatch();

    }

    public void bowlClicked(View v) {
        //TODO: here we need to give to this methods the number of the bowl (set the index) that has been clicked
        int index;
        int lastBowl;
        if (game.isPossibleToMove(5) && !game.isEmptyBowl(5)) { //here we need to set the index and pass index instead of 5
            lastBowl = game.makeAMove(5);


            //here an if to handle the case that I put my last seed in an empty bowl
            //TODO: CHECK THAT IS THE CURRENT PLAYER BOWL should be done
            if (this.game.table.getNumOfSeeds(lastBowl) == 0 && (this.game.table.isPlayerOneBowl(lastBowl) && this.game.player1.getHisTurn() ||
                    this.game.table.isPlayerTwoBowl(lastBowl) && this.game.player2.getHisTurn())) {

                this.game.pickAndPush(lastBowl);
                this.game.stealAndPush(12 - lastBowl);
            }


            //here we check if we do need to change the turn

            if (!((lastBowl == 6 && this.game.player1.getHisTurn())||(lastBowl == 13 && this.game.player2.getHisTurn()))) {
                this.game.player1.changeTurn();
                this.game.player2.changeTurn();
            }

        }

        if (game.isFinished()) {
            String winner = new String();
            winner = game.endOfTheGame();
            //TODO: graphically do something to make us understand that the game is over
        }
    }
    /* this is a comment */
}
