package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class SerachA2DMatrixTest {

    @Test
    public void should_find_target() {
        int[][] array = {
                {0, 1, 2, 3, 4, 5, 6},
                { 8, 9, 10, 11, 12}
        };


        SerachA2DMatrix serachA2DMatrix = new SerachA2DMatrix();
        boolean result = serachA2DMatrix.search(array, 10);
        assertTrue(result);

        assertFalse(serachA2DMatrix.search(array, 7));
    }
}