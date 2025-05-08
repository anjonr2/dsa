package com.dsa.recursion1.PrimeNumber.recursive;

public class PrimeNumber {
    public boolean checkPrime(int num) {
        if (num <= 1) {
            return false;
        }
        return isPrime(num, 2);
    }

    public boolean isPrime(int num, int divisor) {
        if (divisor * divisor > num) {
            return true; // no divisior found, so it's prime
        }
        if (num % divisor == 0) {
            return false; // found a divisor, so it's not prime
        }
        return isPrime(num, divisor + 1); // check next divisor
    }
}
