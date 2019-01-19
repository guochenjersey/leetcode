package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringTest {

    @Test
    public void should_reverse() {
        String s = "A man, a plan, a canal: Panama";
        ReverseString reverseString = new ReverseString();
        String res = reverseString.reverseString(s);

        assertEquals("amanaP :lanac a ,nalp a ,nam A", res);
    }
}