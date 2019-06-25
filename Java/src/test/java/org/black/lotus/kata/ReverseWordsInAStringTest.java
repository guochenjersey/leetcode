package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseWordsInAStringTest {

  @Test
  public void should_reverse_a_long_string() {
    String source = " will block chain";
    ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
    String reversedString = reverseWordsInAString.reverse(source);
    assertEquals("chain block will", reversedString);
  }
}
