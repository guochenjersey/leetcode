package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class HammingDistanceTest {

  @Test
  public void should_find_hamming_distance() {
    int x = 1, y = 4;
    HammingDistance hammingDistance = new HammingDistance();
    int res = hammingDistance.hammingDistance(x, y);
  }
}
