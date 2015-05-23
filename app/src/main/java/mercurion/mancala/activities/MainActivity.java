package mercurion.mancala.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import mercurion.mancala.R;


public class MainActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        Button playButton = (Button) findViewById(R.id.playbutton);
        playButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                startMatch(v);

            }
        });

        Button stat = (Button) findViewById(R.id.statistics);
        stat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                goToStat(v);


            }
        });


        Button settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /* Do something in response to button click */
                    gotosettings(v);
                            }


            });
    }

    public void gotosettings(View view) {
        Intent intentsettings = new Intent(this, SettingsActivity.class);
        startActivity((intentsettings));
    }


    public void goToStat(View view) {
        Intent intentStat = new Intent(this, StatisticsActivity.class);
        startActivity(intentStat);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void startMatch (View view){
        Intent intentNewMatch = new Intent(this, MatchActivity.class);
        startActivity(intentNewMatch);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (SettingsActivity.musicService != null){
            stopService(SettingsActivity.musicService);
        }
    }

}
