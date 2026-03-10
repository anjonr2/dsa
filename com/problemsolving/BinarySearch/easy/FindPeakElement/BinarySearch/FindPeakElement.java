package com.problemsolving.BinarySearch.easy.FindPeakElement.BinarySearch;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Edge cases :
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 2] < nums[n - 1])
            return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // if array mid is the peak
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
                return mid;

            // mid is the left side of increasing curve so peak will be on the right side
            // eliminate the left half
            if (nums[mid] > nums[mid - 1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
