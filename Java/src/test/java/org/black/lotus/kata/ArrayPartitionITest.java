package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayPartitionITest {

    @Test
    public void array_partition() {
        ArrayPartitionI partitionI = new ArrayPartitionI();
        int[] src = {2, 3, 1, 4};
        assertEquals(4, partitionI.arrayPairSum(src));
    }
}