package org.black.lotus.kata;

import com.sun.tools.javac.comp.Check;
import org.black.lotus.marker.DFS;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NeedToSubmit;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
@LeetCode
@Medium
@DFS
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                boolean res = helper(visited, board, i, j, words, 0);
                if (res) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean helper(boolean[][] visited,
                           char[][] board,
                           int i,
                           int j,
                           char[] words,
                           int wordsIdx) {
        if (!validRow(i, board) || !validColumn(j, board)) {
            return false;
        }

        if (visited[i][j]) {
            return false;
        }

        boolean sameChar = board[i][j] == words[wordsIdx];

        if (sameChar && wordsIdx == words.length -1) {
            return true;
        }

        boolean res = false;
        visited[i][j] = true;
        if (sameChar) {
            res = helper(visited, board, i + 1, j, words, wordsIdx + 1)
                    || helper(visited, board, i - 1, j, words, wordsIdx + 1)
                    || helper(visited, board, i, j + 1, words, wordsIdx + 1)
                    || helper(visited, board, i, j - 1, words, wordsIdx + 1);
        }

        visited[i][j] = false;

        return res;
    }

    private boolean validRow(int i, char[][] board) {
        return i >= 0 && i < board.length;
    }

    private boolean validColumn(int j, char[][] board) {
        return j >= 0 && j < board[0].length;
    }

    class CheckedStatus {
        int i;
        int j;
        int k;

        CheckedStatus(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CheckedStatus that = (CheckedStatus) o;

            if (i != that.i) return false;
            if (j != that.j) return false;
            return k == that.k;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            result = 31 * result + k;
            return result;
        }
    }
}
