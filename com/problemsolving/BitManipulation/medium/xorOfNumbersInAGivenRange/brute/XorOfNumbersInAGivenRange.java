package com.problemsolving.BitManipulation.medium.xorOfNumbersInAGivenRange.brute;

public class XorOfNumbersInAGivenRange {
    public int findRangeXOR(int l, int r) {
        int ans = 0;

        /* Xor all the numbers */
        for (int i = l; i <= r; i += 1) {
            ans = ans ^ i;
        }

        return ans;
    }
}
