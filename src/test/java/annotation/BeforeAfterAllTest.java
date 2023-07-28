package annotation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BeforeAfterAllTest {

    private static String input;
    private static Long result;

    @BeforeAll
    public static void setup() {
        input = "77";
    }

    @AfterAll
    public static void teardown() {
        input = null;
        result = null;
    }

    @Test
    public void whenConvertStringToLong_thenResultShouldBeLong() {
        result = Long.valueOf(input);
        assertEquals(77l, result);
    }

//    private static Connection conn;
//
//    @BeforeAll
//    public static void setUp() throws SQLException {
//        String url = "jdbc:postgresql://localhost/mydatabase";
//        String user = "myusername";
//        String password = "mypassword";
//        conn = DriverManager.getConnection(url, user, password);
//    }
//
//    @AfterAll
//    public static void tearDown() throws SQLException {
//        conn.close();
//    }
//
//    @Test
//    public void testConnection() {
//        assertNotNull(conn);
//    }
}
