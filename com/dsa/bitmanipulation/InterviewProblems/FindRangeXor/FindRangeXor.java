package com.dsa.bitmanipulation.InterviewProblems.FindRangeXor;

public class FindRangeXor {
    public int findRangeXOR(int l, int r) {

        int ans = 0;
        for (int i = l; i <= r; i += 1) {
            ans ^= i;
        }
        return ans;
    }
}
