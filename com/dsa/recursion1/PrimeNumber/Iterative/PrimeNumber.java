package com.dsa.recursion1.PrimeNumber.Iterative;

public class PrimeNumber {
    public boolean checkPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        int num = 28; // Example number to check
        boolean isPrime = primeNumber.checkPrime(num);
        System.out.println(num + " is prime: " + isPrime);
    }
}
