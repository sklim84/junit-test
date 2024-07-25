package annotation.prev;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class AfterEachTest3 {
    private File file;
    @BeforeEach
    public void setUp() {
        //create file
        file = new File("temp.txt");
        System.out.println("perform setup");
    }

    @AfterEach
    public void tearDown() {
        file.delete();
        System.out.println("perform teardown");
    }

    @Test
    public void test1() {
        System.out.println("perform test1");
    }

    @Test
    public void test2() {
        System.out.println("perform test2");
    }
}
