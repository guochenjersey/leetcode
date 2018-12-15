package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicateTest {

    @Test
    public void should_find_duplicate() {
        int[] source = {1, 3, 1, 8, 9};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean res = containsDuplicate.containsDuplicate(source);
        assertTrue(res);
    }
}