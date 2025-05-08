package com.dsa.recursion1.SumOfDigits.iterative;

// https://takeuforward.org/plus/dsa/beginner-problem/basic-recursion/sum-of-digits-in-a-given-number?tab=editorial
public class SumOfDigits {
    public int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            while (num != 0) {
                sum += num % 10; // Add the last digit to sum
                num /= 10; // Remove the last digit from num
            }
            num = sum;
        }
        return sum;
    }
}
