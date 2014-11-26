package polimi.mancala;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by Giacomo Bianchini on 21/11/2014.
 *
 */

public class MatchActivity extends Activity {

    MatchHandler game = new MatchHandler();

    @Override
    protected void onCreate (Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_match);
        /*
        delete the next string
         */
        Log.i("matchactivity", "this is an output");
        this.game.beginMatch();
        this.game.playGame();
    }

    public void bowlclicked (View v) {

    }
    /* this is a comment */
}
