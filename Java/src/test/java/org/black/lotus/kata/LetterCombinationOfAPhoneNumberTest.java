package org.black.lotus.kata;

import org.black.lotus.marker.TLESolution;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LetterCombinationOfAPhoneNumberTest {

    @Test
    public void should_combine_letter_of_phone_number() {
        LetterCombinationOfAPhoneNumber letterCombinationOfAPhoneNumber = new LetterCombinationOfAPhoneNumber();
        List<String> results = letterCombinationOfAPhoneNumber.letterCombinations("23");
        List<String> expectedRes = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

        assertEquals(expectedRes, results);

        results = letterCombinationOfAPhoneNumber.letterCombinations("22");
        System.out.println(results);
    }
}