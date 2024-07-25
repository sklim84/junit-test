package assertion.prev;

import org.junit.jupiter.api.*;
import org.example3.Greetings3;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Greetings3 Test")
public class GreetingsTest3 {
    @Test
    @DisplayName("Testing Greet method")
    void testGreet() {
        Greetings3 greetings = new Greetings3();

        String name = "Jenny";
        String result = greetings.greet(name);
        assertEquals("Hello, Jenny", result);

    }

    @Test
    void testEquality() {
        int value1 = 10;
        int value2 = 10;
        String string1 = "hello";
        String string2 = "hello";
        Object obj1 = new Object();
        Object obj2 = new Object();

        assertEquals(value1, value2);
        assertNotEquals(value1, value2 + 1);
        assertEquals(string1, string2);
        assertNotEquals(value1, "world");
        assertSame(obj1, obj1);
        assertNotSame(obj1, obj2);
    }

    @Test
    void testBoolean() {
        boolean condition1 = true;
        boolean condition2 = false;
        assertTrue(condition1);
        assertFalse(condition2);
    }

    @Test
    void testExceptions() {
        assertThrows(ArithmeticException.class,
                () -> {
                    int value = 1 / 0;
                });
        assertDoesNotThrow(() -> {
            int value = 1 / 1;
        });
    }

    @Test
    void testNull() {
        Object obj1 = null;
        Object obj2 = new Object();

        assertNull(obj1);
        assertNotNull(obj2);
    }

    @Test
    void testAssertIterableEquals() {
        List<String> expected = Arrays.asList("John", "Mary", "Adam");
        List<String> actual = Arrays.asList("John", "Mary", "Adam");
        assertIterableEquals(expected, actual);
    }

    @Test
    void testAssertLinesMatchRegExp() {
        List<String> expectedList = List.of("luv", "[2-7]+", "code");
        List<String> actualList = List.of("luv", "8", "code");
        assertLinesMatch(expectedList, actualList, "Expected lines should match actual lines");
    }

    @Test
    void testAssertLinesMatchFF() {
        List<String> expectedList = List.of("luv", "my", ">>4>>", "code");
        List<String> actualList = List.of("luv", "my", "one", "two", "three", "four", "code");
        assertLinesMatch(expectedList, actualList, "Expected lines should match actual lines");
    }

    @Test
    void testAssertAll() {
        String firstName = "John";
        String lastName = "Doe";
        int age = 30;

        assertAll("person",
                () -> assertEquals("John", firstName),
                () -> assertEquals("Doe", lastName),
                () -> assertEquals(30, age)
        );
    }

    @Test
    void testAssertThrows() {
        String str = null;
        assertThrows(NullPointerException.class, ()->str.length());
    }

    @Test
    void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(1), ()-> {
            Thread.sleep(10);
        });
    }

    @Test
    void testOnlyRunsOnLinux() {
        assumeTrue(System.getProperty("os.name").toLowerCase().contains("windows"));

        String string1 = "hello";
        String string2 = "hello";
        assertEquals(string1, string2);
    }

    @Test
    void testDeltaEquals() {
        double expected = 13.0;
        double actual = 12.9999;
        double delta = 0.01;
        assertEquals(expected, actual, delta);
    }
}
