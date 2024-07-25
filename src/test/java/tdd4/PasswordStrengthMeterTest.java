package tdd4;

import org.example4.PasswordStrength;
import org.example4.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expected) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expected, result);
    }

    @Test
    void meetsAllCriteriaThenStrong() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteriaExceptLengthThenNormal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteriaExceptNumberThenNormal() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    @Test
    void nullInput_Then_Invalid() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void emptyInput_Then_Invalid() {
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    void meetsOtherCriteriaExceptUppercaseThenNormal() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOnlyLengthCriteriaThenWeak() {
        assertStrength("abbbbbbbbbbbb", PasswordStrength.WEAK);
    }

    @Test
    void meetsOnlyNumCriteriaThenWeak() {
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    void meetsOnlyUpperCriteriaThenWeak() {
        assertStrength("ABCDE", PasswordStrength.WEAK);
    }

    @Test
    void meetsNoCriteriaThenWeak() {
        assertStrength("abcde", PasswordStrength.WEAK);
    }
}
