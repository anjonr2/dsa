package com.problemsolving.BinarySearch.hard.MatrixMedian.BinarySearchApproach;

public class MatrixMedian {

    // Function to find the upper bound of an element in a sorted row
    private int upperBound(int[] arr, int x, int m) {
        int low = 0, high = m - 1;
        int ans = m;

        while (low <= high) {
            int mid = (low + high) / 2;

            // if arr[mid]>x then it can be a possible upper bound
            if (arr[mid] > x) {
                ans = mid;

                // Look for a smaller upper bound on the left
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int countSmallEqual(int[][] matrix, int n, int m, int x) {
        int cnt = 0;
        for (int i = 0; i < n; i += 1) {
            cnt += upperBound(matrix[i], x, m);
        }
        return cnt;
    }

    // Function to find the median element in the matrix
    public int findMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int row = 0; row < rows; row += 1) {
            // loop through first element/column of each row for overall smallest element
            low = Math.min(low, matrix[row][0]);

            // loop through last element/column of each row for overall smallest element
            high = Math.max(high, matrix[row][cols - 1]);
        }

        int req = (rows * cols) / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int smallEqual = countSmallEqual(matrix, rows, cols, mid);
            if (smallEqual <= req)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
