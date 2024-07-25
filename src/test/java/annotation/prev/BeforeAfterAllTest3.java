package annotation.prev;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BeforeAfterAllTest3 {
    private static String input;
    private static Long result;

    @BeforeAll
    public static void setup() {
        input = "77";
    }

    @AfterAll
    public static void teardown() {
        input = null;
        result = null;
    }

    @Test
    public void whenConvertStringToLong_thenResultsShouldBeLong() {
        result = Long.valueOf(input);
        assertEquals(77l, result);
    }

    @Test
    public void whenConvertStringToLong_thenResultsShouldBeLong2() {
        System.out.println(result);
        assertEquals(77l, result);
    }
}
