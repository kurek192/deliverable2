//WILLIAM KUREK

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CitySim9004Test {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    //Tests that a valid long passed as the lone argument from the command line
    //arguments 
    @Test
    public void testParse_validValue() {
        long standardTestValue = 4L;
        assertEquals("parse: Standard valid value",
                CitySim9004.parse(new String[]{Long.toString(standardTestValue, 10)}),
                standardTestValue);
 
        assertEquals("parse: Min valid value",
                CitySim9004.parse(new String[]{Long.toString(Long.MIN_VALUE, 10)}),
                Long.MIN_VALUE);

        assertEquals("parse: Max valid value",
                CitySim9004.parse(new String[]{Long.toString(Long.MAX_VALUE, 10)}),
                Long.MAX_VALUE);
    }

    //ensure that an invalid argument will through an expection
    @Test
    public void testParse_invalidValue() {
        // test that a number less than min fails
        boolean fail = true;
        try {
            BigInteger bigInt = new BigInteger(Long.toString(Long.MIN_VALUE)).subtract(BigInteger.ONE);
            CitySim9004.parse(new String[]{bigInt.toString(10)});
        } catch (IllegalArgumentException ex) {
            fail = false;
        } finally {
            if (fail) {
                fail("parse: seed less than Long.MIN_VALUE did not throw IllegalArgumentException");
            }
        }

        fail = true;
        try {
            BigInteger bigInt = new BigInteger(Long.toString(Long.MAX_VALUE)).add(BigInteger.ONE);
            CitySim9004.parse(new String[]{bigInt.toString(10)});
        } catch (IllegalArgumentException ex) {
            fail = false;
        } finally {
            if (fail) {
                fail("parse: seed larger than Long.MAX_VALUE did not throw IllegalArgumentException");
            }
        }

        fail = true;
        try {
            CitySim9004.parse(new String[]{"Not an integer"});
        } catch (IllegalArgumentException ex) {
            fail = false;
        } finally {
            if (fail) {
                fail("parse: non-integer seed argument did not throw IllegalArgumentException\"");
            }
        }
    }

    //ensure that no arguments will through an expection
    @Test
    public void testParse_noArgs() {
        // test that no args fails
        boolean fail = true;
        try {
            CitySim9004.parse(new String[0]);
        } catch (IllegalArgumentException iae) {
            fail = false;
        } finally {
            if (fail) {
                fail("parse: 0 command line parameters did not throw IllegalArgumentException");
            }
        }
    }

    //ensure that more than one arguments will through an expection
    @Test
    public void testParse_Args() {
        // test that more than 1 args fails
        boolean fail = true;
        try {
            CitySim9004.parse(new String[2]);
        } catch (IllegalArgumentException iae) {
            fail = false;
        } finally {
            if (fail) {
                fail("parse: > 1 command line parameters did not throw IllegalArgumentException");
            }
        }
    }
}
