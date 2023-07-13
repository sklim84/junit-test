package annotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterTest {
    public boolean isPalindrome(String input) {
        return input.equals(new StringBuilder(input).reverse().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "level"})
    void testIsPalindrome(String input) {
        assertTrue(isPalindrome(input));
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
    @ValueSource(booleans = {true, true})
    void testBooleanValueIsTrue(boolean value) {
        assertTrue(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void testIntArrayAllEven(int num) {
        assertTrue(num % 2 == 0);
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
                Arguments.of("apple", 1, LocalDate.of(2022, 7, 1)),
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
    @CsvFileSource(resources = "/fruit_prices.csv", numLinesToSkip = 1)
    void testFruitPrices(String fruit, int price) {
        // numLinesToSkip = 1 : 타이틀 스킵
        assertTrue(price > 0);
    }
}
