package com.problemsolving.array.hard.repeatingAndMissingNo.better;

public class RepeatingAndMissingNumber {
    public int[] findMissingAndRepeating(int[] nums) {
        int n = nums.length;
        int repeating = -1;
        int missing = -1;

        // hash array to count occurences of each number in the input array
        int[] hashArray = new int[n + 1];

        // initially hashArray[i] = 0;
        // iterate over the input array and for each element in the input array
        // increment the value in hasharray at the index of that input array element
        for (int i = 0; i < n; i += 1) {
            hashArray[nums[i]] += 1;
        }

        // since number will from 1 to n, so we iterate from 1 to n instead of 0 to n-1
        for (int i = 1; i <= n; i += 1) {
            if (hashArray[i] == 0)
                missing = i;
            if (hashArray[i] == 2)
                repeating = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        return new int[] { repeating, missing };
    }
}

/*
 * Time Complexity : O(2n) for iterating two times over the input array and hash
 * array
 * Space Complexity : O(n) for hash array
 */