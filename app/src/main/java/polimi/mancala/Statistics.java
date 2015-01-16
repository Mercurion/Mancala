package polimi.mancala;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;


/**
 * @author Giacomo bianchini
 */
public class Statistics {

    private SharedPreferences prefs;
    public int maxScore;
    public int gamePlayed;
    private String playedGame = "playedGame";
    private String bestScore = "MaxScore";

    public void Statistics (Context ctx) {
        prefs = ctx.getSharedPreferences("Mancala", Context.MODE_PRIVATE); //todo: set the string to app name

    }


    public void setPrefs(String key, int value) {
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.commit();
    }

    public int getPrefs(String key) {
        int value =0;
        return prefs.getInt(key, value);
    }

    public void removePrefs(String key) {
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.remove(key);
        prefsEditor.commit();
    }

    public int getMax (){
        return this.maxScore;
    }

    //TODO: has to be done with a pathfile
    public void setMax (int value) {
        this.maxScore = value;
        setPrefs(bestScore, maxScore);
    }

    public int getGamePlayed () {
        return getPrefs(playedGame);
    }

    public void setGamePlayed (int value) {
        this.gamePlayed = value;
        setPrefs(playedGame, gamePlayed);
    }

    public void oneMorePlayed () {
        this.gamePlayed++;
    }


}
