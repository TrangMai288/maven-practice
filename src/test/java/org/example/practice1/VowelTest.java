package org.example.practice1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VowelTest {
    @Test
    void verify_u_is_vowel() {
        Assert.assertTrue(Vowel.isVowel("u"));
    }

    @Test
    void verify_e_is_vowel() {
        Assert.assertTrue(Vowel.isVowel("e"));
    }

    @Test
    void verify_o_is_vowel() {
        Assert.assertTrue(Vowel.isVowel("o"));
    }

    @Test
    void verify_a_is_vowel() {
        Assert.assertTrue(Vowel.isVowel("a"));
    }

    @Test
    void verify_i_is_vowel() {
        Assert.assertTrue(Vowel.isVowel("i"));
    }

    @Test
    void verify_U_is_vowel() {
        Assert.assertTrue(Vowel.isVowel("U"));
    }

    @Test
    void verify_E_is_vowel() {
        Assert.assertTrue(Vowel.isVowel("E"));
    }

    @Test
    void verify_O_is_vowel() {
        Assert.assertTrue(Vowel.isVowel("O"));
    }

    @Test
    void verify_A_is_vowel() {
        Assert.assertTrue(Vowel.isVowel("A"));
    }

    @Test
    void verify_I_is_vowel() {
        Assert.assertTrue(Vowel.isVowel("I"));
    }

    @Test
    void verify_b_is_not_vowel() {
        Assert.assertFalse(Vowel.isVowel("b"));
    }

    @Test
    void verify_B_is_not_vowel() {
        Assert.assertFalse(Vowel.isVowel("B"));
    }

    // nhap so
    @Test
    void verify_1_is_not_vowel() {
        Assert.assertFalse(Vowel.isVowel("1"));
    }

    // khong nhap chu nao
    @Test
    void verify_exception() {
        try {
            Vowel.isVowel("");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Moi ban nhap 1 ky tu");
        }
    }
}
