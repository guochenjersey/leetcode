package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckIfWordIsValidAfterSubsitutionsTest {

    @Test
    public void should_check_if_word_is_valid() {
        CheckIfWordIsValidAfterSubsitutions checkIfWordIsValidAfterSubsitutions = new CheckIfWordIsValidAfterSubsitutions();
        assertTrue(checkIfWordIsValidAfterSubsitutions.isValid("aabcbc"));
        assertTrue(checkIfWordIsValidAfterSubsitutions.isValid("abcabcababcc"));
        assertFalse(checkIfWordIsValidAfterSubsitutions.isValid("abccba"));
        assertFalse(checkIfWordIsValidAfterSubsitutions.isValid("cababc"));
    }
}