package com.problemsolving.BinarySearch.medium.NthRootOfANumber.LinearSearchApproach;

public class NthRootOfANumber {
    /* Function to find the nth root of m using linear search */
    public int NthRoot(int N, int M) {
        /* Linear search on the answer space */
        for (int i = 1; i <= M; i += 1) {
            // compute i^n
            long val = (long) Math.pow(i, N);

            // if equal to m return i
            if (val == M)
                return i;

            // if exceeds m, break
            if (val > M)
                break;
        }
        return -1;
    }
}
