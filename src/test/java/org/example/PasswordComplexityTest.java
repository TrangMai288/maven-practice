package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordComplexityTest {
    // nhap du 8 ky tu, co so, co ky tu thuong, co ky tu hoa, !@#$%^&*()
    @Test
    void verify_Trang123456a$_is_password() {
        Assert.assertTrue(PasswordComplexity.isPasswordComplexity("Trang123456a$"));
    }

    // nhap khong du 8 ky tu
    @Test
    void verify_Trang1$_is_not_password() {
        Assert.assertFalse(PasswordComplexity.isPasswordComplexity("Trang1$"));
    }

    // nhap 8 ky tu
    @Test
    void verify_Trang12$_is_not_password() {
        Assert.assertFalse(PasswordComplexity.isPasswordComplexity("Trang12$"));
    }

    // nhap khong co so
    @Test
    void verify_Trangtester$_is_not_password() {
        Assert.assertFalse(PasswordComplexity.isPasswordComplexity("Trangtester$"));
    }

    // nhap khong co chu thuong
    @Test
    void verify_TRANG123$_is_not_password() {
        Assert.assertFalse(PasswordComplexity.isPasswordComplexity("TRANG123$"));
    }

    // nhap khong co chu hoa
    @Test
    void verify_trangtest1$_is_not_password() {
        Assert.assertFalse(PasswordComplexity.isPasswordComplexity("trangtest1$"));
    }

    // nhap khong co ky tu dac biet
    @Test
    void verify_Trang123456_is_not_password() {
        Assert.assertFalse(PasswordComplexity.isPasswordComplexity("Trang123456"));
    }
}
