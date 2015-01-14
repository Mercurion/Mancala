package polimi.mancala;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;


public class MainActivity extends Activity{

    ToggleButton t;
    Intent musicService;
    Boolean musicStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        LoadPreferences();

        t = (ToggleButton) findViewById(R.id.togglebutton);
        t.setChecked(musicStatus);
        t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean on = ((ToggleButton) v).isChecked();
                if (on) {
                    SetMusic(true);
                } else {
                    SetMusic(false);
                }

            }
        });

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
    }

    private void LoadPreferences() {
        PreferencesActivity preferences = new PreferencesActivity(getApplicationContext());
        musicStatus = preferences.GetMusicStatus();
        SetMusic(musicStatus);
    }

    private void SetMusic(Boolean status) {
        if (musicService == null)
            musicService=new Intent(this, MusicService.class);
        if (status) startService(musicService);
        else stopService(musicService);
        UpdatePreferences(status);
    }

    private void UpdatePreferences(Boolean status){
        PreferencesActivity preferences = new PreferencesActivity(getApplicationContext());
        musicStatus = status;
        preferences.SetMusicStatus(musicStatus);
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
        if (musicService != null){
            stopService(musicService);
        }
    }

}
