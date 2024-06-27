package easy;

public class MaximumNoOfOnes {
    public int rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int cntMax = 0;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int cntNoOfOnes = 0;
            for (int j = 0; j < m; j++) {
                cntNoOfOnes += mat[i][j];
            }
            if (cntNoOfOnes > cntMax) {
                cntMax = cntNoOfOnes;
                index = i;
            }
        }
        return index;
    }

    public int lowerBound(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int rowAndMaximumOnes1(int[][] mat) {
        int cntMax = -1;
        int index = -1;
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            int cntOfOnes = m - lowerBound(mat[i], m, 1);
            if (cntOfOnes > cntMax) {
                cntMax = cntOfOnes;
                index = i;
            }
        }
        return index;
    }
}
