package assertion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyTest {
    @Test
    void myTestMethod() {
        String expected = "Hello, World!";
        String actual = "Hello, World!";
        assertEquals(expected, actual);
    }
}

