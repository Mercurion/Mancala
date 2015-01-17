package polimi.mancala;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jack on 26/11/2014.
 *
 * this is the activity to show all the statistics
 *
 */
public class StatisticsActivity extends Activity{


    Integer maxScore;
    Integer gamePlayed;
    Statistics stat = new Statistics();
    Button goHome = (Button) findViewById(R.id.goHomeButton);
    Button resetButton = (Button) findViewById(R.id.resetButton);
    TextView textGamePlayed = (TextView) findViewById(R.id.textView);
    TextView textMaxScore = (TextView) findViewById(R.id.textView2);

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

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

//        this.gamePlayed = stat.getGamePlayed();
//        this.maxScore = stat.getMaxScore();
//        updateText();
    }


    private void updateText () {
        textGamePlayed.setText(gamePlayed);
        textMaxScore.setText(gamePlayed);
    }

    public void goBack (View v) {
        Intent comeback = new Intent(this, MainActivity.class);
        startActivity(comeback);
    }

    public void reset () {
        stat.resetAll();
        this.gamePlayed = stat.getGamePlayed();
        this.maxScore = stat.getMaxScore();
        updateText();
    }
}
