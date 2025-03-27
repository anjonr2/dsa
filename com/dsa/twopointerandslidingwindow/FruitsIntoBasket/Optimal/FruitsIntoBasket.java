package com.dsa.twopointerandslidingwindow.FruitsIntoBasket.Optimal;

import java.util.HashMap;

public class FruitsIntoBasket {
    public static int totalElements(Integer[] arr) {
        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while (map.size() > 2) {
                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right += 1;
        }
        return maxLength;
    }
}
