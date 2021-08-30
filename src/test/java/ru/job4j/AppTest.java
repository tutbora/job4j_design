package ru.job4j;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testWhenMessage() {
        String message = "Hello World!";
        App.main(new String[0]);
        assertEquals(message, "Hello World!");
    }
}
