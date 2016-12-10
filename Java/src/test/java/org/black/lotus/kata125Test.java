package org.black.lotus;

import org.junit.Test;

import static org.junit.Assert.*;

public class Kata125Test {

    @Test
    public void should_handle_a_a() {
        String aa = "a a";
        Kata125 kata125 = new Kata125();
        boolean palindrome = kata125.isPalindrome(aa);
        assertTrue(palindrome);

    }

}