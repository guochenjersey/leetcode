package org.black.lotus.kata;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseBitsTest {

    @Test
    @Ignore
    public void should_reverse_1() {
        ReverseBits reverseBits = new ReverseBits();
        int res = reverseBits.reverseBits(43261596);
        assertEquals(Integer.reverse(43261596), res);
    }

    @Test
    public void bit_test() {
        System.out.println(Integer.parseInt("00000010100101000001111010011100", 2));
    }
}