package com.problemsolving.array.medium.sort0s1s2s.optimal;

public class Sort0s1s2s {
    public void sortArrayOf01and2(int nums[]) {
        int low = 0, mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low += 1;
                mid += 1;
            } else if (nums[mid] == 1)
                mid += 1;
            else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high -= 1;
            }
        }
    }
}
