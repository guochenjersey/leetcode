package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedArrayIITest {
    @Test
    public void should_remove_duplicate() {
        int nums[] = {-14, -14, -14, -14, -14, -14, -14, -13, -13, -13, -13, -12, -11, -11, -11, -9, -9, -9, -7, -7, -7, -6, -6, -5, -5, -5, -4, -4, -4, -3, -3, -3, -2, -2, -2, -1, -1, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 11, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 15, 16, 17, 18, 18, 18, 20, 20, 21, 21, 21, 21, 21, 22, 22, 22, 22, 23, 24, 24, 25};
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII
                = new RemoveDuplicatesFromSortedArrayII();
        removeDuplicatesFromSortedArrayII.removeDuplicates(nums);
    }
}