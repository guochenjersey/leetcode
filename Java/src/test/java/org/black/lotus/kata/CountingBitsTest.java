package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountingBitsTest {

    @Test
    public void should_find_counting_bits() {
        CountingBits countingBits = new CountingBits();
        int[] res = countingBits.countBits(2);
        int[] expectedRes = {0, 1, 1};
        assertArrayEquals(expectedRes, res);
    }
}