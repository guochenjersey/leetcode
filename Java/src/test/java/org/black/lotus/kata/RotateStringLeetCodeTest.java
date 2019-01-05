package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateStringLeetCodeTest {

    @Test
    public void should_rotate_string() {
        String s1 = "abcde";
        String s2 = "cdeab";
        RotateStringLeetCode rotateStringLeetCode = new RotateStringLeetCode();
        boolean res = rotateStringLeetCode.rotateString(s1, s2);

        assertTrue(res);
    }
}