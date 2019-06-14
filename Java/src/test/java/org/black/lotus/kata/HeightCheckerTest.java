package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeightCheckerTest {

    @Test
    public void should_find_min_move() {
        int[] src = {1,1,4,2,1,3};
        HeightChecker heightChecker = new HeightChecker();
        assertEquals(3, heightChecker.heightChecker(src));
    }
}