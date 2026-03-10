package com.problemsolving.BinarySearch.easy.SingleElementInSortedArray.BruteForce;

//here we can use linear search to find out single non duplicate element
//for that we can compare if the element is not equal to both previous and it's next element
//since the array is sorted so all the duplicate element will be together
//handle boundary cases where element is either first or the last element of the array
public class SingleElementInSortedArray {
    /* Function to find single non duplicate element in a sorted array */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1) // if array has 1 element then return first index
            return 0;

        for (int i = 0; i < n; i += 1) {
            // check for the first element
            // since we can't check previous index element for 0th index as it will give
            // indexOutOfBound
            if (i == 0) {
                if (nums[i] != nums[i + 1])
                    return nums[i];
            } else if (i == n - 1) {
                if (nums[i - 1] != nums[i])
                    return nums[i];
            } else {
                // for any other element except first and last index element we check both
                // previous and next element
                if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1])
                    return nums[i];
            }
        }

        return -1;
    }
}
