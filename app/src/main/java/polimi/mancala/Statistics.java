package polimi.mancala;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * @author Giacomo bianchini
 */
public class Statistics {

    File path;

    public void Statistics () {
        /* TODO: INSERT SOMETHING LIKE this.maxscore = setMax(default path to file) */
        this.path = Environment.getExternalStorageDirectory();
        if (!path.exists())
            try {
                path.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public int maxScore;
    public int gamePlayed;

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
