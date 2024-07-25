package annotation.prev;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class TagTest4 {

    @Test
    @DisplayName("태그 사용 fast 1")
    @Tag("fast")
    void use_tag_1() {
        System.out.println("태그 사용 fast 1");
    }

    @Test
    @DisplayName("태그 사용 fast2")
    @Tag("fast")
    void use_tag_2() {
        System.out.println("태그 사용 fast 2");
    }

    @Test
    @DisplayName("태그 사용 slow")
    @Tag("slow")
    void use_tag_3() {
        System.out.println("태그 사용 slow");
    }

    @Test
    @DisplayName("태그 사용 fast, high")
    @Tag("fast")
    @Tag("high")
    void use_tag_4() {
        System.out.println("태그 사용 fast high");
    }

    @Test
    @DisplayName("태그 사용 fast, high, far")
    @Tags({
            @Tag("fast"), @Tag("high"), @Tag("far")
    })
    void use_tag_5() {
        System.out.println("태그 사용 fast high far");
    }
}
