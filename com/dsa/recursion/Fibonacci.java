package com.dsa.recursion;

public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int last = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);

        return last + secondLast;
    }

    public static void main(String[] args) {
        int ans = fibonacci(6);
        System.out.println("fibonacci is " + ans);
    }
}
