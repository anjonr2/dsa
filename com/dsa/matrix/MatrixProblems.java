package com.dsa.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixProblems {
    public static List<Integer> spiralMatrix(List<List<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int left = 0, right = cols - 1;
        int top = 0, bottom = rows - 1;
        List<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {
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

            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    // row will be const so bottom will be same
                    result.add(matrix.get(bottom).get(i));
                }
                bottom--;
            }
            // traverse from bottom to top only row will be changing
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix.get(i).get(left));
                }
                // column will be incremented to next column
                left++;
            }
        }
        return result;
    }

    // search in matrix
    // if matrix is rowwise and colwise sorted
    public static boolean search(int[][] matrix, int value) {
        // initially pointer will be at last element of first row
        int rowsize = matrix.length;
        int colSize = matrix[0].length;

        int rowBegin = 0;
        int colEnd = colSize - 1;
        // need to traverse matrix until it gets out of it
        // since rows will be moving down(incrementing) so it should be less than
        // rowSize
        // since column will be moving left(decreasing) so it should not be less than 0
        while (rowBegin <= rowsize && colEnd >= 0) {
            if (matrix[rowBegin][colEnd] == value) {
                return true;
            }
            // if the value is less than current val then move pointer towards left
            if (matrix[rowBegin][colEnd] > value)
                colEnd--;
            else
                rowBegin++;
        }
        return false;
    }

    // search in a matrix
    // given condition each row is sorted
    // first element in current row is greater than
    // last element of previous row
    public static int[] search1(int[][] matrix, int tagret) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int[] result = new int[2];
        if (matrix.length == 0)
            return result;
        int low = 0;
        int high = (rowSize * colSize) - 1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            int rowIdx = mid / colSize;
            int colIdx = mid % colSize;
            if (matrix[rowIdx][colIdx] == tagret) {
                result[0] = rowIdx;
                result[1] = colIdx;
            }
            if (matrix[rowIdx][colIdx] > tagret) {
                // if mid element is greater than target
                // then we do a search on the left side
                high = mid - 1;
            } else {
                // if target is greater
                // then we do a search on right side
                low = mid + 1;
            }
        }
        return result;
    }

    // given matrix is sorted
    // matrix is having odd number of row and column
    public static int findMedian(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int size = rowSize * colSize;
        int list[] = new int[size];
        // this is to keep track of list arr
        int idx = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                list[idx] = matrix[i][j];
                idx++;
            }
        }
        Arrays.sort(list);
        return list[(rowSize * colSize / 2)];
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
