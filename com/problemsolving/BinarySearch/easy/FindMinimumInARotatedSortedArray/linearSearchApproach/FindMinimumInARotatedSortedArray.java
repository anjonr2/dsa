package com.problemsolving.BinarySearch.easy.FindMinimumInARotatedSortedArray.linearSearchApproach;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMinimumInARotatedSortedArray {
    public int findMin(ArrayList<Integer> arr) {
        // initialize minimum to maximum integer value
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i += 1) {
            minimum = Math.min(minimum, arr.get(i));
        }
        return minimum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 1, 2, 3));
        FindMinimumInARotatedSortedArray minimum = new FindMinimumInARotatedSortedArray();
        int ans = minimum.findMin(arr);
        System.out.println("Minimum is " + ans);
    }
}
