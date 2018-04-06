package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInAStringTest {

    @Test
    public void should_reverse_a_string() {
        String source = " will s block chain change this world?  ";
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        String reversedString = reverseWordsInAString.reverse(source);
        assertEquals("world? this change chain block s will", reversedString);
    }

    @Test
    public void should_reverse_a_single_word() {
        String source = "world";
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        String reversedString = reverseWordsInAString.reverse(source);
        assertEquals("world", reversedString);
    }



    @Test
    public void should_reverse_a_long_string() {
        String source = "will s block chain change this world?  ";
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        String reversedString = reverseWordsInAString.reverse(source);
        assertEquals("world? this change chain block s will", reversedString);
    }
}