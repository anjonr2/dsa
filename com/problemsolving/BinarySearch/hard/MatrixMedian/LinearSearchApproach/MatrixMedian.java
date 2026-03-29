package com.problemsolving.BinarySearch.hard.MatrixMedian.LinearSearchApproach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixMedian {
    // Function find the median of a row wise sorted matrix
    public int findMedian(int[][] matrix) {
        // Step 1 : Flatten the matrix into a list
        List<Integer> flattened = new ArrayList<>();
        for (int[] row : matrix) {
            for (int val : row) {
                flattened.add(val);
            }
        }

        // Step 2 : Sort the list
        Collections.sort(flattened);

        // Step 3 : Return the middle element
        int n = flattened.size();
        return flattened.get(n / 2);
    }
}

/*
 * Time complexity :O(n*m*log(n*m)), as flattening the matrix takes O(n*m) time
 * and sorting the flattened list takes
 * O(n*m*log(n*m)) time
 */
