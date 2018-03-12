package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

/**
 * Count the number of k's between 0 and n. k can be 0 - 9.

 Have you met this question in a real interview?
 Example
 if n = 12, k = 1 in

 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
 we have FIVE 1's (1, 10, 11, 12)

 Tags
 * */

@FirstRound
@LintCode
public class DigitCounts {

    public int digitCounts(int digit, int n) {
        int count = 0;
        for (int i = 0; i < n; ++i) {
            count += findDigit(digit, i);
        }

        return count;
    }

    private int findDigit(int digit, int number) {
        int count = 0;
        // careful about the 0 check.
        if (digit == 0 && number == 0) {
            return ++count;
        }
        while (number > 0) {
            int d = number % 10;
            if (digit == d) {
                ++count;
            }
            number /= 10;
        }

        return count;
    }

    public static void main(String... args) {
        DigitCounts digitCounts = new DigitCounts();
        System.out.println(digitCounts.digitCounts(0, 19));
    }
}
