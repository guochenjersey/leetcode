package org.black.lotus.kata;

import org.black.lotus.marker.*;

/**
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
 *
 * <p>Have you met this question in a real interview? Example For s1 = "aabcc", s2 = "dbbca"
 *
 * <p>When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false. Challenge O(n2)
 * time or better
 *
 * <p>Tags Related Problems
 */
@FirstRound
@LintCode
@Hard
@NotAccepted
@NoIdeaOrBadIdeaInitially
public class InterleavingString {

  public boolean isInterleave(String s1, String s2, String s3) {
    if (isBlank(s1) && isBlank(s2) && isBlank(s3)) {
      return true;
    } else if (isBlank(s1) && isBlank(s2) && !isBlank(s3)) {
      return false;
    }

    int s1Pointer = 0;
    int s2Pointer = 0;
    int s3Pointer = 0;
    int baseS1Pointer = 0;
    int baseS2Pointer = 0;

    for (; s1Pointer < s1.length() && s2Pointer < s2.length(); ) {
      if (s3.charAt(s3Pointer) != s1.charAt(s1Pointer)
          && s3.charAt(s3Pointer) != s2.charAt(s2Pointer)) {
        return false;
      }

      if (s3.charAt(s3Pointer) == s1.charAt(s1Pointer)) {
        ++s3Pointer;
        s2Pointer = baseS2Pointer;
        ++s1Pointer;
        baseS1Pointer = s1Pointer;
      } else if (s3.charAt(s3Pointer) == s2.charAt(s2Pointer)) {
        ++s3Pointer;
        ++s2Pointer;
        baseS2Pointer = s2Pointer;
        s1Pointer = baseS1Pointer;
      }
    }

    if (s3Pointer == s3.length()) {
      return true;
    }

    boolean isS1AllUsed = s1Pointer == s1.length();
    boolean isS2AllUsed = s2Pointer == s2.length();

    if (isS1AllUsed && !isS2AllUsed) {
      return (s3.substring(s3Pointer, s3.length()).equals(s2.substring(s2Pointer, s2.length())));
    }

    if (isS2AllUsed && !isS1AllUsed) {
      return (s3.substring(s3Pointer, s3.length()).equals(s1.substring(s1Pointer, s1.length())));
    }

    return false;
  }

  private boolean isBlank(String s) {
    return s == null || s.length() == 0;
  }
}
