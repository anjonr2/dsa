package com.problemsolving.array.easy.FindMissingNumber.brute;

/*
brute force approach iterates through each number from 1 to n (where n is the size of the array + 1)
and checks if the number is present in the array. For each number it uses a nested loop to search the array
 */
public class FindMissingNumber {
    public static int missingNumber(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n + 1; i += 1) {
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found)
                return i;
        }

        return -1;
    }
}
