package com.problemsolving.BinarySearch.hard.findrowwithmaxones.linearSearch;

/*
*Traverse each row
*And in each row count the number of 1's
 */
public class FindRowWithMaxOne {
    /*
     * Function to find the row
     * with maximum number of 1's
     */
    public int rowWithMax1s(int[][] matrix) {
        int noOfRows = matrix.length;
        int noOfCols = matrix[0].length;

        /*
         * Variable to store the
         * maximum count of 1's found
         */
        int cnt_max = 0;

        /*
         * Variable to store the index of the row with maximum no of 1's
         */
        int index = -1;

        for (int i = 0; i < noOfRows; i += 1) {
            /*
             * Counter for 1's
             * in the current row
             */
            int cnt_ones = 0;
            for (int j = 0; j < noOfCols; j += 1) {
                cnt_ones += matrix[i][noOfCols];
            }

            /* Update cnt_max and index if current row has more 1's than previously found */
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        /* return the row with maximum count of ones */
        return index;
    }
}
