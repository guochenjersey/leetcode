package org.black.lotus.kata;

public class SortLettersByCase {
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }

        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (Character.isLowerCase(chars[start])) {
                ++start;
                continue;
            }
            while (Character.isUpperCase(chars[end])) {
                --end;
            }
            if (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                ++start;
                --end;
            }
        }
    }
}
