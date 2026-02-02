package com.problemsolving.array.medium.setMetrixToZero.bruteforce;

public class SetMatrixToZero {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (matrix[i][j] == 0) {
                    for (int col = 0; col < m; col += 1) {
                        if (matrix[i][col] != 0)
                            matrix[i][col] = -1;
                    }
                    for (int row = 0; row < n; row += 1) {
                        if (matrix[row][j] != 0)
                            matrix[row][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < m; j += 1) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }
    }
}
