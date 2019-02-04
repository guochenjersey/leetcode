package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class MagicSquareInGridTest {

    @Test
    public void should_find_magic_square() {
        int[][] square = {{10, 3, 5}, {1, 6, 11}, {7, 9, 2}};
        MagicSquareInGrid magicSquareInGrid
                = new MagicSquareInGrid();
        int res = magicSquareInGrid.numMagicSquaresInside(square);
        assertEquals(0, res);
    }
}