package polimi.mancala;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;


/**
 * Created by Giacomo Bianchini on 21/11/2014
 */

public class MatchActivity extends Activity {

    MatchHandler game = MatchHandler.getMatchHandler();
    final Map<Button, Integer> myMap = new HashMap<Button, Integer>();

    //find drawables for player1 by number of seeds
    private Drawable getdrawable1 (int numSeed) {

        switch (numSeed){
            case 0: return Drawable.createFromPath("one00.png");
            case 1: return Drawable.createFromPath("one01.png");
            case 2: return Drawable.createFromPath("one02.png");
            case 3: return Drawable.createFromPath("one03.png");
            case 4: return Drawable.createFromPath("one04.png");
            case 5: return Drawable.createFromPath("one05.png");
            case 6: return Drawable.createFromPath("one06.png");
            case 7: return Drawable.createFromPath("one07.png");
            case 8: return Drawable.createFromPath("one08.png");
            case 9: return Drawable.createFromPath("one09.png");
            case 10: return Drawable.createFromPath("one10.png");
            case 11: return Drawable.createFromPath("one11.png");
            case 12: return Drawable.createFromPath("one12.png");
            case 13: return Drawable.createFromPath("one13.png");
            case 14: return Drawable.createFromPath("one14.png");
            case 15: return Drawable.createFromPath("one15.png");
            default: return Drawable.createFromPath("one00.png");

        }}


    //find drawables for player2 by number of seeds
    private Drawable getdrawable2(int numSeed) {

        switch (numSeed){
            case 0: return Drawable.createFromPath("two00.png");
            case 1: return Drawable.createFromPath("two01.png");
            case 2: return Drawable.createFromPath("two02.png");
            case 3: return Drawable.createFromPath("two03.png");
            case 4: return Drawable.createFromPath("two04.png");
            case 5: return Drawable.createFromPath("two05.png");
            case 6: return Drawable.createFromPath("two06.png");
            case 7: return Drawable.createFromPath("two07.png");
            case 8: return Drawable.createFromPath("two08.png");
            case 9: return Drawable.createFromPath("two09.png");
            case 10: return Drawable.createFromPath("two10.png");
            case 11: return Drawable.createFromPath("two11.png");
            case 12: return Drawable.createFromPath("two12.png");
            case 13: return Drawable.createFromPath("two13.png");
            case 14: return Drawable.createFromPath("two14.png");
            case 15: return Drawable.createFromPath("two15.png");
            default: return Drawable.createFromPath("two00.png");

    }}


    //find drawables for trays
    private Drawable getdrawable3(int numSeed) {
        switch (numSeed) {
            case 0:
                return Drawable.createFromPath("two00.png");
            case 1:
                return Drawable.createFromPath("two01.png");
            case 2:
                return Drawable.createFromPath("two02.png");
            case 3:
                return Drawable.createFromPath("two03.png");
            case 4:
                return Drawable.createFromPath("two04.png");
            case 5:
                return Drawable.createFromPath("two05.png");
            case 6:
                return Drawable.createFromPath("two06.png");
            case 7:
                return Drawable.createFromPath("two07.png");
            case 8:
                return Drawable.createFromPath("two08.png");
            case 9:
                return Drawable.createFromPath("two09.png");
            case 10:
                return Drawable.createFromPath("two10.png");
            case 11:
                return Drawable.createFromPath("two11.png");
            case 12:
                return Drawable.createFromPath("two12.png");
            case 13:
                return Drawable.createFromPath("two13.png");
            case 14:
                return Drawable.createFromPath("two14.png");
            case 15:
                return Drawable.createFromPath("two15.png");
            case 16:
                return Drawable.createFromPath("two15.png");
            case 17:
                return Drawable.createFromPath("two15.png");
            case 18:
                return Drawable.createFromPath("two15.png");
            case 19:
                return Drawable.createFromPath("two15.png");
            case 20:
                return Drawable.createFromPath("two15.png");
            case 21:
                return Drawable.createFromPath("two15.png");
            case 22:
                return Drawable.createFromPath("two15.png");
            case 23:
                return Drawable.createFromPath("two15.png");
            case 24:
                return Drawable.createFromPath("two15.png");
            case 25:
                return Drawable.createFromPath("two15.png");
            case 26:
                return Drawable.createFromPath("two15.png");
            case 27:
                return Drawable.createFromPath("two15.png");
            case 28:
                return Drawable.createFromPath("two15.png");
            case 29:
                return Drawable.createFromPath("two15.png");
            case 30:
                return Drawable.createFromPath("two15.png");
            case 31:
                return Drawable.createFromPath("two15.png");
            case 32:
                return Drawable.createFromPath("two15.png");
            case 33:
                return Drawable.createFromPath("two15.png");
            case 34:
                return Drawable.createFromPath("two15.png");
            case 35:
                return Drawable.createFromPath("two15.png");
            case 36:
                return Drawable.createFromPath("two15.png");
            default:
                return Drawable.createFromPath("two00.png");
        }}




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

                Log.i("matchactivity", "this is an output");
                game.beginMatch();


            }


            private void UpdateUIValues() {
                int [] state = game.getActualBoard();
                Button player1bowl1 = (Button) findViewById(R.id.player1bowl1);
                player1bowl1.setBackground(getdrawable1(state[0]));

                Button player1bowl2 = (Button) findViewById(R.id.player1bowl2);
                player1bowl2.setBackground(getdrawable1(state[1]));

                Button player1bowl3 = (Button) findViewById(R.id.player1bowl3);
                player1bowl3.setBackground(getdrawable1(state[2]));

                Button player1bowl4 = (Button) findViewById(R.id.player1bowl4);
                player1bowl4.setBackground(getdrawable1(state[3]));

                Button player1bowl5 = (Button) findViewById(R.id.player1bowl5);
                player1bowl5.setBackground(getdrawable1(state[4]));

                Button player1bowl6 = (Button) findViewById(R.id.player1bowl6);
                player1bowl6.setBackground(getdrawable1(state[5]));

                Button player1tray1 = (Button) findViewById(R.id.player1tray1);
                player1tray1.setBackground(getdrawable3(state[6]));

                Button player2bowl1 = (Button) findViewById(R.id.player2bowl1);
                player2bowl1.setBackground(getdrawable2(state[7]));

                Button player2bowl2 = (Button) findViewById(R.id.player2bowl2);
                player2bowl2.setBackground(getdrawable2(state[8]));

                Button player2bowl3 = (Button) findViewById(R.id.player2bowl3);
                player2bowl3.setBackground(getdrawable2(state[9]));

                Button player2bowl4 = (Button) findViewById(R.id.player2bowl4);
                player2bowl4.setBackground(getdrawable2(state[10]));


                Button player2bowl5 = (Button) findViewById(R.id.player2bowl5);
                player2bowl5.setBackground(getdrawable2(state[11]));

                Button player2bowl6 = (Button) findViewById(R.id.player2bowl6);
                player2bowl6.setBackground(getdrawable2(state[12]));

                Button player2tray2 = (Button) findViewById(R.id.player2tray2);
                player2tray2.setBackground(getdrawable3(state[13]));
            }




        }


