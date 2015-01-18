package polimi.mancala;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import java.util.HashMap;
import java.util.Map;
import android.app.AlertDialog;

/**
 * Created by Giacomo Bianchini on 21/11/2014
 */

public class MatchActivity extends Activity {

    MatchHandler game = MatchHandler.getMatchHandler(this);
    final Map<Button, Integer> myMap = new HashMap<Button, Integer>();
    Preferences settings = Preferences.getPreferences();



    @Override
    protected void onCreate (Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_match);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        View.OnClickListener clickListener = new View.OnClickListener() {
            public void onClick(View v) {
                game.playTheGame(myMap.get(v));
                UpdateUIValues();
                CheckGameFinished();
            }
        };


        Button player2bowl6 = (Button) findViewById(R.id.player2bowl6);
        player2bowl6.setOnClickListener(clickListener);

        Button player2bowl5 = (Button) findViewById(R.id.player2bowl5);
        player2bowl5.setOnClickListener(clickListener);

        Button player2bowl4 = (Button) findViewById(R.id.player2bowl4);
        player2bowl4.setOnClickListener(clickListener);

        Button player2bowl3 = (Button) findViewById(R.id.player2bowl3);
        player2bowl3.setOnClickListener(clickListener);

        Button player2bowl2 = (Button) findViewById(R.id.player2bowl2);
        player2bowl2.setOnClickListener(clickListener);

        Button player1Bowl6 = (Button) findViewById(R.id.player1bowl6);
        player1Bowl6.setOnClickListener(clickListener);

        Button player2tray2 = (Button) findViewById(R.id.player2tray2);
        player2tray2.setOnClickListener(clickListener);

        Button player1bowl1 = (Button) findViewById(R.id.player1bowl1);
        player1bowl1.setOnClickListener(clickListener);

        Button player1bowl2 = (Button) findViewById(R.id.player1bowl2);
        player1bowl2.setOnClickListener(clickListener);

        Button player1bowl3 = (Button) findViewById(R.id.player1bowl3);
        player1bowl3.setOnClickListener(clickListener);

        Button player1bowl4 = (Button) findViewById(R.id.player1bowl4);
        player1bowl4.setOnClickListener(clickListener);

        Button player1bowl5 = (Button) findViewById(R.id.player1bowl5);
        player1bowl5.setOnClickListener(clickListener);

        Button player2bowl1 = (Button) findViewById(R.id.player2bowl1);
        player2bowl1.setOnClickListener(clickListener);

        Button player1tray1 = (Button) findViewById(R.id.player1tray1);
        player1tray1.setOnClickListener(clickListener);


        myMap.put(player1bowl1, 0);
        myMap.put(player1bowl2, 1);
        myMap.put(player1bowl3, 2);
        myMap.put(player1bowl4, 3);
        myMap.put(player1bowl5, 4);
        myMap.put(player1Bowl6, 5);
        myMap.put(player1tray1, 6);
        myMap.put(player2bowl1, 7);
        myMap.put(player2bowl2, 8);
        myMap.put(player2bowl3, 9);
        myMap.put(player2bowl4, 10);
        myMap.put(player2bowl5, 11);
        myMap.put(player2bowl6, 12);
        myMap.put(player2tray2, 13);

        Log.i("matchactivity", "this is an output");
        game.beginMatch();

        UpdateUIValues();
    }


    private void performAiMove() {
        DisablePlayerWithId(game.player1.getId());
        DisablePlayerWithId(game.player2.getId());
        game.aIMove();
        EnablePlayerWithId(game.player1.getId());
        EnablePlayerWithId(game.player2.getId());
        UpdateUIValues();
    }

    private boolean isSinglePlayerGame() {
        if (this.settings.isHumanComputerGame())
            return true;
        else
            return false;
    }

    //find drawables for player1 by number of seeds
    private int getDrawable1(int numSeed) {

        switch (numSeed){
            case 0: return R.drawable.one00;
            case 1: return R.drawable.one01;
            case 2: return R.drawable.one02;
            case 3: return R.drawable.one03;
            case 4: return R.drawable.one04;
            case 5: return R.drawable.one05;
            case 6: return R.drawable.one06;
            case 7: return R.drawable.one07;
            case 8: return R.drawable.one08;
            case 9: return R.drawable.one09;
            case 10: return R.drawable.one10;
            case 11: return R.drawable.one11;
            case 12: return R.drawable.one12;
            case 13: return R.drawable.one13;
            case 14: return R.drawable.one14;
            case 15: return R.drawable.one15;
            default: return R.drawable.one00;

        }}


    //find drawables for player2 by number of seeds
    private int getDrawable2(int numSeed) {
        switch (numSeed){
            case 0: return R.drawable.two00;
            case 1: return R.drawable.two01;
            case 2: return R.drawable.two02;
            case 3: return R.drawable.two03;
            case 4: return R.drawable.two04;
            case 5: return R.drawable.two05;
            case 6: return R.drawable.two06;
            case 7: return R.drawable.two07;
            case 8: return R.drawable.two08;
            case 9: return R.drawable.two09;
            case 10: return R.drawable.two10;
            case 11: return R.drawable.two11;
            case 12: return R.drawable.two12;
            case 13: return R.drawable.two13;
            case 14: return R.drawable.two14;
            case 15: return R.drawable.two15;
            default: return R.drawable.two00;
        }
    }


    //find drawables for trays
    private int getDrawableTrays(int numSeed) {
        switch (numSeed) {
            case 0:
                return R.drawable.s00;
            case 1:
                return R.drawable.s01;
            case 2:
                return R.drawable.s02;
            case 3:
                return R.drawable.s03;
            case 4:
                return R.drawable.s04;
            case 5:
                return R.drawable.s05;
            case 6:
                return R.drawable.s06;
            case 7:
                return R.drawable.s07;
            case 8:
                return R.drawable.s08;
            case 9:
                return R.drawable.s09;
            case 10:
                return R.drawable.s10;
            case 11:
                return R.drawable.s11;
            case 12:
                return R.drawable.s12;
            case 13:
                return R.drawable.s13;
            case 14:
                return R.drawable.s14;
            case 15:
                return R.drawable.s15;
            case 16:
                return R.drawable.s16;
            case 17:
                return R.drawable.s17;
            case 18:
                return R.drawable.s18;
            case 19:
                return R.drawable.s19;
            case 20:
                return R.drawable.s20;
            case 21:
                return R.drawable.s21;
            case 22:
                return R.drawable.s22;
            case 23:
                return R.drawable.s23;
            case 24:
                return R.drawable.s24;
            case 25:
                return R.drawable.s25;
            case 26:
                return R.drawable.s26;
            case 27:
                return R.drawable.s27;
            case 28:
                return R.drawable.s28;
            case 29:
                return R.drawable.s29;
            case 30:
                return R.drawable.s30;
            case 31:
                return R.drawable.s31;
            case 32:
                return R.drawable.s32;
            case 33:
                return R.drawable.s33;
            case 34:
                return R.drawable.s34;
            case 35:
                return R.drawable.s35;
            case 36:
                return R.drawable.s36;
            default:
                return R.drawable.s00;
        }
    }

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
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("THE END");
            int winner = game.getWinner();
            switch (winner){
                case 0: alertDialog.setMessage("It Is A Tie!");
                    break;
                case 1: alertDialog.setMessage("Player ONE Won!");
                    break;
                case 2: alertDialog.setMessage("Player Two Won!");
                    break;
                default: alertDialog.setMessage("A Problem has been encountered!");
                    break;
            }

           alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                            goToMain();
                        }
                    });

            alertDialog.setIcon(R.drawable.logo);
            alertDialog.show();
        }
    }

    public void goToMain() {
        Intent intentmain = new Intent(this, MainActivity.class);
        startActivity((intentmain));
    }

    private void UpdateUIValues() {

        int [] state = game.getActualBoard();
        Button player1bowl1 = (Button) findViewById(R.id.player1bowl1);
        player1bowl1.setBackgroundResource(getDrawable1(state[0]));

        Button player1bowl2 = (Button) findViewById(R.id.player1bowl2);
        player1bowl2.setBackgroundResource(getDrawable1(state[1]));

        Button player1bowl3 = (Button) findViewById(R.id.player1bowl3);
        player1bowl3.setBackgroundResource(getDrawable1(state[2]));

        Button player1bowl4 = (Button) findViewById(R.id.player1bowl4);
        player1bowl4.setBackgroundResource(getDrawable1(state[3]));

        Button player1bowl5 = (Button) findViewById(R.id.player1bowl5);
        player1bowl5.setBackgroundResource(getDrawable1(state[4]));

        Button player1bowl6 = (Button) findViewById(R.id.player1bowl6);
        player1bowl6.setBackgroundResource(getDrawable1(state[5]));

        Button player1tray1 = (Button) findViewById(R.id.player1tray1);
        player1tray1.setBackgroundResource(getDrawableTrays(state[6]));

        Button player2bowl1 = (Button) findViewById(R.id.player2bowl1);
        player2bowl1.setBackgroundResource(getDrawable2(state[7]));

        Button player2bowl2 = (Button) findViewById(R.id.player2bowl2);
        player2bowl2.setBackgroundResource(getDrawable2(state[8]));

        Button player2bowl3 = (Button) findViewById(R.id.player2bowl3);
        player2bowl3.setBackgroundResource(getDrawable2(state[9]));

        Button player2bowl4 = (Button) findViewById(R.id.player2bowl4);
        player2bowl4.setBackgroundResource(getDrawable2(state[10]));

        Button player2bowl5 = (Button) findViewById(R.id.player2bowl5);
        player2bowl5.setBackgroundResource(getDrawable2(state[11]));

        Button player2bowl6 = (Button) findViewById(R.id.player2bowl6);
        player2bowl6.setBackgroundResource(getDrawable2(state[12]));

        Button player2tray2 = (Button) findViewById(R.id.player2tray2);
        player2tray2.setBackgroundResource(getDrawableTrays(state[13]));

        Button turnPlayer1 = (Button) findViewById(R.id.turnPlayer1);
        Button turnPlayer2 = (Button) findViewById(R.id.turnPlayer2);
        if (game.getActivePlayerId().equals(1)) {
            turnPlayer1.setBackgroundResource(R.drawable.greenturn);
            turnPlayer2.setBackgroundResource(R.drawable.redturn);
        }
        else {
            turnPlayer1.setBackgroundResource(R.drawable.redturn);
            turnPlayer2.setBackgroundResource(R.drawable.greenturn);
        }

        if (isSinglePlayerGame() && game.checkIfAIMove()) {
            performAiMove();
        }
    }

}