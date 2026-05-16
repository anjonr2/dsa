package com.problemsolving.recursion.basic;

public class PrintNameNTimes {
    /* recursive function to print name count times */
    public void printName(String name, int count, int N) {
        /* Base case: if count equals N, stop recursion */
        if (count == N)
            return;

        System.out.println(name);

        printName(name, count + 1, N);
    }

    public static void main(String[] args) {
        PrintNameNTimes solution = new PrintNameNTimes();
        int N = 5;
        String name = "Hello";
        solution.printName(name, 0, N);
    }
}
