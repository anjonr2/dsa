package com.problemsolving.array.easy.SecondLargestElement.brute;

import java.util.Arrays;

public class SecondLargestElement {

    // Function to find second largest element
    public int secondLargestElement(int[] nums) {
        int n = nums.length;

        // Check if the array has less than 2 elements
        if (n < 2) {

            // Indicating no second largest element is possible
            return -1;
        }

        Arrays.sort(nums);

        int largest = nums[n - 1];
        int secondLargest = -1;

        /*
         * start traversing towards right to left from the second last element of the
         * array
         */
        for (int i = n - 2; i >= 0; i -= 1) {

            /*
             * if the current element is not equal to the largest element
             */
            if (nums[i] != largest) {
                secondLargest = nums[i];
                break;
            }
        }
        return secondLargest;
    }
}

/*
 * Time complexity :O(NlogN)
 * O(logN) for sorting the array
 */