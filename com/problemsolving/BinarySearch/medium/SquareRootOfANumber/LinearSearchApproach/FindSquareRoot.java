package com.problemsolving.BinarySearch.medium.SquareRootOfANumber.LinearSearchApproach;

public class FindSquareRoot {
    public int findSquareRoot(int n) {
        int squareRoot = 0;
        for (int i = 1; i <= n; i += 1) {
            long val = (long) i * (long) i;
            if (val <= (long) n) {
                squareRoot = i;
            } else {
                // exit the for loop of val excedes n
                break;
            }
        }
        return squareRoot;
    }
}
