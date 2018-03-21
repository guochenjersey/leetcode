package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortLettersByCaseTest {

    @Test
    public void should_sort_letters_by_case() {
        char[] chars = "abAcD".toCharArray();
        SortLettersByCase sortLettersByCase = new SortLettersByCase();
        sortLettersByCase.sortLetters(chars);

    }
}