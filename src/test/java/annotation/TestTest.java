package annotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTest {
    @Test
    public void testSum() {
        int a = 3;
        int b = 4;
        int result = a + b;
        assertEquals(result, 7);
    }

//    @Test(expected = ArithmeticException.class)
//    public void testDivideByZero() {
//        int a = 1;
//        int b = 0;
//        int result = a / b;
//    }

//    @Test(timeout = 1000)
//    public void testMethod() throws InterruptedException {
//        Thread.sleep(2000);
//    }
}
