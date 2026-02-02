package com.problemsolving.array.medium.setMetrixToZero.better;

public class SetMatrixToZero {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean rowArr[] = new boolean[n];
        boolean colArr[] = new boolean[m];

        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j <= m; j += 1) {
                if (matrix[i][j] == 0)
                    rowArr[i] = true;
                colArr[j] = true;
            }
        }
        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < m; j += 1) {
                if (rowArr[i] || colArr[j])
                    matrix[i][j] = 0;
            }
        }
    }
}
