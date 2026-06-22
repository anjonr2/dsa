package com.problemsolving.stackandqueue.medium.MaximumRectangles;

import java.util.Stack;

public class MaximumRectangles {
    private int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        int nse, pse;

        int area;

        for (int i = 0; i < n; i += 1) {

            int currentElement = heights[i];
            while (!stack.isEmpty() && stack.peek() >= currentElement) {
                // get the current top of the stack
                int ind = stack.pop();

                pse = stack.isEmpty() ? -1 : stack.peek();

                nse = i;

                area = (nse - pse - 1) * heights[ind];

                maxArea = Math.max(area, maxArea);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            nse = n;

            int ind = stack.pop();

            pse = stack.isEmpty() ? -1 : stack.peek();

            area = (nse - pse - 1) * heights[ind];

            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int heights[] = new int[cols];
        int maxArea = 0;

        for (int row = 0; row < rows; row += 1) {
            for (int col = 0; col < cols; col += 1) {
                if (matrix[row][col] == 0)
                    heights[col] = 0;
                else
                    heights[col] += 1;
            }
            // sending each row as a heights of histogram array
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
}

/*
 * Time complexity : O(N x M)
 * 
 * where N = rows, no of rows
 * M = cols, no of columns
 * 
 * Updating the heights array for each row takes O(M)
 * Largest rectangle in Histogram runs in O(M) per row
 * Total work across N rows --> O(N x M)
 * 
 * Space complexity : O(M)
 * 
 * We maintan a heights array of size M
 * The histogram stack also uses at most M space
 * No prefix matrix is used so space is O(M)
 */