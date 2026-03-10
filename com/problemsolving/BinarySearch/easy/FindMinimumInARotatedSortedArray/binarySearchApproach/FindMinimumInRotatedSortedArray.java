package com.problemsolving.BinarySearch.easy.FindMinimumInARotatedSortedArray.binarySearchApproach;

import java.util.ArrayList;

public class FindMinimumInRotatedSortedArray {
    public int findMin(ArrayList<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            // check if the left part is sorted
            if (arr.get(mid) >= arr.get(low)) {
                // if mid is greater than or equal to low then left part is sorted. Take the
                // minimum element from the left sorted part is the element present in the low
                // index and eliminate left sorted half
                min = Math.min(min, arr.get(low));

                // move to right part
                low = mid + 1;
            } else {
                // if the right part is sorted then element at mid is the lowest element in the
                // sorted half
                min = Math.min(min, arr.get(mid));

                // move to left half
                high = mid - 1;
            }
        }
        return min;
    }
}

/*
 * Time Complexity : O(logN)
 */