package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class PerfectSquareTest {

    @Test
    public void should_find_perfect_square() {
        System.out.println(Math.sqrt(9));
        System.out.println((int) Math.sqrt(26));
        PerfectSquare perfectSquare = new PerfectSquare();
        assertEquals(1, perfectSquare.numSquares(16));
        assertEquals(3, perfectSquare.numSquares(12));
        assertEquals(2, perfectSquare.numSquares(13));

    }
}