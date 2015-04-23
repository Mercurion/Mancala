package mercurion.mancala;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * Created by Roxana on 12/01/15.
 */
public class PreferencesActivity extends Activity{

    public static final String MUSIC = "MUSIC";
    SharedPreferences defaultSharedPreferences;

    public PreferencesActivity(Context context){
        defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public Boolean GetMusicStatus(){
        if (defaultSharedPreferences.contains(MUSIC)){
            return defaultSharedPreferences.getBoolean(MUSIC, false);
        }
        return false;
    }

    public void SetMusicStatus(Boolean status){
        SharedPreferences.Editor editor = defaultSharedPreferences.edit();
        editor.putBoolean(MUSIC, status);
        editor.commit();
    }


}
