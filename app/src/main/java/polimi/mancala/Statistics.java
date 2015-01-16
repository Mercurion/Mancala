package polimi.mancala;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import java.io.File;

/**
 * @author Giacomo bianchini
 */
public class Statistics {

    File path;
    private SharedPreferences prefs;


    public void Statistics (Context ctx) {
        prefs = ctx.getSharedPreferences("", Context.MODE_PRIVATE); //todo: set the string to app name
    }

    public int maxScore;
    public int gamePlayed;

    public void setPrefs(String key, String value) {
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

    public String getPrefs(String key, String value) {
        return prefs.getString(key, value);
    }

    public void removePrefs(String key) {
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.remove(key);
        prefsEditor.commit();
    }

    //TODO: perform setter and getter using a file

    public int getMax (){
        return this.maxScore;
    }

    //TODO: has to be done with a pathfile
    public void setMax (int value) {
        this.maxScore = value;
    }

    public int getGamePlayed () {
        return this.gamePlayed;
    }

    public void setGamePlayed (int value) {
        this.gamePlayed = value;
    }

    public void oneMorePlayed () {
        //TODO: here has to be set that the game played value will be increased by one
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

}
