package mercurion.mancala;

import android.test.InstrumentationTestCase;

import mercurion.mancala.logic.User;

/**
 * @author Giacomo Bianchini
 */
public class UserTest extends InstrumentationTestCase {

    User userOneToTest = new User(1);

    public void testScore () {
        this.userOneToTest.setScore(5);
        this.userOneToTest.setHisTurn(true);
        assertEquals("The User Score is well setted", 5, this.userOneToTest.getScore());
        this.userOneToTest.addPoints(5);
        assertEquals("The User Score does well improve by 5, and now it's 10", 10, this.userOneToTest.getScore());
    }

    public void testChangeTurn () {
        this.userOneToTest.setHisTurn(false);
        this.userOneToTest.changeTurn();
        assertTrue(this.userOneToTest.getHisTurn());
    }


}
