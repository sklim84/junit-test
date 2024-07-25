package annotation.prev;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
public class OrderTest4 {

    @Test
    @Order(2)
    void a_Second() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(1)
    void b_First() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(3)
    void c_Third() {
        assertEquals(2, 1 + 1);
    }

}
