package polimi.mancala;

import android.test.InstrumentationTestCase;

/**
 * Created by jack on 29/11/2014.
 */
public class UserTest extends InstrumentationTestCase {

    User userToTest = new User();

    public void testScore () {
        this.userToTest.setScore(5);
        this.userToTest.setHisTurn(true);
        assertEquals("The User Score is well setted", 5,this.userToTest.getScore());
    }

    public void testChangeTurn () {
        this.userToTest.setHisTurn(false);
        this.userToTest.changeTurn();
        assertTrue(this.userToTest.getHisTurn());
    }


}
