package com.dsa.RecursionBasics.fibonacci.recursive;

public class FibonacciSeries {
    public int fibonacci(int n) {

        if (n <= 1)
            return n;
        int last = fibonacci(n - 1);
        int secondLast = fibonacci(n - 2);
        return last + secondLast;
    }
}
