package annotation.prev;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedTest4 {

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
