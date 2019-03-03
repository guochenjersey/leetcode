package org.black.lotus.kata;

import org.black.lotus.marker.*;
import org.black.lotus.marker.Solution;

import java.util.*;

/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 * <p>
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * <p>
 * Example 1:
 * <p>
 * Input: secret = "1807", guess = "7810"
 * <p>
 * Output: "1A3B"
 * <p>
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 * <p>
 * Input: secret = "1123", guess = "0111"
 * <p>
 * Output: "1A1B"
 * <p>
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
@LeetCode
@Medium
@FirstRound
@Accepted(value = "faster than 11% only")
@Google
@NoIdeaOrBadIdeaInitially
public class BullsAndCows {

    @Solution("100%")
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] counter = new int[10];
        int n = secret.length();
        /**
         * 在一圈遍历中，每当遇到重合值，则bulls的数字加一，否则我们将secret number中的数字计数加1，
         * guess number中的数字计数减一。这样的话，如果下一次遇到重复但是位置不同的值，
         * 我们可以知道它是否已经在secret中或是guess中出现过。
         * */
        for (int i = 0; i < n; i++) {
            int s = secret.charAt(i) - '0'; // 确定数字字符转数字方法.
            int g = guess.charAt(i) - '0';
            if (s == g)
                bulls++;
            else {
                if (counter[g] > 0) cows++;
                if (counter[s] < 0) cows++;
                counter[s]++;
                counter[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    @Solution("11%")
    public String getHintSlow(String secret, String guess) {
        Map<Character, Set<Integer>> positionMap = new HashMap<>();
        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        for (int i = 0; i < secretChars.length; ++i) {
            positionMap.putIfAbsent(secretChars[i], new HashSet<>());
            positionMap.get(secretChars[i]).add(i);
        }

        int bullCount = 0;
        int cowCount = 0;
        for (int i = 0; i < guessChars.length; ++i) {
            Set<Integer> posSet = positionMap.get(guessChars[i]);
            if (posSet != null) {
                if (posSet.contains(i)) {
                    ++bullCount;
                    posSet.remove(i);
                } else {
                    if (posSet.size() != 0) {
                        for (Iterator<Integer> pos = posSet.iterator(); pos.hasNext(); ) {
                            Integer p = pos.next();
                            if (secretChars[p] != guessChars[p]) {
                                ++cowCount;
                                pos.remove();
                                break;
                            }
                        }
                    }
                }
            }
        }

        return bullCount + "A" + cowCount + "B";
    }
}
