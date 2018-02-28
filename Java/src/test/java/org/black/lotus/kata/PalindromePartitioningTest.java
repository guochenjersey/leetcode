package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PalindromePartitioningTest {

  private PalindromePartitioning palindromePartitioning;

  @Before
  public void setUp() {
    palindromePartitioning = new PalindromePartitioning();
  }

  @Test
  public void should_able_to_check_palindrome() {
    String s = "aba";
    assertEquals(true, palindromePartitioning.isPalindrome(s));

    s = "abba";
    assertEquals(true, palindromePartitioning.isPalindrome(s));

    s = "";
    assertEquals(true, palindromePartitioning.isPalindrome(s));

    s = "ado";
    assertEquals(false, palindromePartitioning.isPalindrome(s));
  }
}