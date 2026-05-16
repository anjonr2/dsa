package com.problemsolving.recursion.basic.Factorial.Recursive;

/*Factorial of a number N can be calculated by multiplying all natural numbers from 1 to N */
public class Factorial {
    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        int factorial = factorial(n);
        System.out.println("factorial: " + factorial);
    }
}
