package com.problemsolving.array.hard.reversePair.brute;

/*
Straightforward approach is to iterate through the array 
and for each element run an inner loop starting from the next element 
and for each such pair check the condition of arr[i] > 2 * arr[j] */
public class ReversePair {
    public int reversePairs(int[] nums) {
        return countReversePairs(nums, nums.length);
    }

    // helper function to count pairs satisfying the condition arr[i] > 2 * arr[j]
    private int countReversePairs(int[] nums, int n) {
        int count = 0;
        for (int i = 0; i < n; i += 1) {
            for (int j = i + 1; j < n; j += 1) {
                if ((long) nums[i] > (long) 2 * nums[j])
                    count += 1;
            }
        }
        return count;
    }
}
