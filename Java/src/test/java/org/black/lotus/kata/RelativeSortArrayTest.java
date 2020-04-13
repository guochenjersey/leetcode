package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class RelativeSortArrayTest {

    @Test
    public void should_find_relative_sort_array() {
        int[] toSort = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] template = {2, 1, 4, 3, 9, 6};
        int[] expected = {2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19};
        RelativeSortArray relativeSortArray = new RelativeSortArray();

        int[] actuals = relativeSortArray.relativeSortArray(toSort, template);
        assertArrayEquals(expected, actuals);
    }
}