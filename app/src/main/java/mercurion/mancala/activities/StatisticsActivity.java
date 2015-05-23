package mercurion.mancala.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import android.widget.Button;

import mercurion.mancala.R;
import mercurion.mancala.Statistics;
import mercurion.mancala.activities.MainActivity;

/**
 * Created by jack on 26/11/2014.
 *
 * this is the activity to show all the statistics
 *
 */
public class StatisticsActivity extends Activity{



    Integer maxScore =0;
    Integer gamePlayed;
    Statistics stat;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Button goHome = (Button) findViewById(R.id.goHomeButton);
        Button resetButton = (Button) findViewById(R.id.resetButton);
        Button scoreButton = (Button) findViewById(R.id.bestScoreButton);
        Button gamePlayedButton = (Button) findViewById(R.id.gamePlayedButton);

        stat = Statistics.getStatistics(this);

        goHome.setBackgroundResource(R.drawable.homebutton);
        resetButton.setBackgroundResource(R.drawable.resetbutton);
        goHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goBack(v);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reset();
            }
        });

        this.gamePlayed = stat.getGamePlayed();
        this.maxScore = stat.getMaxScore();
        updateText();
    }


    private void updateText () {
        Button scoreButton = (Button) findViewById(R.id.bestScoreButton);
        Button gamePlayedButton = (Button) findViewById(R.id.gamePlayedButton);
        this.gamePlayed = stat.getGamePlayed();
        this.maxScore = stat.getMaxScore();
        scoreButton.setText(maxScore.toString());
        gamePlayedButton.setText(gamePlayed.toString());
    }

    private void goBack (View v) {
        Intent comeback = new Intent(this, MainActivity.class);
        startActivity(comeback);
    }

    private void reset () {
        stat.resetAll();
        this.gamePlayed = stat.getGamePlayed();
        this.maxScore = stat.getMaxScore();
        updateText();
    }

}
