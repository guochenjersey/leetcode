package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordPatternTest {

  @Test
  public void should_handle_abba() {
    String pattern = "abba";
    String string = "dog cat cat dog";
    WordPattern wordPattern = new WordPattern();
    boolean res = wordPattern.wordPattern(pattern, string);
    assertEquals(true, res);
  }
}
