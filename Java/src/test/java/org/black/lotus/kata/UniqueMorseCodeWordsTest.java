package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueMorseCodeWordsTest {

  @Test
  public void should_find_unique_morse_codes() {
    String[] words = {"gin", "zen", "gig", "msg"};
    UniqueMorseCodeWords morseCodeWords = new UniqueMorseCodeWords();
    int res = morseCodeWords.uniqueMorseRepresentations(words);
    assertEquals(2, res);
  }
}
