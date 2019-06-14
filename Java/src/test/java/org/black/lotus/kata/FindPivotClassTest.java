package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindPivotClassTest {

    @Test
    public void should_find_pivot() {
        int[] src = {1, 7, 3, 6, 5, 6};
        FindPivotClass findPivotClass = new FindPivotClass();
        assertEquals(3, findPivotClass.pivotIndex(src));
    }
}