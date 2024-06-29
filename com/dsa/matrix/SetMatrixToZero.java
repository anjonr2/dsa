package com.dsa.matrix;

public class SetMatrixToZero {
    public void markRow(int[][] matrix, int row) {
        // no of columns
        int m = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[row][i] != 0) {
                matrix[row][i] = -1;
            }
        }
    }

    public void markCol(int[][] matrix, int col) {
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            if (matrix[j][col] != 0) {
                matrix[j][col] = -1;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, i);
                    markCol(matrix, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            row[i] = 0;
        }
        for (int j = 0; j < m; j++) {
            col[j] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
