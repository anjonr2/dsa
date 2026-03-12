package com.problemsolving.BinarySearch.medium.KthMissingPositiveInteger.BinarySearchApproach;

public class KthMissingPositiveInteger {
    public int findKthMissingPositiveInteger(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // compute missing number before mid by subtracting mid + 1 from current element
            // present at mid
            int missing = nums[mid] - (mid + 1);

            // we are trying to find two index between which missing number could be present
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // more = k - missingNumber
        // ans = arr[high] + more
        // => arr[high] + (k-missingNumber)
        // =>arr[high] + (k-(arr[high]-(high+1)))
        // =>high + 1 +k
        // =>low + k
        return low + k;
    }
}
