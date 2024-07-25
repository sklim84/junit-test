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

public class ParameterizedTest4 {

    public boolean isPalindrome(String input) {
        return input.equals(new StringBuilder(input).reverse().toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "level", "tomato"})
    void testIsPalindrome(String input) {
        assertTrue(isPalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, true})
    void testBooleanValuesTrueboolean(boolean input) {
        assertTrue(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void testIntArrayAllEven(int num) {
        assertEquals(num % 2, 0);
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
        return Stream.of(1, 2, 3, -1);
    }

    @ParameterizedTest
    @MethodSource("provideInputs")
    void testMethod(int input) {
        assertTrue(input > 0);
    }

    static Stream<Arguments> fruitPrices() {
        return Stream.of(
                Arguments.of("apple", 1, LocalDate.of(2002, 7, 1)),
                Arguments.of("banana", 2, LocalDate.of(2002, 7, 2)),
                Arguments.of("orange", 3, LocalDate.of(2002, 7, 3)),
                Arguments.of("orange", -1, LocalDate.of(2002, 7, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("fruitPrices")
    void testMethodArg(String fruit, int price, LocalDate date) {
        assertTrue(price > 0);
    }

    @ParameterizedTest
    @CsvSource({
            "racecar,true",
            "radar,true",
            "level,true",
            "tomato,true"
    })
    void testIsPalindrome(String input, boolean expected) {
        assertEquals(expected, isPalindrome(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/fruit_prices.csv", numLinesToSkip = 1)
    void testFruitPrices(String fruit, int price) {
        assertTrue(price > 0);
    }

    List<List<Integer>> inputList = Arrays.asList(
            Arrays.asList(2, 4, 6, 8),
            Arrays.asList(1, 3, 5, 7, 8),
            Arrays.asList(1, 2, 3, 4, 5),
            Arrays.asList(5, 4, 3, 2, 1)
    );

    public boolean isAscending(List<Integer> list) {
        if (list == null || list.size() < 2)
            return true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    @TestFactory
    public List<DynamicTest> testSorting() {
        return inputList.stream().map(
                list -> DynamicTest.dynamicTest("Test sorting for " + list, ()->{
                    assertTrue(isAscending(list));
                })
        ).collect(Collectors.toList());
    }

}
