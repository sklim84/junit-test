package annotation.prev;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest2 {
    @Test
    @Order(2)
    void a_Second() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(1)
    void b_First() {
        assertEquals(3, 1 + 2);
    }

    @Test
    @Order(3)
    void c_Third() {
        assertEquals(4, 1 + 3);
    }

}
