package com.problemsolving.BinarySearch.hard.searchInARowWiseColWiseSortedMatrix.optimal;

/*Traverse each row of the matrix
Since each row is sorted we can find the target element by applying binary search in each row */
public class SearchInARowWiseColWiseSortedMatrix {
    private boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target) {
                // eliminate left half
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // Get rows count of input matrix
        int rows = matrix.length;

        // Get column count of the input matrix
        int cols = matrix[0].length;

        // Traverse through each row
        for (int row = 0; row < rows; row += 1) {
            // check if the target is present in current row
            boolean found = binarySearch(matrix[row], target);

            if (found) {
                return true;
            }
        }
        return false;
    }
}
