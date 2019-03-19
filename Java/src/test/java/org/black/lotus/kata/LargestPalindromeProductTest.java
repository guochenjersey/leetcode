package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestPalindromeProductTest {

  @Test
  public void should_find_palindrome_1() {
    LargestPalindromeProduct largestPalindromeProduct = new LargestPalindromeProduct();
    int res = largestPalindromeProduct.largestPalindrome(2);
    assertEquals(987, res);
  }

  @Test
  public void should_find_palindrome_2() {
    LargestPalindromeProduct largestPalindromeProduct = new LargestPalindromeProduct();
    int res = largestPalindromeProduct.largestPalindrome(3);
    assertEquals(123, res);
  }
}
