package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionArrayIntoThreePartsWithEqualSumTest {

    @Test
    public void should_partion_into_three_parts() {
        int[] a1 = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        int[] a2 = {0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
        int[] a3 = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};

        PartitionArrayIntoThreePartsWithEqualSum partitionArrayIntoThreePartsWithEqualSum
                = new PartitionArrayIntoThreePartsWithEqualSum();

        assertTrue(partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(a1));
        assertFalse(partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(a2));
        assertTrue(partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(a3));
    }
}