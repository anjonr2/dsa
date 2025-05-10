package com.dsa.recursion1.ImplementationProblems.Power.iterative;

public class Power {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1)
            return 1; // Base case: x^0 = 1 and 1^n = 1
        long temp = n;
        if (n < 0) {
            x = 1 / x;
            temp = -1L * n; // conver n to positive for calculation
        }

        double result = 1.0;
        for (int i = 0; i < temp; i++) {
            result *= x; // Multiply x for n times
        }
        return result;
    }
}
