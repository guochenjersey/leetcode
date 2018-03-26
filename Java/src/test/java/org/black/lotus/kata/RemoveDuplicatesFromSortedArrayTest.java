package org.black.lotus.kata;

import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void should_handle_duplicate() {
        Integer i = -1;
        BitSet bitSet = new BitSet(2);
        bitSet.set(Integer.MAX_VALUE);
        int i1 = bitSet.nextSetBit(Integer.MAX_VALUE - 1);
        System.out.println(i1);
        System.out.print(Integer.MAX_VALUE);
    }
}