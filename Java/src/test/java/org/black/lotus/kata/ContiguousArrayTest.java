package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContiguousArrayTest {

    @Test
    public void should_find_contiguous_array() {
        int[] array = {0, 1};
        int[] array1 = {0, 1, 0};

        ContiguousArray contiguousArray = new ContiguousArray();

        assertEquals(2, contiguousArray.findMaxLength(array));
        assertEquals(2, contiguousArray.findMaxLength(array1));
    }
}