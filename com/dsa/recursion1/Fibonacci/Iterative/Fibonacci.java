package com.dsa.recursion1.Fibonacci.Iterative;

public class Fibonacci {
    public int fib(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, nthFibonacci = 0;
        for (int i = 2; i <= n; i++) {
            nthFibonacci = a + b; // Calculate the next Fibonacci number
            a = b; // Update a to the previous Fibonacci number
            b = nthFibonacci; // Update b to the current Fibonacci number
        }
        return nthFibonacci;
    }
}
