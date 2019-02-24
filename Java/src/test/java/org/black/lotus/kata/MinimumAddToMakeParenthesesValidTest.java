package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumAddToMakeParenthesesValidTest {

    @Test
    public void should_find_minium() {
        MinimumAddToMakeParenthesesValid min
                = new MinimumAddToMakeParenthesesValid();
        assertEquals(1, min.minAddToMakeValid("())"));

        assertEquals(3, min.minAddToMakeValid("((("));

    }
}