package com.problemsolving.BinarySearch.medium.NthRootOfANumber.BinarySearchApproach;

public class NthRootOfANumber {
    // helper function to check if mid is the nth root of number
    private int helperFunction(int mid, int n, int number) {
        int ans = 1;
        int base = mid;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= base;
                if (ans > number)
                    return 2;
                n -= 1;
            } else {
                n /= 2;
                base *= base;
                if (base > number)
                    // returns 2 if mid^n > number to shift to left high = mid - 1
                    return 2;
            }
        }

        // if mid to the power n is number then mid is the nth root of number
        if (ans == number)
            return 1;

        // returns 0 if mid^n < number to shift to right low = mid + 1
        return 0;
    }

    // Function to find nth root of M using binary search
    public int NthRoot(int N, int M) {
        int low = 1, high = M;

        while (low <= high) {
            int mid = (low + high) / 2;

            int midN = helperFunction(mid, N, M);
            if (midN == 1)
                return mid; // Found exact root
            if (midN == 0)
                low = mid + 1; // Move right
            if (mid == 2)
                high = mid - 1; // Move left
        }
        return -1; // no integer found
    }
}
