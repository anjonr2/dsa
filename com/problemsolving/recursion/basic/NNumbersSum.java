package com.problemsolving.recursion.basic;

public class NNumbersSum {
    public int NnumbersSum(int N) {
        if (N == 0)
            return 0;
        return N + NnumbersSum(N - 1);
    }

    public static void main(String[] args) {
        NNumbersSum solution = new NNumbersSum();
        int N = 10;
        int sum = solution.NnumbersSum(N);
        System.out.println("sum:" + sum);
    }
}
