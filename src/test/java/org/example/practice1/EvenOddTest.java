package org.example.practice1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EvenOddTest {
    // do la so chan (even)
    @Test
    void verify_10_is_even_number () {
        Assert.assertTrue(EvenOdd.isEven(10));
    }

    // do la so le (even)
    @Test
    void verify_11_is_not_even_number () {
        Assert.assertFalse(EvenOdd.isEven(11));
    }
}
