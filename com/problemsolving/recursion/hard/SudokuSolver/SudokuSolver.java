package hard.SudokuSolver;

public class SudokuSolver {
    public void solveSudokU(char[][] board) {
        solve(board);
    }

    /* Recursive method to solve sudoku */
    private boolean solve(char[][] board) {
        int n = 9; // size of the board

        for (int row = 0; row < n; row += 1) {
            for (int col = 0; col < n; col += 1) {
                /* fill up empty cells with digits */
                if (board[row][col] == '.') {
                    for (char digit = '1'; digit <= '9'; digit += 1) {
                        if (areSudokuRulesMet(board, row, col, digit)) {
                            // place digit
                            board[row][col] = digit;
                            // recur to place next digit
                            if (solve(board)) {
                                return true;
                            } else {
                                // Reset or backtrack if placing digit doesn't solve
                                board[row][col] = '.';
                            }
                        }
                    }
                    /* if no digit can be placed, return false */
                    return false;
                }
            }
        }

        // sudoku solved
        return true;
    }

    // Method to check if placing a digit follows sudoku rules
    private boolean areSudokuRulesMet(char[][] board, int row, int col, char digit) {
        for (int i = 0; i < 9; i += 1) {
            // checks if the digit is already present in row row or in column col
            if (board[row][i] == digit || board[i][col] == digit)
                return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i += 1) {
            for (int j = startCol; j < startCol + 3; j += 1) {
                if (board[i][j] == digit)
                    return false;
            }
        }
        /* digit can be placed */
        return true;
    }
}

/*
 * Time complexity : O(9^E), where E is the number of empty cells
 * As each empty cell can be filled with 1 to 9 digits
 * 
 * Space complexity : O(E) because of the recursive stack space
 */