package com.problemsolving.array.easy.RemoveDuplicates.brute;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates {
    // Function to remove duplicates from the array
    public int removeDuplicates(int[] nums) {

        // TreeSet to store unique elements in sorted order
        Set<Integer> set = new TreeSet<>();

        for (int val : nums) {
            set.add(val);
        }

        // get the number of unique elements
        int k = set.size();

        int j = 0;

        // Copy unique elements from set to array
        for (int val : set) {
            nums[j++] = val;
        }

        return k;
    }
}
