package polimi.mancala;

import android.test.InstrumentationTestCase;

/**
 * Created by jack on 28/11/2014.
 */
public class GameTest extends InstrumentationTestCase {

    MatchHandler gameToTest = new MatchHandler();


    public void testIfGameIsFinished () {
        this.gameToTest.beginMatch();
        this.gameToTest.pickAndPush(0);
        this.gameToTest.pickAndPush(1);
        this.gameToTest.pickAndPush(2);
        this.gameToTest.pickAndPush(3);
        this.gameToTest.pickAndPush(4);
        this.gameToTest.pickAndPush(5);
        assertTrue(this.gameToTest.isFinished());
    }


    public void testIfIsPossibleToMove () {
        this.gameToTest.beginMatch();
        assertTrue(this.gameToTest.isPossibleToMove(3));
        assertFalse("The player1 can not move from a player2's bowl", this.gameToTest.isPossibleToMove(8));
    }

    public void testEndOfTheGame () {
        this.gameToTest.beginMatch();
        this.gameToTest.pickAndPush(0);
        this.gameToTest.pickAndPush(1);
        this.gameToTest.pickAndPush(2);
        this.gameToTest.pickAndPush(3);
        this.gameToTest.pickAndPush(4);
        this.gameToTest.pickAndPush(5);

        assertEquals(this.gameToTest.endOfTheGame(), "Tie");
    }


    public void testMakeAMove () {

        this.gameToTest.beginMatch();
        this.gameToTest.makeAMove(1);
        assertEquals(this.gameToTest.table.getNumOfSeeds(1),0);
        assertEquals(this.gameToTest.table.getNumOfSeeds(2),4);
        assertEquals(this.gameToTest.table.getNumOfSeeds(3),4);
        assertEquals(this.gameToTest.table.getNumOfSeeds(4),4);
        assertEquals(this.gameToTest.table.getNumOfSeeds(5),3);

        this.gameToTest.player1.changeTurn();
        this.gameToTest.player2.changeTurn();
        this.gameToTest.makeAMove(12);
        assertEquals(this.gameToTest.table.getNumOfSeeds(12),0);
        assertEquals(this.gameToTest.table.getNumOfSeeds(13),1);
        assertEquals(this.gameToTest.table.getNumOfSeeds(0),4);
        assertEquals(this.gameToTest.table.getNumOfSeeds(1),1);
        assertEquals(this.gameToTest.table.getNumOfSeeds(2),4);


    }


}
