package com.problemsolving.BinarySearch.hard.searchInARowWiseColWiseSortedMatrix.better;

public class SearchInARowWiseColWiseSortedMatrix {

    // Function to search for a given target in the matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows
        int n = matrix.length;

        // Get the number of cols in the matrix
        int m = matrix[0].length;

        // starting from (0,m-1) corner of the matrix
        int row = 0, col = m - 1;

        /*
         * Since row is starting from 0 so traverse till the number of rows present
         * which is n
         * And since col is starting from m-1 so traverse till first col which is 0th
         * index
         */
        while (row < n && col >= 0) {
            if (matrix[row][col] == target)
                return true;

            /*
             * If the element at the cell (row, col) is greater than target, it means
             * smaller elements are needed to reach the target. But col is in increasing
             * order and so it contains only greater elements so eliminate the column by
             * decreasing the current column
             */
            else if (matrix[row][col] > target)
                col -= 1;
            else
                row += 1;
        }
        return false;
    }
}

/*
 * Time complexity : O(n+m)
 * where n is the number of rows in the matrix and m is the number of columns
 * Traversal starts from (0, m-1) , since we are increasing rows and decreasing
 * cols so at most it can end up in (m-1,0). Therefore total distance can be
 * atmost O(n+m)
 */