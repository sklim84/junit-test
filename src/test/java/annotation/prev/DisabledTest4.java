package annotation.prev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assumptions.*;

public class DisabledTest4 {

    @Test
    void testMethodOne() {
        assumeTrue(5 > 10);

        // test case
        System.out.println("perform one test");
    }

    @Test
    @DisabledOnOs({OS.MAC})
    void testMethodTwo() {
        System.out.println("is not windows");
    }


}
