package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {

    @Test
    public void should_search_word() {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        WordSearch wordSearch = new WordSearch();
        assertTrue(wordSearch.exist(board, "ABCCED"));
        assertTrue(wordSearch.exist(board, "SEE"));
        assertFalse(wordSearch.exist(board, "ABCD"));
    }
}