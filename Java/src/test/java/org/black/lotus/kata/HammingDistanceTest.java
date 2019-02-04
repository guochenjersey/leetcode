package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class HammingDistanceTest {

    @Test
    public void should_find_hamming_distance() {
        int x = 1, y = 4;
        HammingDistance hammingDistance
                = new HammingDistance();
        int res = hammingDistance.hammingDistance(x, y);
    }
}