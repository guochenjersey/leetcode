package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlipAnImageTest {

    @Test
    public void should_flip_image() {
        int[][] array = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        FlipAnImage flipAnImage = new FlipAnImage();
        int[][] res = flipAnImage.flipAndInvertImage(array);
        int[][] expectedRes = {{1, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        assertArrayEquals(expectedRes, res);
    }
}