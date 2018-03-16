package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeNumberIITest {

    @Test
    public void should_find_palindrome() {
        PalindromeNumberII palindromeNumberII = new PalindromeNumberII();
        boolean res = palindromeNumberII.isPalindrome(0);
        assertTrue(res);
    }

    @Test
    public void should_find_palindrome_5() {
        PalindromeNumberII palindromeNumberII = new PalindromeNumberII();
        boolean res = palindromeNumberII.isPalindrome(5);
        assertTrue(res);
    }
}