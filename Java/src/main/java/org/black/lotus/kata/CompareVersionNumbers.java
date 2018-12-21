package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p>
 * Example 1:
 * <p>
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 2:
 * <p>
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 3:
 * <p>
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 *
 * My solution doesn't seem elegant. Need to check online.
 */
@LeetCode
@FirstRound
@Medium
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] part1 = version1.split("\\.");
        String[] part2 = version2.split("\\.");
        int i = 0, j = 0;
        for (; i < part1.length && j < part2.length; ++i, ++j) {
            Integer s1Version = Integer.parseInt(stripLeadingZero(part1[i]));
            Integer s2Version = Integer.parseInt(stripLeadingZero(part2[j]));

            if (s1Version == s2Version) {
                continue;
            }

            if (s1Version > s2Version) {
                return 1;
            }

            return -1;
        }

        while (i < part1.length) {
            if (Integer.parseInt(stripLeadingZero(part1[i])) > 0){
                return 1;
            }
            ++i;
        }

        while (j < part2.length) {
            if (Integer.parseInt(stripLeadingZero(part2[j])) > 0) {
                return -1;
            }
            ++j;
        }

        return 0;
    }

    private String stripLeadingZero(String s) {
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int i = 0; i < s.length(); ++i) {
            if (!Character.isDigit(s.charAt(i)) || (s.charAt(i) == '0' && leadingZero)) {
                continue;
            }
            sb.append(s.charAt(i));
            leadingZero = false;
        }

        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
