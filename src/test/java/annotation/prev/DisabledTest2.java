package annotation.prev;

import org.junit.Assume;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

public class DisabledTest2 {

    @Test
    void testMethodOne() {
        Assume.assumeTrue(5 < 10);
        // test code
    }

    @Test
    @DisabledOnOs({ OS.WINDOWS })
    void testMethodTwo() {
        // test code
        System.out.println("Current os is not windows...");
    }

}
