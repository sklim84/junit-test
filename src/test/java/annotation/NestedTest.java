package annotation;

import org.junit.jupiter.api.*;

public class NestedTest {
    @BeforeEach
    void beforeEachParent() {
        System.out.println("Before each parent test");
    }

    @AfterEach
    void afterEachParent() {
        System.out.println("After each parent test");
    }

    @Test
    void parentTest1() {
        System.out.println("Parent test 1");
    }

    @Test
    void parentTest2() {
        System.out.println("Parent test 2");
    }

    @Nested
    class NestedClass {

        @BeforeEach
        void beforeEachNested() {
            System.out.println("Before each nested test");
        }

        @AfterEach
        void afterEachNested() {
            System.out.println("After each nested test");
        }

        @Test
        void nestedTest1() {
            System.out.println("Nested test 1");
        }

        @Test
        void nestedTest2() {
            System.out.println("Nested test 2");
        }
    }
}
