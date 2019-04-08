package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the prime number n, output the number of prime numbers
 *
 * <p>Notice n <= 100000 The prime number is defined as a natural number greater than 1, and there
 * are no other factors except 1 and it itself. Example Given n = 3, return 2.
 *
 * <p>explanation: [2,3,5], 3 is the second prime number. Given n = 11, return 5.
 *
 * <p>explanation: [2,3,5,7,11], 11 is the fifth prime number. Tags
 *
 * <p>TODO
 */
@FirstRound
@Easy
@LintCode
public class KthPrimeNumber {

  public int kthPrime(int n) {

      Set<Integer> nonPrimeNumbers = new HashSet<>();
      Set<Integer> primeNumbers = new HashSet<>();
      for (int i = 2; i <= n; ++i) {
          if (!nonPrimeNumbers.contains(i)) {
              primeNumbers.add(i);
          }
          int t = n / i;
          for (int j = 2; j <= t; ++j) {
              nonPrimeNumbers.add(i * j);
          }
      }
      return primeNumbers.size();
  }
}
