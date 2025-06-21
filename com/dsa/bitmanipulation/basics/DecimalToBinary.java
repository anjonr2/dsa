package com.dsa.bitmanipulation.basics;

public class DecimalToBinary {
    public String decimalToBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n != 1) {
            if (n % 2 == 1)
                binary.append("1");
            else
                binary.append("0");
            n = n / 2;
        }
        binary.reverse();
        return binary.toString();
    }
}