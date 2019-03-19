package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class CombinationsTest {

  @Test
  public void should_find_all_combinations() {
    Combinations combinations = new Combinations();
    List<List<Integer>> res = combinations.combine(3, 2);
    res.forEach(
        l -> {
          l.forEach(System.out::print);
          System.out.println();
        });
  }
}
