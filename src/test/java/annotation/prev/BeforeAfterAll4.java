package annotation.prev;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BeforeAfterAll4 {
    private static String input;
    private static Long result;

    @BeforeAll
    public static void setup() {
        System.out.println("perform setup");
        input = "77";
    }

    @AfterAll
    public static void teardown() {
        System.out.println("perform teardown");
        input = null;
        result = null;
    }

    @Test
    public void whenConvertStringToLong_ThenResultShouldBeLong() {
        System.out.println("perform first");
        result = Long.valueOf(input);
        assertEquals(77l, result);
    }

    @Test
    public void nextCall() {
        System.out.println("perform second");
        System.out.println(result);
        assertEquals(77l, result);
    }

}
