package polimi.mancala;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

/**
 * Created by jack on 26/11/2014.
 *
 * this is the activity to show all the statistics
 *
 */
public class StatisticsActivity extends Activity {


    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Button goHome = (Button) findViewById(R.id.goHomeButton);
        int x = 0;
        int y = 0;
        Animation traslation = new TranslateAnimation(x, x+3, y, y+3);

        goHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                goBack(v);
            }
        });
    }

    public void goBack (View v) {
        Intent comeback = new Intent(this, MainActivity.class);
        startActivity(comeback);

    }
}
