package com.problemsolving.BinarySearch.hard.searchInASorted2DMatrix.better;

public class SearchInASorted2DMatrix {
    private boolean binarySearch(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;

        // Perform the binary search
        while (low <= high) {
            // calculate middle index
            int mid = (low + high) / 2;

            // If the middle element is target, return true
            if (arr[mid] == target)
                return true;

            // Since the array is sorted if the middle element is greater than target then
            // any element to right of middle element will be greater than target. So search
            // in the left half instead to find target
            else if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }

    /*
     * Since the matrix is sorted . If the target lies between the first and last
     * element of the row
     * (i.e matrix[i][0]<=target && target<=matrix[i][m-1]). We can conclude target
     * might be present in that specific row
     * Once we locate the potentially relevant row containing the target to confirm
     * it's presence we can use binary search
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows in the matrix
        int n = matrix.length;

        // Get the number of cols
        int m = matrix[0].length;

        // Traverse each row
        for (int i = 0; i < n; i += 1) {
            // Check if target could be present in this row
            if (matrix[i][0] <= target && target <= matrix[i][n - 1]) {
                // Perform binary search in that row
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }
}

/*
 * Time complexity : O(nlogn)
 * We go through each n rows once
 * For any valid row where the target can exist we apply a binary search where
 * it takes O(logm). So overall O(nlogm)
 */