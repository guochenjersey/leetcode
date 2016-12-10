package org.black.lotus;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * TODO verify in leet
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.

 Subscribe to see which companies asked this question
 */
public class Kata125 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        String filteredString = extractAlphanumeric(s);
        int tail = filteredString.length() - 1, head = 0;
        while (head <= tail) {
            if (Character.toUpperCase(filteredString.charAt(head)) == Character.toUpperCase(filteredString.charAt(tail))) {
                ++head;
                --tail;
            } else {
                return false;
            }
        }

        return true;
    }

    private String extractAlphanumeric(String original) {
        char[] chars = original.toCharArray();
        List<Character> characterList = new LinkedList<Character>();
        for (char c : chars) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                characterList.add(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : characterList) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
