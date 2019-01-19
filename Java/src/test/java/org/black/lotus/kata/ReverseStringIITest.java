package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringIITest {

    @Test
    public void reverse_string_ii_test() {
        String s = "abcdefg";
        ReverseStringII reverseStringII = new ReverseStringII();
        String res = reverseStringII.reverseStr(s, 2);

        assertEquals("bacdfeg", res);
    }
}