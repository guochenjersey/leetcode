package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerToRomanTest {

    @Test
    public void should_integer_to_roman() {
        IntegerToRoman integerToRoman
                = new IntegerToRoman();

        assertEquals("III", integerToRoman.intToRoman(3));
        assertEquals("IV", integerToRoman.intToRoman(4));
        assertEquals("IX", integerToRoman.intToRoman(9));
        assertEquals("LVIII", integerToRoman.intToRoman(58));
    }
}