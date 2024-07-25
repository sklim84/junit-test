package assertion.prev;

import org.junit.jupiter.api.Test;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class KTAssertionTest {

    @Test
    void testAssertIterableEquals() {
        List<String> expected = Arrays.asList("John", "Mary", "Adam");
        List<String> actual = Arrays.asList("John", "Mary2", "Adam");
        assertIterableEquals(expected, actual);
    }

    @Test
    void testAssertLinesMatchRegExp() {
        List<String> expectedList = List.of("luv", "[2-7]+", "code");
        List<String> actualList = List.of("luv", "55558", "code");
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
                () -> assertEquals(30, age)
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
            // Code that should not take more than 1 second to run
            Thread.sleep(10);
        });
    }

//    importstaticorg.junit.jupiter.api.Assumptions.*;
    @Test
    void testOnlyRunsOnLinux() {
        assumeTrue(System.getProperty("os.name").toLowerCase().contains("windows"));
// Test code that only runs on Windows
        String string1 = "hello";
        String string2 = "hello";
        assertEquals(string1, string2);
    }

    @Test
    void testDeltaEquals() {
        double expected = 13.0;
        double actual = 12.9999;
        double delta = 0.0000001;
        assertEquals(expected, actual, delta);
    }

    @Test
    void testCustomAssertion() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Employee emp1 = new Employee(101, "John", "Doe", "john.doe@gmail.com");
        Employee emp2 = new Employee(102, "John", "Doe", "john.doe@gmail.com");

        CustomAssertions.assertJavaBeansEqual(emp1, emp2);
    }
}
