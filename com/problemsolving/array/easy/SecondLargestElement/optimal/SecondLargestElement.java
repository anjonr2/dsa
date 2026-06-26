package com.problemsolving.array.easy.SecondLargestElement.optimal;

public class SecondLargestElement {
    public int secondLargestElement(int[] nums) {
        int n = nums.length;

        /*
         * Check if the array has less than 2 elements
         */
        if (n < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i += 1) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }

        return secondLargest;
    }
}
