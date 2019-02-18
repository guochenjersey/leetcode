package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestWordInDictionaryTest {

    @Test
    public void should_find_longest_word() {
        String[] dictonaryWords = new String[]{"world", "bb", "wo", "wor", "worl"};
        LongestWordInDictionary trieTree = new LongestWordInDictionary();
        System.out.println(trieTree.longestWord(dictonaryWords));
    }
}