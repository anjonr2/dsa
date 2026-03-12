package com.problemsolving.BinarySearch.medium.KthMissingPositiveInteger.LinearSearchApproach;

//given a sorted array of positive integer
//from that array some integers will be missing
//need to find out those missing positive integers
public class KthMissingPositiveInteger {
    // in a sorted array of positive integers expected value at each index is index
    // + 1
    // we can find how many numbers are missing by subtracting expected from actual
    public int findMissing(int[] arr, int k) {
        for (int i = 0; i < arr.length; i += 1) {
            if (arr[i] <= k) {
                k += 1;
            } else {
                break;
            }
        }
        return k;
    }
}
