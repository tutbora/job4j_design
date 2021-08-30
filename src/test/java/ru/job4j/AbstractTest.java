package ru.job4j;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class AbstractTest {

    private static final PrintStream SYSTEM_OUT = System.out;
    private static final InputStream SYSTEM_IN = System.in;

    private static ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    protected String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(SYSTEM_IN);
        System.setOut(SYSTEM_OUT);
    }
}