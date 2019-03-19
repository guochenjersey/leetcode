package org.black.lotus;

import java.util.Arrays;
import java.util.List;

public class Kata95 {

  public static void main(String... args) {
    List<String> myString = Arrays.asList("abc", "def");
    String joinedString = String.join(",", myString);
    System.out.println(joinedString);
  }
}
