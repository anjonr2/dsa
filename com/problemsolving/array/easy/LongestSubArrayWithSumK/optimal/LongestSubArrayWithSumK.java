package com.problemsolving.array.easy.LongestSubArrayWithSumK.optimal;

public class LongestSubArrayWithSumK {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        int maxLength = 0;

        // pointers to mark start and end of the window
        int left = 0, right = 0;

        // to store sum of the elements in the window
        int sum = nums[0];

        while (right < n) {

            // if the sum exceeds k, shrink the window from the left
            while (left <= right && sum > k) {
                sum -= nums[left];
                left += 1;
            }

            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
            if (right < n)
                sum += nums[right];
        }
        return maxLength;
    }
}
