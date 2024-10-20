package com.dsa.recursion;

public class PrintSum {
    // public static void printSum(int i, int sum) {
    // if (i < 1) {
    // System.out.println("Sum is " + sum);
    // }
    // printSum(i - 1, sum + i);
    // }
    public static int printSum(int n) {
        if (n == 0) {
            // sum of first 0 numbers is 0
            return 0;
        }
        return n + printSum(n - 1);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int sum = printSum(3);
        System.out.println("sum " + sum);
        int factorial = factorial(4);
        System.out.println("factorial of 4 is " + factorial);
    }
}
