package ru.job4j;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTestJUnit extends AbstractTest {

    @Test
    public void whenMessage() {
        final String message = "Hello World!";
        App.main(new String[0]);
        assertEquals(message, getOutput(), "Not right!");
    }
}