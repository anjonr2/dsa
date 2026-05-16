package com.problemsolving.recursion.basic;

public class PrintNTo1 {
    private void printNto1(int current) {
        /* Base case: Stop recursion if current is less than 1 */
        if (current < 1)
            return;

        System.out.println(current);

        /* Recursive call to print the previous number */
        printNto1(current - 1);
    }

    public static void main(String[] args) {
        PrintNTo1 solution = new PrintNTo1();
        int n = 10;
        solution.printNto1(n);
    }
}
