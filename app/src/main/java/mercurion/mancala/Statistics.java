package mercurion.mancala;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;


/**
 * @author Giacomo Bianchini
 *
 */
public class Statistics extends Activity {

    String game = "gamePlayed";
    String score = "maxScore";
    public static final String PREFNAME = "MY_PREF";
    private static Statistics instance = null;
    Context cont;


    public static synchronized Statistics getStatistics (Context ctx) {
        if (instance == null)
            instance = new Statistics(ctx);
        return instance;
    }

    private Statistics (Context ctx) {
        this.cont = ctx;
    }

    public static synchronized Statistics getStatistics () {
        if (instance == null)
            instance = new Statistics();
        return instance;
    }

    private Statistics () {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public int getGamePlayed() {
        SharedPreferences statistics = cont.getSharedPreferences(PREFNAME, MODE_PRIVATE);
        return statistics.getInt(game, 0);
    }

    public int getMaxScore () {
        SharedPreferences statistics = cont.getSharedPreferences(PREFNAME, MODE_PRIVATE);
        return statistics.getInt(score, 0);
    }


    public void resetAll () {
        SharedPreferences statistics = cont.getSharedPreferences(PREFNAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = statistics.edit();
        editor.putInt(game,0 );
        editor.putInt(score, 0);
        editor.commit();
    }

    public void setMaxScore (int value) {
        SharedPreferences.Editor editor = cont.getSharedPreferences(PREFNAME, MODE_PRIVATE).edit();
        editor.putInt(score, value);
        editor.commit();
    }

    public void updateMaxScore (int value) {
        if (value > getMaxScore())
            setMaxScore(value);
    }

    public void setGamePlayed (int value) {
        SharedPreferences.Editor editor = cont.getSharedPreferences(PREFNAME, MODE_PRIVATE).edit();
        editor.putInt(game, value);
        editor.commit();
    }

    public void oneMorePlayed () {
        setGamePlayed(getGamePlayed()+1);
    }

}
