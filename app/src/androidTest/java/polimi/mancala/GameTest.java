package polimi.mancala;

import android.test.InstrumentationTestCase;

/**
 * @author Giacomo Bianchini
 */
public class GameTest extends InstrumentationTestCase {

    MatchHandler gameToTest = MatchHandler.getMatchHandler();


    public void testIfGameIsFinished () {
        this.gameToTest.beginMatch();
        assertTrue(this.gameToTest.isFinished());
    }


    public void testIfIsPossibleToMove () {
        this.gameToTest.beginMatch();
     }

    public void testEndOfTheGame () {
        this.gameToTest.beginMatch();
    }


    public void testMakeAMove () {

        this.gameToTest.beginMatch();
        this.gameToTest.makeAMove(1);

        this.gameToTest.player1.changeTurn();
        this.gameToTest.player2.changeTurn();
        this.gameToTest.makeAMove(12);


    }


}
