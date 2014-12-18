package polimi.mancala;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * Created by Giacomo Bianchini on 21/11/2014
 */

public class MatchActivity extends Activity {

    MatchHandler game = MatchHandler.getMatchHandler();

    @Override
    protected void onCreate (Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_match);


        Button player1Bowl1 = (Button) findViewById(R.id.player1bowl1);
        player1Bowl1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                UpdateUI(performMove(1, 1));

            }
        });

        Button player1Bowl2 = (Button) findViewById(R.id.player1bowl2);
        player1Bowl2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                UpdateUI(performMove(1, 2));


            }
        });

        /*
        delete the next string
         */
        Log.i("matchactivity", "this is an output");
        this.game.beginMatch();

    }

    private void UpdateUI(boolean b) {
        if (b){
            //No need to disable current player
            //Keep on playing
        }
        else{
            //Disable current player
            //Enable other player
        }
        UpdateUIValues();
    }

    private void UpdateUIValues() {
        Button player1bowl1 = (Button) findViewById(R.id.player1bowl1);
        player1bowl1.setText("" + getCurrentValue(1,1));
        Button player1bowl2 = (Button) findViewById(R.id.player1bowl2);
        player1bowl2.setText("" + getCurrentValue(1,2));
    }

    private int getCurrentValue(int player, int bowlNumber) {
        //Get the current value of stones in the bowl
        // for the player passed as parameter
        return 2; //Just to test
    }

    private boolean performMove(int player, int bowlNumber) {

        //Perform move for player passed as parameter on the bowl passed as parameter

        return false;
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
