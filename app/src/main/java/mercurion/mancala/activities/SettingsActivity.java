package mercurion.mancala.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ToggleButton;

import mercurion.mancala.MusicService;
import mercurion.mancala.Preferences;
import mercurion.mancala.PreferencesActivity;
import mercurion.mancala.R;
import mercurion.mancala.activities.MainActivity;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

/**
 * Created by Roxana on 15/01/15.
 */
public class SettingsActivity extends Activity{

    ToggleButton t;
    public static Intent musicService;
    Boolean musicStatus;
    Preferences settings = Preferences.getPreferences();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setRequestedOrientation(SCREEN_ORIENTATION_LANDSCAPE);
        LoadPreferences();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Button goHome = (Button) findViewById(R.id.goHomeButton1);
        goHome.setBackgroundResource(R.drawable.homebutton);
        goHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goHome();
            }
        });

        Button multiPlayerButton = (Button) findViewById(R.id.multiPlayerButton);
        if (settings.isHumanComputerGame())
            multiPlayerButton.setBackgroundResource(R.drawable.oneplayergame);
        else
            multiPlayerButton.setBackgroundResource(R.drawable.twoplayergame);

        multiPlayerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                swapTypeOfGame(v);

            }
        });


        t = (ToggleButton) findViewById(R.id.toggleButtonMusic);
        t.setChecked(musicStatus);
        t.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            boolean on = ((ToggleButton) v).isChecked();
            if (on) {
                SetMusic(true);
            } else {
                SetMusic(false);}
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

    private void swapTypeOfGame (View v) {
        if (settings.isHumanComputerGame())
            settings.setHumanComputerGame(false);
        else
            settings.setHumanComputerGame(true);

        Button multiPlayerButton = (Button) findViewById(R.id.multiPlayerButton);
        if (settings.isHumanComputerGame())
            multiPlayerButton.setBackgroundResource(R.drawable.oneplayergame);
        else
            multiPlayerButton.setBackgroundResource(R.drawable.twoplayergame);
    }

    private void goHome () {
        Intent comeback = new Intent(this, MainActivity.class);
        startActivity(comeback);
    }
}