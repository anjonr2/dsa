package com.dsa.recursion1.factorial;

public class Factorial {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 4;
        int result = factorial(n);
        System.out.println("The factorial of " + n + " is: " + result);
    }
}
