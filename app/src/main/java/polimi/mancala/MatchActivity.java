package polimi.mancala;

import android.app.Activity;
import android.content.pm.ActivityInfo;
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
    final Map<Button, Integer> myMap = new HashMap<Button, Integer>();


    private void ChangePlayer(){
        int currentPlayerId = game.getActivePlayerId();
        ChangePlayer(currentPlayerId);


    }

    private void ChangePlayer(int currentPlayerId) {
        EnablePlayerWithId(currentPlayerId);
        DisablePlayerWithId(currentPlayerId);
    }

    private void DisablePlayerWithId(int currentPlayerId) {
        for (Map.Entry<Button, Integer> entry : myMap.entrySet()) {
            if(currentPlayerId == 1){
                if (entry.getValue() >= 1 && entry.getValue() <= 7)
                    (entry.getKey()).setEnabled(false);
                else break;
            }
            else if (currentPlayerId == 2){
                if (entry.getValue() >= 8 && entry.getValue() <= 14)
                    (entry.getKey()).setEnabled(false);
                else break;
            }

         }
    }

    private void EnablePlayerWithId(int currentPlayerId) {
        for (Map.Entry<Button, Integer> entry : myMap.entrySet()) {
            if(currentPlayerId == 1){
                if (entry.getValue() >= 1 && entry.getValue() <= 7)
                    (entry.getKey()).setEnabled(true);
                else break;
            }
            else if (currentPlayerId == 2){
                if (entry.getValue() >= 8 && entry.getValue() <= 14)
                    (entry.getKey()).setEnabled(true);
                else break;
            }

        }
    }

    private void CheckGameFinished() {
        if (game.isFinished()){
            //Show some dialog etc
        }
    }

    @Override
    protected void onCreate (Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_match);





        View.OnClickListener clickListener = new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame(myMap.get(v));
                ChangePlayer();
                CheckGameFinished();
            }
        };




        Button player1Bowl1 = (Button) findViewById(R.id.player1bowl1);
        player1Bowl1.setOnClickListener(clickListener);

        Button player1Bowl2 = (Button) findViewById(R.id.player1bowl2);
        player1Bowl2.setOnClickListener(clickListener);

        Button player1Bowl3 = (Button) findViewById(R.id.player1bowl3);
        player1Bowl3.setOnClickListener(clickListener);

        Button player1Bowl4 = (Button) findViewById(R.id.player1bowl4);
        player1Bowl4.setOnClickListener(clickListener);

        Button player1Bowl5 = (Button) findViewById(R.id.player1bowl5);
        player1Bowl5.setOnClickListener(clickListener);

        Button player1Bowl6 = (Button) findViewById(R.id.player1bowl6);
        player1Bowl6.setOnClickListener(clickListener);

        Button player1tray1 = (Button) findViewById(R.id.player1tray1);
        player1tray1.setOnClickListener(clickListener);

        Button player2Bowl1 = (Button) findViewById(R.id.player2bowl1);
        player2Bowl1.setOnClickListener(clickListener);

        Button player2Bowl2 = (Button) findViewById(R.id.player2bowl2);
        player2Bowl2.setOnClickListener(clickListener);

        Button player2Bowl3 = (Button) findViewById(R.id.player2bowl3);
        player2Bowl3.setOnClickListener(clickListener);

        Button player2Bowl4 = (Button) findViewById(R.id.player2bowl4);
        player2Bowl4.setOnClickListener(clickListener);

        Button player2Bowl5 = (Button) findViewById(R.id.player2bowl5);
        player2Bowl5.setOnClickListener(clickListener);

        Button player2Bowl6 = (Button) findViewById(R.id.player2bowl6);
        player2Bowl6.setOnClickListener(clickListener);

        Button player2tray2 = (Button) findViewById(R.id.player2tray2);
        player2tray2.setOnClickListener(clickListener);

        myMap.put(player1Bowl1, 1);
        myMap.put(player1Bowl2, 2);
        myMap.put(player1Bowl3, 3);
        myMap.put(player1Bowl4, 4);
        myMap.put(player1Bowl5, 5);
        myMap.put(player1Bowl6, 6);
        myMap.put(player1tray1, 7);
        myMap.put(player2Bowl1, 8);
        myMap.put(player2Bowl2, 9);
        myMap.put(player2Bowl3, 10);
        myMap.put(player2Bowl4, 11);
        myMap.put(player2Bowl5, 12);
        myMap.put(player2Bowl6, 13);
        myMap.put(player2tray2, 14);



        /*
        delete the next string
         */

                Log.i("matchactivity", "this is an output");
                game.beginMatch();


            }





            private void UpdateUIValues() {
                Button player1bowl1 = (Button) findViewById(R.id.player1bowl1);
                player1bowl1.setText("" + getCurrentValue(1, 1));
                Button player1bowl2 = (Button) findViewById(R.id.player1bowl2);
                player1bowl2.setText("" + getCurrentValue(1, 2));
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

