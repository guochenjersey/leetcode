package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

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