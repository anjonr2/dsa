package com.problemsolving.BinarySearch.hard.searchInASorted2DMatrix.brute;

public class SearchInASorted2DMatrix {
    /* Function to search for a target value in a sorted matrix */
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get number of rows in the matrix
        int n = matrix.length;

        // Get number of cols in the matrix
        int m = matrix[0].length;

        // Traverse each row
        for (int i = 0; i < n; i += 1) {
            // Traverse each column in the current row
            for (int j = 0; j < m; j += 1) {
                if (matrix[i][j] == target)
                    return true;
            }
        }

        return false;
    }
}
