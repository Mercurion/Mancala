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
import android.widget.TextView;

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
        final Button animButt = (Button) findViewById(R.id.animButton);
        final TextView text = (TextView) findViewById(R.id.textView);
        int x = 0;
//        x = text.getHeight();
        int y = 0;
//        y = text.getWidth();
        final Animation traslation = new TranslateAnimation(x, x+100, y, y+100);
        traslation.setDuration(2000);
        traslation.getFillAfter();

        animButt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                text.startAnimation(traslation);
            }
        });
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
