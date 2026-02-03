package com.problemsolving.array.medium.roatematrixby90.better;

public class Rotatematrix {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n - 1; i += 1) {
            for (int j = i + 1; j < n; j += 1) {
                // swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row to get rotated matrix
        for (int row = 0; row < n; row += 1) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left += 1;
                right -= 1;
            }
        }
    }
}
