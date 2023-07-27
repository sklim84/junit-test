package tdd;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.example.PasswordStrengthMeter;
import org.example.PasswordStrength;

public class PasswordStrengthMeterTest {
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expected) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test 9. 어떠한 규칙도 충족하지 않는 경우")
    void meetsNoCriteria_Then_Weak() {
        assertStrength("abc", PasswordStrength.WEAK);
    }


    @Test
    @DisplayName("Test 8. 대문자 포함 조건만 충족하는 경우")
    void meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }


    @Test
    @DisplayName("Test 7. 숫자 포함 조건만 충족하는 경우")
    void meetsOnlyNumCriteria_Then_Weak() {
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("Test 6. 8글자 이상인 규칙만 충족하는 경우")
    void meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }


    @Test
    @DisplayName("Test 5. 대문자를 포함하지 않고 나머지 조건을 충족하는 경우")
    void meetsOtherCriteria_except_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }


    @Test
    @DisplayName("Test 4. 값이 없는 경우 - empty string")
    void emptyInput_Then_Invalid() {
        assertStrength("", PasswordStrength.INVALID);
    }


    @Test
    @DisplayName("Test 4. 값이 없는 경우 - null")
    void nullInput_Then_Invalid() {
        assertStrength(null, PasswordStrength.INVALID);
    }


    @Test
    @DisplayName("Test 3. 숫자를 포함하지 않고 나머지 조건은 충족하는 경우")
    void meetsOtherCriteria_except_Number_Then_Normal() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }


    @Test
    @DisplayName("Test 2. 8글자 미만이고 나머지 규칙은 충족하는 경우")
    void meetsOtherCriteria_except_Length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
    }


    @Test
    @DisplayName("Test 1. 모든 규칙을 만족하는 경우")
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
    }

}
