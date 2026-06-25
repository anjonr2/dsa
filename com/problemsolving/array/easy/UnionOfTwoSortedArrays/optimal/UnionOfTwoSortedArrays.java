package com.problemsolving.array.easy.UnionOfTwoSortedArrays.optimal;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {
    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> unionList = new ArrayList<>();
        int i = 0, j = 0;
        int n = nums1.length;
        int m = nums2.length;

        while (i < n && j < m) {
            if (nums1[i] <= nums2[i]) {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums1[i]) {
                    unionList.add(nums1[i]);
                }
                i += 1;
            } else {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums2[j]) {
                    unionList.add(nums2[j]);
                }
                j += 1;
            }
        }

        // Add the remaining elements of nums1, num2 if there's left any
        while (i < n) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums1[i]) {
                unionList.add(nums1[i]);
            }
            i += 1;
        }
        while (j < m) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != nums2[j]) {
                unionList.add(nums2[j]);
            }
            j += 1;
        }

        int[] union = new int[unionList.size()];
        int index = 0;
        for (int num : unionList) {
            union[index++] = num;
        }

        return union;
    }
}

/*
 * Time complexity : O(M+N) because both the arrays are traversed once
 * Space complexity : O(M+N) considering the space for returning the output,
 * which in the worst case can contain all the elements from both the arrays
 */