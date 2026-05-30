package hard.wordsearch;

public class WordSearch {
    private boolean recursiveWordSearch(char[][] board, int row, int col, String word, int idx) {
        int n = word.length();

        /* if all the characters of the word is found */
        if (idx == n) {
            return true;
        }

        /*
         * Boundary conditions and character mismatch check
         * row < 0 means it is out of upper bound i.e first row
         * row >= n means it is out of lower bound i.e last row
         * col < 0 means col is out of left bound i.e left col
         * col >= board[0].length means it is out of right bound i.e extreme right col
         */
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || word.charAt(idx) != board[row][col]) {
            return false;
        }

        char temp = board[row][col];
        /* temporarily mark the cell as visited */
        board[row][col] = ' ';

        /*
         * for a given board[row][col] element
         * it's top element is board[row-1][col]
         * bottom element is board[row+1][col]
         * left elemetn is board[row][col-1]
         * right element is board[row][col+1]
         */
        boolean ans = recursiveWordSearch(board, row - 1, col, word, idx + 1)
                || recursiveWordSearch(board, row + 1, col, word, idx + 1)
                || recursiveWordSearch(board, row, col - 1, word, idx + 1)
                || recursiveWordSearch(board, row, col + 1, word, idx + 1);

        /* backtrack : restore the original character in the cell */
        board[row][col] = temp;
        return ans;
    }

    /* Main function to check if the word exists in the board */
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        /* Iterate through each cell in the board */
        for (int row = 0; row < rows; row += 1) {
            for (int col = 0; col < cols; col += 1) {
                /*
                 * if the first character of the word matches with the character in that cell
                 * then start a recursive search
                 */
                if (board[row][col] == word.charAt(0)) {
                    /* if the word is found return true */
                    if (recursiveWordSearch(board, row, col, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
