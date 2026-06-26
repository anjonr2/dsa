package com.problemsolving.array.easy.SecondLargestElement.better;

public class SecondLargestElement {
    /*
     * To optimise the elimination further the idea is to eliminate sorting
     * Traverse the element once to find the largest element
     * Perform a second traversal to find the largest element that is smaller than
     * the largest element found
     */
    public int secondLargestElement(int[] nums) {
        int n = nums.length;

        // Check if the array has less than 2 elements
        if (n < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i += 1) {
            if (nums[i] > largest)
                largest = nums[i];
        }

        for (int i = 0; i < n; i += 1) {
            if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}
