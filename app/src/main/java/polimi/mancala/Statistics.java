package polimi.mancala;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * @author Giacomo bianchini
 */
public class Statistics {

    private SharedPreferences prefs;
    private String playedGame = "playedGame";
    private String bestScore = "MaxScore";



    public  Statistics (Context ctx) {
        prefs = ctx.getSharedPreferences("Mancala", Context.MODE_PRIVATE); //todo: set the string to app name

    }


    private void setPrefs(String key, int value) {
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.commit();
    }

    private int getPrefs(String key) {
        int value =0;
        return prefs.getInt(key, value);
    }

    private void removePrefs(String key) {
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.remove(key);
        prefsEditor.commit();
    }

    public int getMaxScore(){
        return getPrefs(bestScore);
    }

    private void setMaxScore(int value) {
        setPrefs(bestScore, value);
    }

    public int getGamePlayed () {
        return getPrefs(playedGame);
    }

    public void setGamePlayed (int value) {
        setPrefs(playedGame, value);
    }

    public void updateBestScore (int value) {
        if (value > getMaxScore())
            setMaxScore(value);
    }

    public void addOneGamePlayed () {
        int i = getGamePlayed();
        setGamePlayed(i+1);
    }

    public void resetAll () {
        setGamePlayed(0);
        setMaxScore(0);
    }

}
