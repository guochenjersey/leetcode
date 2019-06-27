package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxChunksToMakeSortedTest {

    @Test
    public void should_find_max_chunks() {
        int[] source1 = {4, 3, 2, 1, 0};
        int[] source2 = {1, 0, 2, 3, 4};
        int[] source3 = {1, 2, 0, 3};
        int[] source4 = {0, 3, 1, 2};

        MaxChunksToMakeSorted maxChunksToMakeSorted = new MaxChunksToMakeSorted();

        assertEquals(1, maxChunksToMakeSorted.maxChunksToSorted(source1));
        assertEquals(4, maxChunksToMakeSorted.maxChunksToSorted(source2));
        assertEquals(2, maxChunksToMakeSorted.maxChunksToSorted(source4));
        assertEquals(2, maxChunksToMakeSorted.maxChunksToSorted(source3));
    }
}