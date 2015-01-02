package polimi.mancala;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;


/**
 * Created by Giacomo Bianchini on 21/11/2014
 */

public class MatchActivity extends Activity {

    MatchHandler game = MatchHandler.getMatchHandler();

    @Override
    protected void onCreate (Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_match);


        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("@+id/player1bowl1", 1);
        myMap.put("@+id/player1bowl2", 2);
        myMap.put("@+id/player1bowl3", 3);
        myMap.put("@+id/player1bowl4", 4);
        myMap.put("@+id/player1bowl5", 5);
        myMap.put("@+id/player1tray1", 6);
        myMap.put("@+id/player2bowl1", 7);
        myMap.put("@+id/player2bowl2", 8);
        myMap.put("@+id/player2bowl3", 9);
        myMap.put("@+id/player2bowl4", 10);
        myMap.put("@+id/player2bowl5", 11);
        myMap.put("@+id/player2tray2", 12);



        Button player1Bowl1 = (Button) findViewById(R.id.player1bowl1);
        player1Bowl1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 1);
                UpdateUI(performMove(1, 1));

            }
        });

        Button player1Bowl2 = (Button) findViewById(R.id.player1bowl2);
        player1Bowl2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 2);
                UpdateUI(performMove(1, 2));


            }
        });

        Button player1Bowl3 = (Button) findViewById(R.id.player1bowl3);
        player1Bowl3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 3);
                UpdateUI(performMove(1, 3));

            }
        });

        Button player1Bowl4 = (Button) findViewById(R.id.player1bowl4);
        player1Bowl4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 4);
                UpdateUI(performMove(1, 4));

            }
        });

        Button player1Bowl5 = (Button) findViewById(R.id.player1bowl5);
        player1Bowl5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 5);
                UpdateUI(performMove(1, 5));

            }
        });

        Button player1tray1 = (Button) findViewById(R.id.player1tray1);
        player1tray1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 6);
                UpdateUI(performMove(1, 1));

            }
        });


        Button player2Bowl1 = (Button) findViewById(R.id.player2bowl1);
        player2Bowl1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 7);
                UpdateUI(performMove(2, 1));

            }
        });

        Button player2Bowl2 = (Button) findViewById(R.id.player2bowl2);
        player2Bowl2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 8);
                UpdateUI(performMove(2, 2));

            }
        });

        Button player2Bowl3 = (Button) findViewById(R.id.player2bowl3);
        player2Bowl3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 9);
                UpdateUI(performMove(2, 3));

            }
        });

        Button player2Bowl4 = (Button) findViewById(R.id.player2bowl4);
        player2Bowl4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 10);
                UpdateUI(performMove(2, 4));

            }
        });

        Button player2Bowl5 = (Button) findViewById(R.id.player2bowl5);
        player2Bowl5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 11);
                UpdateUI(performMove(2, 5));

            }
        });

        Button player2tray2 = (Button) findViewById(R.id.player2tray2);
        player2tray2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame( 12);
                UpdateUI(performMove(2, 2));

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
}
