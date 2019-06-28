package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInRotatedSortedArrayTest {

    @Test
    public void should_find_search_roated() {
        int[] num1 ={7, 8, 9, 1, 2, 3, 4};
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();

        assertEquals(2, searchInRotatedSortedArray.search(num1, 9));
        assertEquals(5, searchInRotatedSortedArray.search(num1, 3));
        assertEquals(-1, searchInRotatedSortedArray.search(num1, 10));

        int[] num2 = {3, 5, 1};
        assertEquals(0, searchInRotatedSortedArray.search(num2, 3));
    }
}