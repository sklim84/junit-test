package assertion.prev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MyTest3 {

    @Test
    void myTestMethod() {
        String expected = "Hello, World!";
        String actual = "Hello, World!";
        assertEquals(expected, actual);
    }
}
