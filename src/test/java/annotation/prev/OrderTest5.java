package annotation.prev;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.Random.class)
public class OrderTest5 {
    @Test
    @Order(2)
    void a_second() {
        assertEquals(2, 1+1);
    }

    @Test
    @Order(1)
    void b_first() {
        assertEquals(2, 1+1)  ;
    }

    @Test
    @Order(3)
    void c_third() {
        assertEquals(2, 1+1)  ;
    }

}
