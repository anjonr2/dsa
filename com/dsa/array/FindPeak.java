package com.dsa.array;

public class FindPeak {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[length - 1] > nums[length - 2])
            return length - 1;

        int low = 1;
        int high = length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 1, 3, 5, 6, 4 };
        FindPeak obj = new FindPeak();
        System.out.println("peak element " + obj.findPeakElement(nums));
    }
}
