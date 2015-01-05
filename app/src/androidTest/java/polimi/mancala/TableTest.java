package polimi.mancala;

import android.test.InstrumentationTestCase;

/**
 * @author Giacomo bianchini
 */
public class TableTest extends InstrumentationTestCase {

    TableHandler tableToTest = TableHandler.getInstance();

    public void testInitialTable () {
        int [] tmp;
        tableToTest.createInitialBoard(1,2);
        tmp = tableToTest.getGameBoardStatus();
        assertEquals("player1's tray is well setted", 0, tableToTest.getTrayByPlayer(1).getNumSeeds());
        assertEquals("player2's tray is well setted", 0, tableToTest.getTrayByPlayer(2).getNumSeeds());
        assertEquals(3, tableToTest.getNumOfSeedByIndex(0));
        assertEquals(3, tableToTest.getNumOfSeedByIndex(1));
        assertEquals(3, tableToTest.getNumOfSeedByIndex(2));
        assertEquals(3, tableToTest.getNumOfSeedByIndex(3));
        assertEquals(3, tableToTest.getNumOfSeedByIndex(4));
        assertEquals(3, tableToTest.getNumOfSeedByIndex(9));

        assertEquals(1, tableToTest.getContainerByIndex(0).getNextContainer().getIndex());
    }


    public void testAddSeed () {
    }

    public void testClearBowl () {
        tableToTest.createInitialBoard(1,2);
        int pointsP1 = tableToTest.clearBoardByPlayerId(1);
        int pointsP2 = tableToTest.clearBoardByPlayerId(2);
        assertTrue("Player1 board has been cleaned",tableToTest.checkPlayerGameIsOverById(1));
        assertTrue("Player2 board has been cleaned",tableToTest.checkPlayerGameIsOverById(2));
        assertEquals("All P1 seeds are in the right tray", pointsP1, tableToTest.getTrayByPlayer(1).getNumSeeds());
        assertEquals("All P2 seeds are in the right tray", pointsP2, tableToTest.getTrayByPlayer(2).getNumSeeds());
    }

    public void testPickAndSteal () {

    }


}
