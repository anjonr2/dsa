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
}
