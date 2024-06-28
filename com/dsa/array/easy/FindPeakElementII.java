package easy;

public class FindPeakElementII {
    public int findMax(int[][] matrix, int n, int col) {
        int index = -1;
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] > max) {
                max = matrix[i][col];
                index = i;
            }
        }
        return index;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRowIdx = findMax(mat, n, mid);
            int left = mid - 1 >= 0 ? mat[maxRowIdx][mid - 1] : -1;
            int right = mid + 1 < n ? mat[maxRowIdx][mid + 1] : -1;
            if (mat[maxRowIdx][mid] > left && mat[maxRowIdx][mid] > right) {
                return new int[] { maxRowIdx, mid };
            } else if (mat[maxRowIdx][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }
}
