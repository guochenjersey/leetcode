package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortLettersByCaseTest {

  @Test
  public void should_sort_letters_by_case() {
    char[] chars = "abAcD".toCharArray();
    SortLettersByCase sortLettersByCase = new SortLettersByCase();
    sortLettersByCase.sortLetters(chars);
  }
}
