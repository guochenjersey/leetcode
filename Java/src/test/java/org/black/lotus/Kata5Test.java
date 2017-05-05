package org.black.lotus;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Kata5Test {

    private Kata5 kata5;

    @Before
    public void setup() {
        kata5 = new Kata5();
    }

    @Test
    public void testKata5() {
        assertEquals("cbbc", kata5.longestPalindrome("cbbcdefg"));
        assertEquals("abccba", kata5.longestPalindrome("abccba"));
        assertEquals("bkb", kata5.longestPalindrome("abcdefbkb"));
        assertEquals("abcdedcba", kata5.longestPalindrome("bkbeabcdedcba"));
        assertEquals("bb", kata5.longestPalindrome("cbbd"));
        assertEquals("a", kata5.longestPalindrome("a"));
        assertEquals("aaaa", kata5.longestPalindrome("aaaa"));
        assertEquals("aa", kata5.longestPalindrome("aa"));
        assertEquals("aa", kata5.longestPalindrome("aa"));
        assertEquals(null, kata5.longestPalindrome(null));
    }
}