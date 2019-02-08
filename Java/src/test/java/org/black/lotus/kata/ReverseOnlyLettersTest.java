package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseOnlyLettersTest {

    @Test
    public void should_reverse_letter() {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        String res = reverseOnlyLetters.reverseOnlyLetters("ab-cd");
        assertEquals("dc-ba", res);

        assertEquals("j-Ih-gfE-dCba", reverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}