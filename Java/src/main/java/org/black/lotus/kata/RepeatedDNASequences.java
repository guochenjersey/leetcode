package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.black.lotus.marker.*;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example:
 * "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the
 * DNA.
 *
 * <p>Write a function to find all the 10-letter-long sequences (substrings) that occur more than
 * once in a DNA molecule.
 *
 * <p>Example:
 *
 * <p>Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * <p>Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
@LeetCode
@Medium
@FirstRound
@Google
@Accepted
public class RepeatedDNASequences {

  public List<String> findRepeatedDnaSequences(String s) {
    if (s == null || s.length() == 0) {
      return new ArrayList<>();
    }
    Set<String> subStringSet = new HashSet<>();
    Set<String> res = new HashSet<>();
    for (int i = 0; i < s.length(); ++i) {
      // pay attention to the substring method
      if (i + 10 <= s.length()) {
        String sub = s.substring(i, i + 10);
        if (subStringSet.contains(sub)) {
          res.add(sub);
        } else {
          subStringSet.add(sub);
        }
      }
    }

    return new ArrayList<>(res);
  }
}
