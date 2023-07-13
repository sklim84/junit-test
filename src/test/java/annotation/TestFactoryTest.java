package annotation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public class TestFactoryTest {

    List<List<Integer>> inputList = Arrays.asList(
            Arrays.asList(2, 4, 6, 8),
            Arrays.asList(1, 3, 5, 7, 9),
            Arrays.asList(1, 2, 3, 4, 5),
            Arrays.asList(5, 4, 3, 2, 1));

    @TestFactory
    public List<DynamicTest> testSorting() {
        return inputList.stream()
                .map(list -> DynamicTest.dynamicTest("Test sorting for " + list, () -> {
                    assertTrue(isAscending(list));
                })).collect(Collectors.toList());
    }

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
}
