package org.example;

public class Vowel {
    /**
     * Viet mot ham kiem tra 1 ky tu nhap vao co phai la nguyen am (vowels) hay khong?
     * return true => vowels
     * return false => not vowels
     */
    public static boolean isVowel(String input) {
        if (input.length() != 1) throw new IllegalArgumentException("Moi ban nhap 1 ky tu");
        return input.matches("[ueoaiUEOAI]{1,}");
    }
}
