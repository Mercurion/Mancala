package polimi.mancala;

import android.test.InstrumentationTestCase;

/**
 * Created by jack on 28/11/2014.
 */
public class GameTest extends InstrumentationTestCase {

    MatchHandler game = new MatchHandler();
    TableHandler table = new TableHandler();


    public void testIfGameIsFinished () {
        this.game.beginMatch();
        this.game.pickAndPush(0);
        this.game.pickAndPush(1);
        this.game.pickAndPush(2);
        this.game.pickAndPush(3);
        this.game.pickAndPush(4);
        this.game.pickAndPush(5);
        assertTrue(this.game.isFinished());
    }

}
