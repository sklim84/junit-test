package annotation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class AfterEachTest {
    private File file;
    @BeforeEach
    public void setUp() {
        System.out.println("perform setup");
        // create file
        file = new File("temp.txt");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("perform teardown");
        // delete file
        file.delete();
    }

    @Test
    public void test1() {
        // perform test1
        System.out.println("perform test1");
    }

    @Test
    public void test2() {
        // perform test1
        System.out.println("perform test1");
    }
}
