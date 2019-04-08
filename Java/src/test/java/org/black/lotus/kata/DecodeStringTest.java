package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeStringTest {

    @Test
    public void should_decode_string() {
        DecodeString decodeString = new DecodeString();
        assertEquals("aaabcbc", decodeString.decodeString("3[a]2[bc]"));
        assertEquals("abcabccdcdcdef", decodeString.decodeString("2[abc]3[cd]ef"));
        assertEquals("accaccacc", decodeString.decodeString("3[a2[c]]"));
    }
}