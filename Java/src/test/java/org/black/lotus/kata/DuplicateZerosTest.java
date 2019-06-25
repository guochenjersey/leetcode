package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateZerosTest {

    @Test
    public void should_duplicate_zero() {
        int[] source = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] expected = {1, 0, 0, 2, 3, 0, 0, 4};
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        duplicateZeros.duplicateZeros(source);

        assertArrayEquals(expected, source);
    }
}