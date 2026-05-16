package com.problemsolving.recursion.basic.Factorial.Iterative;

public class Factorial {
    public static int factorial(int number) {
        int ans = 1;
        for (int i = 1; i <= number; i += 1) {
            ans = ans * i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int number = 5;
        int factorial = factorial(number);
        System.out.println("factorial: " + factorial);
    }
}
