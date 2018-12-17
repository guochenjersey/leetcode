package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeIITest {

    @Test
    public void should_find_valid_palindrome() {
        String s = "eeccccbebaeeabebccceea";
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        boolean res = validPalindromeII.validPalindrome(s);
        assertFalse(res);
    }

    @Test
    public void should_find_valid_palindrome_1() {
        String s = "aba";
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        boolean res = validPalindromeII.validPalindrome(s);
        assertTrue(res);
    }

    @Test
    public void should_find_valid_palindrome_2() {
        String s = "abca";
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        boolean res = validPalindromeII.validPalindrome(s);
        assertTrue(res);
    }

    @Test
    public void should_find_valid_palindrome_3() {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        boolean res = validPalindromeII.validPalindrome(s);
        assertTrue(res);
    }


}