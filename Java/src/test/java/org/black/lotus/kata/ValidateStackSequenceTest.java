package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateStackSequenceTest {

    @Test
    public void should_find_validate_stack_sequence() {
        ValidateStackSequence validateStackSequence
                = new ValidateStackSequence();
        int[] pushed1 = {1,2,3,4,5};
        int[] poped1 = {4,5,3,2,1};
        assertTrue(validateStackSequence.validateStackSequences(pushed1, poped1));

        int[] pushed2 = {1, 2, 3, 4, 5};
        int[] poped = {4,3,5,1,2};
        assertFalse(validateStackSequence.validateStackSequences(pushed2, poped));

        int[] pushed3 = {2, 1, 0};
        int[] popped = {2, 1, 0};
        assertTrue(validateStackSequence.validateStackSequences(pushed3, popped));
    }
}