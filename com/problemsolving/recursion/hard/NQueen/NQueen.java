package hard.NQueen;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    /* helper function to check if it's safe to place a queen at board[row][col] */
    private boolean isSafeToPlaceQueen(List<String> board, int row, int col) {
        int r = row, c = col;

        int cols = board.get(0).length();
        /* check for the upper left diagonal */
        while (r >= 0 && c >= 0) {
            /*
             * where board may look like this for a 4 x 4 board
             * "Q..."
             * "...Q"
             * ".Q.."
             * "..Q."
             * a board is a list of string
             * where each element of the list may look like this "Q..."
             */
            if (board.get(r).charAt(c) == 'Q')
                return false;
            r -= 1;
            c -= 1;
        }

        /*
         * since at the end of above while r has gone below 0 and c is >= n so
         * reset to the original position to check for right top diagonal and top
         */
        r = row;
        c = col;

        /* check for the right diagonal */
        while (r >= 0 && c < cols) {
            if (board.get(r).charAt(c) == 'Q')
                return false;
            r -= 1;
            c += 1;
        }

        // reset to original position
        r = row;
        c = col;

        /* check for top */
        while (r >= 0) {
            if (board.get(r).charAt(c) == 'Q')
                return false;
            r -= 1;
        }

        /*
         * if no queens are found for given
         * [row, col] combination in top right diagonal to that cell, top left diagonal
         * and in on top of [row,col]
         * return true
         */
        return true;
    }

    /* recursive function to place queens on the board */
    private void recursiveSolveNQueens(int row, List<List<String>> result, List<String> board) {
        /* if all columns are filled, add the solution to the answer */
        if (row == board.size()) {
            result.add(board);
            return;
        }

        /* try placing queen in each col for that given row = row */
        for (int col = 0; col < board.get(0).length(); col += 1) {
            if (isSafeToPlaceQueen(board, row, col)) {
                /* if it is safe place the queen */
                char[] rowArr = board.get(row).toCharArray();
                rowArr[col] = 'Q';
                board.set(row, new String(rowArr));

                /* recursively place queen in the next row */
                recursiveSolveNQueens(row++, result, board);

                /* remove the queen and backtrack */
                rowArr[col] = '.';
                board.set(row, new String(rowArr));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        List<String> board = new ArrayList<>();
        /*
         * intialize the board with empty cell
         * and an empty is cell is identified by a '.' character. We can use other
         * character as well to identify an empty cell. If we add a '.' to denote an
         * empty cell it will help us avoid null pointer exception
         */
        for (int i = 0; i < n; i += 1) {
            board.add(".".repeat(n));
        }

        /* start placing queen from the first row */
        recursiveSolveNQueens(0, ans, board);
        return ans;
    }
}
