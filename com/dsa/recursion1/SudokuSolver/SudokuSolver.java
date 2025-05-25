package com.dsa.recursion1.SudokuSolver;

public class SudokuSolver {
    public boolean isSafe(char[][] board, int row, int col, char digit) {
        for (int i = 0; i < board.length; i += 1) {
            if (board[i][col] == digit || board[row][i] == digit) {
                return false;
            }
        }
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i += 1) {
            for (int j = boxColStart; j < boxColStart + 3; j += 1)
                if (board[i][j] == digit) {
                    return false;
                }
        }
        return true;
    }

    public boolean solveSudokuUtil(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < m; j += 1) {
                if (board[i][j] == '.') {
                    for (char digit = '1'; digit <= '9'; digit += 1) {
                        if (isSafe(board, i, j, digit)) {
                            board[i][j] = digit;
                            if (solveSudokuUtil(board)) {
                                return true;
                            } else {
                                board[i][j] = '.'; // Backtrack
                            }
                        }
                    }
                    return false; // If no digit can be placed, return false
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solveSudokuUtil(board);
    }
}
