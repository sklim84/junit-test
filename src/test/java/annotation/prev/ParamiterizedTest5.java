package annotation.prev;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParamiterizedTest5 {

    public boolean isPalindrome(String input) {
        return input.equals(new StringBuilder(input).reverse().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "level"})
    void testIsPalindrome(String input) {
        assertTrue(isPalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void testBooleanValueIsTrue(boolean value) {
        assertTrue(value);
    }

    boolean isWeekday(DayOfWeek day) {
        return day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY;
    }
    @ParameterizedTest
    @EnumSource(DayOfWeek.class)
    void testIsWeekday(DayOfWeek day) {
        assertTrue(isWeekday(day));
    }

    static Stream<Integer> provideInputs() {
        return Stream.of(1, 2, 3);
    }
    @ParameterizedTest
    @MethodSource("provideInputs")
    void test(int input) {
        assertTrue(input > 0);
    }


    static Stream<Arguments> fruitPrices() {
        return Stream.of(
                Arguments.of("apple", 0, LocalDate.of(2022, 7, 1)),
                Arguments.of("banana", 2, LocalDate.of(2022, 7, 2)),
                Arguments.of("orange", 3, LocalDate.of(2022, 7, 3))
        );
    }
    @ParameterizedTest
    @MethodSource("fruitPrices")
    void testFruitPrices(String fruit, int price, LocalDate date) {
        assertTrue(price > 0);
    }

    @ParameterizedTest
    @CsvSource({
            "racecar, true",
            "radar, true",
            "level, true",
            "hello, false"
    })
    void testIsPalindrome(String input, boolean expected) {
        assertEquals(expected, isPalindrome(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/fruit_prices.csv", numLinesToSkip = 1)
    void testFruitPrices(String fruit, int price) {
        // numLinesToSkip = 1 : 타이틀스킵
        assertTrue(price > 0);
    }
}
