package annotation;

import org.junit.jupiter.api.*;

public class TagTest {
    @Test
    @DisplayName("태그 사용하기 fast 1")
    @Tag("fast")
    void use_tag_1() {
        System.out.println("태그 사용하기 fast 1");
    }

    @Test
    @DisplayName("태그 사용하기 fast 2")
    @Tag("fast")
    void use_tag_2() {
        System.out.println("태그 사용하기 fast 2");
    }

    @Test
    @DisplayName("태그 사용하기 slow")
    @Tag("slow")
    void use_tag_3() {
        System.out.println("태그 사용하기 slow");
    }

    @Test
    @DisplayName("태그 사용하기 fast, high")
    @Tag("high")
    @Tag("fast")
    void use_tag_4() {
        System.out.println("태그 사용하기 fast, high");
    }

    @Test
    @DisplayName("태그 사용하기 fast, high, far")
    @Tags({
            @Tag("high"), @Tag("far"), @Tag("fast")
    })
    void use_tag_5() {
        System.out.println("태그 사용하기 fast, high, far");
    }
}
