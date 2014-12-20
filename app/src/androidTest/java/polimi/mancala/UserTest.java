package polimi.mancala;

import android.test.InstrumentationTestCase;

/**
 * @author Giacomo Bianchini
 */
public class UserTest extends InstrumentationTestCase {

    User userOneToTest = new User(1);
    User userTwoToTest = new User(2);

    public void testScore () {
        this.userOneToTest.setScore(5);
        this.userOneToTest.setHisTurn(true);
        assertEquals("The User Score is well setted", 5, this.userOneToTest.getScore());
    }

    public void testChangeTurn () {
        this.userOneToTest.setHisTurn(false);
        this.userOneToTest.changeTurn();
        assertTrue(this.userOneToTest.getHisTurn());
    }


}
