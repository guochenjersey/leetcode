package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionEqualSubsetSumTest {

    @Test
    public void should_find_partition() {
        int[] source = {1, 5, 11, 5};
        PartitionEqualSubsetSum partitionEqualSubsetSum
                = new PartitionEqualSubsetSum();

        assertTrue(partitionEqualSubsetSum.canPartition(source));

        source = new int[]{1, 2, 3, 5};
        assertFalse(partitionEqualSubsetSum.canPartition(source));

        source = new int[] {100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        assertTrue(partitionEqualSubsetSum.canPartition(source));
    }


}