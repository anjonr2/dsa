package com.dsa.recursion1.ImplementationProblems.Power.recursive;

public class Power {
    public double power(double x, long n) {
        if (n == 0 || x == 1.0) {
            return 1.0;
        }
        if (n == 1L) {
            return x;
        }
        if (n < 0)
            return 1.0 / power(x, n);
        if (n % 2 == 0) {
            return power(x * x, n / 2);
        }
        return x * power(x * x, (n - 1) / 2);
    }

    public double myPow(double x, int n) {
        return power(x, 1L * n);
    }
}
