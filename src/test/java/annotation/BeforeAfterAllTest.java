package annotation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BeforeAfterAllTest {
    private static Connection conn;

    @BeforeAll
    public static void setUp() throws SQLException {
        String url = "jdbc:postgresql://localhost/mydatabase";
        String user = "myusername";
        String password = "mypassword";
        conn = DriverManager.getConnection(url, user, password);
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        conn.close();
    }

    @Test
    public void testConnection() {
        assertNotNull(conn);
    }
}
