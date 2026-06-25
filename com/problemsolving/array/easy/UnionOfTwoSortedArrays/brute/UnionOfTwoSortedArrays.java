package com.problemsolving.array.easy.UnionOfTwoSortedArrays.brute;

import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoSortedArrays {
    public int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        // Insert all the elements of num1 array
        for (int num : nums1) {
            set.add(num);
        }

        // Insert all the elements of nums2 array
        for (int num : nums2) {
            set.add(num);
        }

        int[] union = new int[set.size()];

        int index = 0;
        for (int num : set) {
            union[index++] = num;
        }

        return union;
    }
}

/*
 * Time complexity : O((M+N) log (M+N)), at max set can store M+N elements [when
 * there are no common elements and elements in nums1, nums2 are distinct]. So
 * inserting M + N th element takes log(M+N) time.
 * 
 * So overall it will take O((M+N)log(M+N)) time.
 * 
 * Space complexity : O(M+N), considering space of Union array
 */