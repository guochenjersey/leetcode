package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Check leetcode for the soduku detail.
 * */
@LeetCode
@FirstRound
@Medium
public class ValidSoduku {
    public boolean isValidSudoku(char[][] board) {
        // 每一个大循环确定一行，一列，一个九宫格
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<Character>();
            Set<Character> col = new HashSet<Character>();
            Set<Character> cube = new HashSet<Character>();

            for (int j = 0; j < 9; j++) {
                // 第i行
                if (board[i][j] != '.' && !row.add(board[i][j]))
                    return false;
                // 第i列
                if (board[j][i] != '.' && !col.add(board[j][i]))
                    return false;
                //
                int cubeRow = 3 * (i / 3) + j / 3, cubeCol = 3 * (i % 3) + j % 3; // key part, index calculation
                if (board[cubeRow][cubeCol] != '.' && !cube.add(board[cubeRow][cubeCol]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
        System.out.println(1 / 3);
    }
}
