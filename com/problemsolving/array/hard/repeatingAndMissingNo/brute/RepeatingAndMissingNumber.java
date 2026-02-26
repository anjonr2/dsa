package com.problemsolving.array.hard.repeatingAndMissingNo.brute;

public class RepeatingAndMissingNumber {
    public int[] findMissingAndRepeating(int[] nums) {
        int n = nums.length;
        int repeating = -1;
        int missing = -1;

        // since number will be from 1 to n, so we iterate from 1 to n in outer for loop
        for (int i = 1; i <= n; i += 1) {
            int count = 0;

            // this for loop iterates over the input array element and compares it with i
            for (int j = 0; j < n; j += 1) {
                if (nums[j] == i)
                    count += 1;
            }

            // innner for loop compares i with all the elements in the input array
            // so at the end of inner for loop check the value of the count
            if (count == 0)
                missing = i;
            if (count == 2)
                repeating = i;
            if (repeating != -1 && missing != -1)
                break;
        }
        return new int[] { repeating, missing };
    }
}

/*
 * Time Complexity : O(n^2) for two for loop
 * Space Complexity : O(1)
 */