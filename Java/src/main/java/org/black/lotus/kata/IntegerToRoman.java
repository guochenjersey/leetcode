package org.black.lotus.kata;

import java.util.TreeMap;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * <p>Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, two is written as II in Roman
 * numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The
 * number twenty seven is written as XXVII, which is XX + V + II.
 *
 * <p>Roman numerals are usually written largest to smallest from left to right. However, the
 * numeral for four is not IIII. Instead, the number four is written as IV. Because the one is
 * before the five we subtract it making four. The same principle applies to the number nine, which
 * is written as IX. There are six instances where subtraction is used:
 *
 * <p>I can be placed before V (5) and X (10) to make 4 and 9. X can be placed before L (50) and C
 * (100) to make 40 and 90. C can be placed before D (500) and M (1000) to make 400 and 900. Given
 * an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to
 * 3999.
 *
 * <p>Example 1:
 *
 * <p>Input: 3 Output: "III" Example 2:
 *
 * <p>Input: 4 Output: "IV" Example 3:
 *
 * <p>Input: 9 Output: "IX" Example 4:
 *
 * <p>Input: 58 Output: "LVIII" Explanation: L = 50, V = 5, III = 3. Example 5:
 *
 * <p>Input: 1994 Output: "MCMXCIV" Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
@LeetCode
@Medium
@FirstRound
@Accepted
public class IntegerToRoman {

  public String intToRoman(int num) {
    TreeMap<Integer, String> numToRomanMap = new TreeMap<>();
    numToRomanMap.put(1, "I");
    numToRomanMap.put(5, "V");
    numToRomanMap.put(10, "X");
    numToRomanMap.put(50, "L");
    numToRomanMap.put(100, "C");
    numToRomanMap.put(500, "D");
    numToRomanMap.put(1000, "M");
    numToRomanMap.put(4, "IV");
    numToRomanMap.put(9, "IX");
    numToRomanMap.put(40, "XL");
    numToRomanMap.put(90, "XC");
    numToRomanMap.put(400, "CD");
    numToRomanMap.put(900, "CM");

    StringBuilder res = new StringBuilder();
    if (num / 1000 != 0) {
      int p = (num / 1000);
      for (int i = 0; i < p; ++i) {
        res.append("M");
      }
      num %= 1000;
    }

    if (num / 100 != 0) {
      int p = (num / 100) * 100;
      while (p != 0) {
        res.append(numToRomanMap.get(numToRomanMap.floorKey(p)));
        p -= numToRomanMap.floorKey(p);
      }
      num %= 100;
    }

    if (num / 10 != 0) {
      int p = (num / 10) * 10;
      while (p != 0) {
        res.append(numToRomanMap.get(numToRomanMap.floorKey(p)));
        p -= numToRomanMap.floorKey(p);
      }
      num %= 10;
    }

    while (num != 0) {
      res.append(numToRomanMap.get(numToRomanMap.floorKey(num)));
      num -= numToRomanMap.floorKey(num);
    }

    return res.toString();
  }
}
