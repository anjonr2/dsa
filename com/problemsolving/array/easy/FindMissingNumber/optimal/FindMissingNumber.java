package com.problemsolving.array.easy.FindMissingNumber.optimal;

/*
In optimal approach we can use sum of first n natural number n(n+1)/2
 */
public class FindMissingNumber {
    public static int missingNum(int[] arr) {
        int n = arr.length + 1;

        long sum = 0;

        for (int i = 0; i < n; i += 1) {
            sum += arr[i];
        }

        // long used for expected sum not to overflow
        long expectedSum = n * (n + 1) / 2;

        return (int) (expectedSum - sum);
    }
}
