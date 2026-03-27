package com.problemsolving.BinarySearch.hard.findPeakElemenetII;

public class FindPeakElementII {
    private int maxElement(int[][] matrix, int col) {
        int n = matrix.length;
        int max = Integer.MIN_VALUE;
        int index = -1;

        /*
         * Iterate through each row to find the maximum element in the specified column
         * col
         */
        for (int i = 0; i < n; i += 1) {
            if (matrix[i][col] > max) {
                max = matrix[i][col];
                index = i;
            }
        }
        return index;
    }

    /*
     * Function to find a peak element
     * in the 2D matrix using binary search
     */
    public int[] findPeakGrid(int[][] matrix) {
        // Get number of rows
        int rows = matrix.length;

        // get number of columns
        int cols = matrix[0].length;

        // Initialize lower and upper bound for binary search (start from top left
        // corner (0,m-1 => (first row, last col))
        int low = 0, high = cols - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            /*
             * Find the index of the row with the
             * maximum element in the middle column
             */
            int row = maxElement(matrix, mid);

            /*
             * Since the maxElement returns the row having maximum element in the specified
             * column. So element below and above this row will be smaller than element at
             * that particular row and column specified by mid index. So to find peak
             * element we have to check if element to it's left and right are also smaller
             * than that particular element.For element at matrix matrix[row][col] to be the
             * peak element it needs to be greater than it's adjacent element. That is it's
             * top, bottom, left, right
             * 
             * So determine element to left and right of the middle element in the found row
             */

            int left = mid - 1 >= 0 ? matrix[row][mid - 1] : Integer.MIN_VALUE;
            int right = mid + 1 < cols ? matrix[row][mid + 1] : Integer.MIN_VALUE;

            /*
             * Check if the mid element is greater than it's neighbors also
             */

            if (matrix[row][mid] > left && matrix[row][mid] > right) {
                return new int[] { row, mid };
            } else if (left > matrix[row][mid]) {
                // Since left is greater than so anything to right of mid will be smaller than
                // mid so eliminate right half and move to left
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        // Return -1 if no peak element is found
        return new int[] { -1, -1 };
    }
}
