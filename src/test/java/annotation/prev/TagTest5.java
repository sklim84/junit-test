package annotation.prev;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class TagTest5 {

    @Test
    @DisplayName("태그사용하기fast 1")
    @Tag("fast")
    void use_tag_1() {
        System.out.println("태그사용하기fast 1");
    }

    @Test
    @DisplayName("태그사용하기fast 2")
    @Tag("fast")
    void use_tag_2() {
        System.out.println("태그사용하기fast 2");
    }

    @Test
    @DisplayName("태그사용하기slow")
    @Tag("slow")
    void use_tag_3() {
        System.out.println("태그사용하기slow");
    }
    @Test
    @DisplayName("태그사용하기fast, high")
    @Tag("high")
    @Tag("fast")
    void use_tag_4() {
        System.out.println("태그사용하기fast, high");
    }
    @Test
    @DisplayName("태그사용하기fast, high, far")
    @Tags({
            @Tag("high"), @Tag("far"), @Tag("fast")
    })
    void use_tag_5() {
        System.out.println("태그사용하기fast, high, far");
    }

}
