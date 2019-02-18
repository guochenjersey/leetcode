package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInAStringIIITest {

    @Test
    public void should_reverse_words() {
        ReverseWordsInAStringIII reverseWordsInAStringIII = new ReverseWordsInAStringIII();
        String res = reverseWordsInAStringIII.reverseWords("Let's take LeetCode contest");
        assertEquals("s'teL ekat edoCteeL tsetnoc", res);
    }

    @Test
    public void should_swap() {
        String s = "abc's 111";
        char[] chars = s.toCharArray();

        for (int i = 0, j = chars.length - 1; i < j; ++i, --j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }

        assertEquals("111 s'cba", new String(chars));
    }
}