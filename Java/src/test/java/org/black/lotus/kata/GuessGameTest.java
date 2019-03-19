package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class GuessGameTest {

    @Test
    public void should_find_num() {
        GuessGame guessGame = new GuessGame();
        assertEquals(8, guessGame.guessNumber(10));
    }
}