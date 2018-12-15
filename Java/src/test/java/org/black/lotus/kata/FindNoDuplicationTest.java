package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindNoDuplicationTest {

    @Test
    public void should_find_duplicate() {
        int[] source = {1, 1, 2, 2, 3};
        FindNoDuplication findNoDuplication = new FindNoDuplication();
        int res = findNoDuplication.findNoDuplication(source);
        assertEquals(3, res);
    }
}