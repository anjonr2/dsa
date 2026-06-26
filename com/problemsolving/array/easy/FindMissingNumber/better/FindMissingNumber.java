package com.problemsolving.array.easy.FindMissingNumber.better;

/*
This approach uses a hash array (or frequency) array to track the presence 
of each number from 1 to n in the input array 
 */
public class FindMissingNumber {
    public static int missingNum(int[] arr) {
        int n = arr.length;

        int[] hash = new int[n + 1];

        // Store frequencies of elements
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        for (int i = 1; i <= n; i += 1) {
            if (hash[i] == 0)
                return i;
        }

        return -1;
    }
}
