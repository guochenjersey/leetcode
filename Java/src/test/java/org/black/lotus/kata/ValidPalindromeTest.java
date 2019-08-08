package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeTest {

    @Test
    public void find_valid_palindrome() {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String palindrome = "abccdk";

        assertFalse(validPalindrome.isPalindrome(palindrome));
        assertTrue(validPalindrome.isPalindrome("abccba"));
        assertTrue(validPalindrome.isPalindrome("abddba"));
    }
}