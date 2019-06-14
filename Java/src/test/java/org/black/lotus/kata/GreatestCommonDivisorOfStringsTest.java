package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreatestCommonDivisorOfStringsTest {

    @Test
    public void should_find_greatest_common_divisor() {
        GreatestCommonDivisorOfStrings commonDivisor = new GreatestCommonDivisorOfStrings();
        assertTrue(commonDivisor.isDivisor("ABABABAB", "AB"));

        assertEquals("ABC", commonDivisor.gcdOfStrings("ABCABC", "ABC"));
        assertEquals("AB", commonDivisor.gcdOfStrings("ABABAB", "ABAB"));
        assertEquals("", commonDivisor.gcdOfStrings("LEET", "CODE"));
    }
}