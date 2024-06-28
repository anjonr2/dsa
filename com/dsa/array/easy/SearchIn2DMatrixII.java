package easy;

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.

public class SearchIn2DMatrixII {
    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int index = binarySearch(matrix[i], target);
            if (index != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
