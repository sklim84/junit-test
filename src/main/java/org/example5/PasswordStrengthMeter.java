package org.example5;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {
        // ①규칙을검사하는로직
        if (password == null || password.isEmpty())
            return PasswordStrength.INVALID;
        int metCounts = getMetCriteriaCounts(password);

        // ②강도를판단하는로직
        if (metCounts <= 1) return PasswordStrength.WEAK;
        if (metCounts == 2) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String password) {
        int metCounts = 0;
        if (password.length()>=8) metCounts++;
        if (meetsContainingNumberCriteria(password)) metCounts++;
        if (meetsContainingUppercaseCriteria(password)) metCounts++;
        return metCounts;
    }

    public boolean meetsContainingNumberCriteria(String password) {
        for (char ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    public boolean meetsContainingUppercaseCriteria(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }


}
