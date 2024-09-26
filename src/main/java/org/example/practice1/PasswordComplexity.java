package org.example.practice1;

public class PasswordComplexity {
    public static boolean isPasswordComplexity(String input) {
        return input.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]).{9,}");
    }
}
