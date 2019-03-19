package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class GuessGameTest {

  @Test
  public void should_find_num() {
    GuessGame guessGame = new GuessGame();
    assertEquals(8, guessGame.guessNumber(10));
  }
}
