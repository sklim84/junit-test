package annotation.prev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BeforeEachTest3 {
    private int value;

    @BeforeEach
    public void setUp() {
        System.out.println("perform setup");
        value = 5;
    }

    @Test
    public void test1() {
        System.out.println("perform test1");
        value += 2;
        assertEquals(7, value);
    }
    
    @Test
    public void test2() {
        System.out.println("perform test2");
        value -= 2;
        assertEquals(3, value);
    }
}
