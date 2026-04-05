package com.problemsolving.BinarySearch.medium.SmallestDivisor.BinarySearchApproach;

public class SmallestDivisor {
    // Function to find the smallest divisor
    public int smallestDivisor(int[] nums, int limit) {
        // size of the array
        int n = nums.length;

        if (n > limit)
            return -1;

        int maxi = Integer.MIN_VALUE;
        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }

        int low = 1, high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(nums, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /* Helper function to find summation of division values */
    private int sumByD(int[] nums, int mid) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.ceil((double) num / (double) mid);
        }

        return sum;
    }
}

/*
 * Time complexity : O(log(max)*N), where max is the maximum element in the
 * array, N is the size of the array. We are applying binary search on our
 * answers that are in the range of[1,max]. For every possible divisor 'mid',
 * calling sumByD() function.
 * Inside that function traversing the entire array which results in O(N)
 */
