package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInRoatatedSortedArrayIITest {

    @Test
    public void should_find_in_rotated_array() {
        int[] source = {2, 5, 6, 0, 0, 1, 2};
        int[] source2 = {3, 1, 1};
        int[] source3 = {1, 3, 1, 1, 1};
        int[] source4 = {1, 1, 3, 1};
        SearchInRoatatedSortedArrayII searchInRoatatedSortedArrayII = new SearchInRoatatedSortedArrayII();
        assertTrue(searchInRoatatedSortedArrayII.search(source, 0));
        assertFalse(searchInRoatatedSortedArrayII.search(source, 3));
        assertTrue(searchInRoatatedSortedArrayII.search(source2, 3));
        assertTrue(searchInRoatatedSortedArrayII.search(source3, 3));
        assertTrue(searchInRoatatedSortedArrayII.search(source4, 3));
    }
}