package com.dsa.bitmanipulation.InterviewProblems.FindRangeXor;

public class FindRangeXOROptimal {
    public int xorUpto(int n) {
        if (n % 4 == 1)
            return 1;
        if (n % 4 == 2)
            return n + 1;
        if (n % 4 == 3)
            return 0;
        return n;
    }

    public int findRangeXOR(int l, int r) {
        return xorUpto(l - 1) ^ xorUpto(r);
    }
}
