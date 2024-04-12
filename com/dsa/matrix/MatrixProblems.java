package com.dsa.matrix;

import java.util.ArrayList;
import java.util.List;

public class MatrixProblems {
    public static List<Integer> spiralMatrix(List<List<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int left = 0, right = cols - 1;
        int top = 0, bottom = rows - 1;
        List<Integer> result = new ArrayList<>();
        // traverse right first
        for (int i = left; i <= right; i++) {
            result.add(matrix.get(top).get(i));
        }
        // top will move to next row
        top++;

        // traverse top to bottom where col(right) will be const
        for (int i = top; i <= bottom; i++) {
            result.add(matrix.get(i).get(right));
        }
        right--;

        for (int i = right; i >= left; i--) {
            // row will be const so bottom will be same
            result.add(matrix.get(bottom).get(i));
        }
        bottom--;

        // traverse from bottom to top only row will be changing
        for (int i = bottom; i >= top; i--) {
            result.add(matrix.get(i).get(left));
        }
        // column will be incremented to next column
        left++;
        return result;
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
