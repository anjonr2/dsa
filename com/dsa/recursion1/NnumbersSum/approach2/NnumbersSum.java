package com.dsa.recursion1.NnumbersSum.approach2;

public class NnumbersSum {
    public static int sumOfFirstNNumbers(int i, int n) {
        if (i > n) {
            return 0;
        }
        return i + sumOfFirstNNumbers(i + 1, n);
    }

    public static void main(String[] args) {
        int n = 5;
        int result = sumOfFirstNNumbers(1, n);
        System.out.println("The sum of first " + n + " numbers is: " + result);
    }
}
