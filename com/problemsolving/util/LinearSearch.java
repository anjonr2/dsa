package com.problemsolving.util;

public class LinearSearch implements Search {
    @Override
    public boolean search(int[] arr, int target) {
        for (int num : arr) {
            if (num == target)
                return true;
        }
        return false;
    }
}
