package assertion.prev;

import org.junit.jupiter.api.Test;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class AssertionTest {
    @Test
    void testEquality() {
        int value1 = 10;
        int value2 = 10;
        String string1 = "hello";
        String string2 = "hello";

        Object obj1 = new Object();
        Object obj2 = new Object();

        assertEquals(value1, value2);
        assertEquals(string1, string2);
        assertNotEquals(string1, "world");
        assertSame(obj1, obj1);
        assertNotEquals(obj1, obj2);
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

        assertNull(obj2);
        assertNotNull(obj2);
    }

    @Test
    void testAssertIterableEquals() {
        List<String> expected = Arrays.asList("John", "Mary", "Adam");
        List<String> actual = Arrays.asList("John", "Mary2", "Adam");
        assertIterableEquals(expected, actual);
    }

    @Test
    void testAssertLinesMatchRegExp() {
        List<String> expectedList = List.of("luv", "[2-7]+", "code");
        List<String> actualList = List.of("luv", "5", "code");
        assertLinesMatch(expectedList, actualList, "Expected lines should match actual lines");

    }

    @Test
    void testAssertLinesMatchFF() {
        List<String> expectedList = List.of("luv", "my", ">> 4 >>", "code");
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
                () -> assertEquals(31, age)
        );
    }

    @Test
    void testAssertThrows() {
        String str = null;
        assertThrows(NullPointerException.class, () -> str.length());
    }

    @Test
    void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            Thread.sleep(2000);
        });
    }


    @Test
    void testOnlyRunsOnLinux() {
        boolean checkOS = System.getProperty("os.name").toLowerCase().contains("windows");
        assumeTrue(checkOS);

        String string1 = "hello";
        String string2 = "hello";
        assertEquals(string1, string2);
    }

    @Test
    void testDeltaEquals() {
        double expected = 13.0;
        double actual = 12.5;
        double delta = 0.01;

        assertEquals(expected, actual, delta);
    }

    @Test
    void testCustomAssertion() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Employee emp1 = new Employee(101, "John", "Doe", "john@gmail.com");
        Employee emp2 = new Employee(101, "John", "Doe2", "john@gmail.com");

        CustomAssertions2.assertJavaBeansEqual(emp1, emp2);
    }
}
