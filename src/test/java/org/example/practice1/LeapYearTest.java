package org.example.practice1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LeapYearTest {
    @Test
    void verify_2024_is_leap_year() {
        Assert.assertTrue(LeapYear.isLeapYear(2024));
    }

    @Test
    void verify_2023_is_leap_year() {
        Assert.assertFalse(LeapYear.isLeapYear(2023));
    }
}
