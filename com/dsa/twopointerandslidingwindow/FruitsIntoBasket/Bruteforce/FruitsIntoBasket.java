package com.dsa.twopointerandslidingwindow.FruitsIntoBasket.Bruteforce;

import java.util.HashSet;
import java.util.Set;

public class FruitsIntoBasket {
    public static int totalElements(Integer[] arr) {
        int maxLength = Integer.MIN_VALUE;
        int n = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(arr[j]);
                if (set.size() <= 2) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }
}
