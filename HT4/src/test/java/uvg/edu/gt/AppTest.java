package uvg.edu.gt;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{ 
    public void testConvertirInfixAPostfix() {
        Expresion e = new Expresion("3 + ( 4 * 5 ) - 6");
        assertEquals("3 4 5 * + 6 -", e.getPostfix());

        e = new Expresion("( ( 1 + 2 ) * ( 3 + 4 ) ) * 5");
        assertEquals("1 2 + 3 4 + * 5 *", e.getPostfix());

        e = new Expresion("1 + 2 * ( 3 - 4 ) / 5");
        assertEquals("1 2 3 4 - * 5 / +", e.getPostfix());

        e = new Expresion("1 + 2 * ( 3 - 4 ) ^ 5");
        assertEquals("1 2 3 4 - 5 ^ * +", e.getPostfix());

        e = new Expresion("( ( 1 + 2 ) ^ ( 3 + 4 ) ) * 5");
        assertEquals("1 2 + 3 4 + ^ * 5 *", e.getPostfix());
    }

    public void testEvaluar() {
        Expresion e = new Expresion("3 + ( 4 * 5 ) - 6");
        assertEquals(13, e.evaluar());

        e = new Expresion("( ( 1 + 2 ) * ( 3 + 4 ) ) * 5");
        assertEquals(150, e.evaluar());

        e = new Expresion("1 + 2 * ( 3 - 4 ) / 5");
        assertEquals(3.2, e.evaluar());

        e = new Expresion("1 + 2 * ( 3 - 4 ) ^ 5");
        assertEquals(243.0, e.evaluar());

        e = new Expresion("( ( 1 + 2 ) ^ ( 3 + 4 ) ) * 5");
        assertEquals(33750.0, e.evaluar());

        e = new Expresion("10 + 20 * ( 30 - 40 ) / 5");
        assertEquals(-290.0, e.evaluar());

        e = new Expresion("10 + 20 * ( 30 - 40 ) ^ 5 / 5");
        assertEquals(2.936012937e12, e.evaluar());
    }

    public void testInvalidInfix() {
        try {
            Expresion e = new Expresion("1 + 2 ) * 3");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            // expected
        }

        try {
            Expresion e = new Expresion("1 + 2 * ( 3 - 4 ) ) * 5");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            // expected
        }

        try {
            Expresion e = new Expresion("1 + 2 * ( 3 - 4 ) ) ^ 5 * 5");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            // expected
        }
    }

    public void testDivisionByZero() {
        try {
            Expresion e = new Expresion("1 + 2 * ( 3 - 4 ) / 0");
            fail("Expected ArithmeticException");
        } catch (ArithmeticException expected) {
            // expected
        }
    }
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}

