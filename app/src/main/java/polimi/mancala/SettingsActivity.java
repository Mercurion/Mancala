package polimi.mancala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

/**
 * Created by Roxana on 15/01/15.
 */
public class SettingsActivity extends Activity{

    ToggleButton t;
    Intent musicService;
    Boolean musicStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);


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

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (musicService != null){
            stopService(musicService);
        }
    }}