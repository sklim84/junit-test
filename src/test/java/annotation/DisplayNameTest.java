package annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Addition Test")
public class DisplayNameTest {

    @Test
    @DisplayName("Addition Test - Positive Numbers")
    public void additionTestPositiveNumbers() {
        // Test code goes here
    }
}
