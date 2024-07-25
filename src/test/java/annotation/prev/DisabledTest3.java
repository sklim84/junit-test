package annotation.prev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assumptions.*;

public class DisabledTest3 {

    @Test
    void testMethodOne() {
        assumeTrue(5<10);
    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    void testMethodTwo() {
        System.out.println("Current os is not windows...");
    }
}
