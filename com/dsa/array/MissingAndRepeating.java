package com.dsa.array;

public class MissingAndRepeating {
    public static int[] findMissing(int[] input) {
        int missing = -1, repeating = -1;
        int n = input.length;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (input[j] == i) {
                    count++;
                }
            }
            if (count == 0)
                missing = i;
            if (count == 2)
                repeating = i;
            if (missing != -1 && repeating != -1) {
                break;
            }
        }
        int ans[] = { missing, repeating };
        return ans;
    }
}
