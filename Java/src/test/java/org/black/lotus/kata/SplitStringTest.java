package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class SplitStringTest {

  @Test
  public void should_list_all_probablities() {
    SplitString splitString = new SplitString();
    List<List<String>> res = splitString.splitString("123");
    res.stream()
        .forEach(
            list -> {
              list.stream().forEach(System.out::println);
            });
  }
}
