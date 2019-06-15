package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidBoomerangTest {

    @Test
    public void should_find_boomberang() {
        ValidBoomerang validBoomerang = new ValidBoomerang();
        int[][] points = {{1, 1}, {2, 3}, {3, 2}};

        assertTrue(validBoomerang.isBoomerang(points));

        int[][] points2 = {{1, 1}, {2, 2}, {3, 3}};
        assertFalse(validBoomerang.isBoomerang(points2));
    }
}