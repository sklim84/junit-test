package annotation;


import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
public class DisabledTest {

    @Test
    void testMethodOne() {
        assumeTrue(5 < 10);
        // test code
    }

    @Test
    @DisabledOnOs({ OS.WINDOWS }) // OS.LINUX, OS.MAC
    void testMethodTwo() {
        // test code
        System.out.println("Current os is not windows...");
    }
}
