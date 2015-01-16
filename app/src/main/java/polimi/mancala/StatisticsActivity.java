package polimi.mancala;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jack on 26/11/2014.
 *
 * this is the activity to show all the statistics
 *
 */
public class StatisticsActivity extends Activity {


    private Integer maxScore;
    private Integer gamePlayed;
    Statistics stat;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Button goHome = (Button) findViewById(R.id.goHomeButton);
        final TextView text = (TextView) findViewById(R.id.textView);

        goHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goBack(v);
            }
        });
    }


    public void goBack (View v) {
        Intent comeback = new Intent(this, MainActivity.class);
        startActivity(comeback);
    }

    public void reset () {
        stat.resetAll();
    }
}
