package com.dsa.RecursionBasics.Factorial.iterative;

public class Factorial {
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i += 1) {
            fact = fact * i;
        }
        return fact;
    }
}
