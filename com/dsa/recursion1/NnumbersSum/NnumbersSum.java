package com.dsa.recursion1.NnumbersSum;

public class NnumbersSum {
    public int NnumbersSum(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return NnumbersSum(N - 1) + NnumbersSum(N);
    }

    public static void main(String[] args) {
        NnumbersSum nnumberSum = new NnumbersSum();
        int N = 5;
        int result = nnumberSum.NnumbersSum(N);
        System.out.println("The sum of first " + N + " numbers is: " + result);
        // Output: The sum of first 5 numbers is: 15
    }
}
