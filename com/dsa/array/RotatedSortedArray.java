package com.dsa.array;

import java.util.ArrayList;

// search in rotated sorted array : https://www.naukri.com/code360/problems/search-in-rotated-sorted-array_1082554?interviewProblemRedirection=true&search=rotated%20sorted&leftPanelTabValue=SUBMISSION
public class RotatedSortedArray {

    public static int search(ArrayList<Integer> arr, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (k == arr.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
