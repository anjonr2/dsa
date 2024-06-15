package com.dsa.array;

public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= nums[low]) {
                // left side of array is sorted
                ans = Math.min(ans, nums[low]);
                // trim left half
                low = mid + 1;
            } else if (nums[mid] <= nums[high]) {
                // right side of array is sorted
                ans = Math.min(ans, nums[mid]);

                // trim down right half
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 4, 5, 1, 2 };
        MinInRotatedSortedArray obj = new MinInRotatedSortedArray();
        int min = obj.findMin(nums);
        System.out.println("minimum element is " + obj.findMin(nums));
    }
}
