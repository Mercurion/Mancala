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

    public void bowlClicked(View v) {
        //TODO: here we need to give to this methods the number of the bowl (set the index) that has been clicked
        int index;
        if (game.isPossibleToMove(5) && !game.isEmptyBowl(5))
            game.makeAMove(5);

    }
    /* this is a comment */
}
