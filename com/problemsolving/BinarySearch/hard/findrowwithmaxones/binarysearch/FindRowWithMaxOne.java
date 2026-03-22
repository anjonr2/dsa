package com.problemsolving.BinarySearch.hard.findrowwithmaxones.binarysearch;

/*
*Lower bound of a target element can be implemented here
*Lower bound of a number is defined as the smallest index 
*in the sorted array where the element is greater than or equal to the target
*arr[] = [2,3,7,10,11,25] target = 9
*3 is the smallest index in arr[] where element (arr[3]=10) is greater than or equal to 9
*arr[] = [2,3,7,10,11,25] target = 11
*Output = 4
*As 4 is smallest index in arr[] where element(arr[4]=11) is greater than or equal to 11
*arr[] = [2,3,7,10,11,25] target = 100
*Output = 7
*Explaination: As no element in arr[] is greater than or equal to target , length of the array can be
*returned as lower bound
 */
public class FindRowWithMaxOne {
    /* Helper function to find lower bound of an element */
    private int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int lowerBound = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            /*
             * if element at mid idx is greater than or ewual to 1 then that could possibly
             * the lower bound
             */
            if (arr[mid] >= x) {
                lowerBound = mid;

                /*
                 * Since element at mid is greater than or equal to x.Since array is sorted so
                 * any element to right of mid will also be greater than x. So find a smaller
                 * index move towards left
                 */
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }
    /*
     * Function to find row with max 1's
     * Since each row of given matrix is sorted. We can use Binary search to find
     * lower bound of 1, as lower bound gives the very first index such that element
     * at that index is either equal to 1 or greater than 1
     * So total no of 1's in each row can be calculated as : total no of cols -
     * lower bound of 1
     */

    public int rowWithMax1s(int[][] matrix) {
        int noOfRows = matrix.length;
        int noOfCols = matrix[0].length;

        /* Variable to store the maximum count of 1's */
        int cnt_max = 0;

        /* Variable to store index of the row with maximum 1's */
        int index = -1;

        /* Traverse each row of the matrix */
        for (int i = 0; i < noOfRows; i += 1) {
            /* Get the number of 1's */
            int cnt_ones = noOfCols - lowerBound(matrix[i], noOfCols, 1);

            /*
             * If the current count is greater than maximum, store the index of the current
             * row and update the maximum count
             */
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }
}

/*
 * Time complexity : O(nlogm) where n is the number of rows in the matrix
 * m is the number of column in each row
 * O(n) is as each n rows is being traversed once
 * O(logm) as binary search is being applied for m columns of every row
 */