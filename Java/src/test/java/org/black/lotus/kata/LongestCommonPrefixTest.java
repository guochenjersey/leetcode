package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {

    @Test
    public void should_find_longest_common_prefix() {
        String[] source = {"flower", "flow", "flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String res = longestCommonPrefix.longestCommonPrefix(source);

        assertEquals("fl", res);
    }
}