package com.problemsolving.array.medium.roatematrixby90.brute;

public class RoateMatrix {
    public void rotateMatrix(int[][] matrix) {
        int noOfRow = matrix.length;
        int noOfCol = matrix[0].length;
        int[][] rotatedMatrix = new int[noOfRow][noOfCol];
        for (int i = 0; i < noOfRow; i += 1) {
            for (int j = 0; j < noOfCol; j += 1) {
                rotatedMatrix[j][noOfRow - 1 - i] = matrix[i][j];
            }
        }
    }
}
