package com.dsa.array.medium;

import java.util.ArrayList;
import java.util.HashMap;

// element which appears more than n/3 times
public class MajorityElement {
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int minCount = arr.size() / 3 + 1;
        for (int i = 0; i < arr.size(); i++) {
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
            if (map.containsKey(arr.get(i)) && map.get(arr.get(i)) == minCount) {
                ans.add(arr.get(i));
            }
        }
        return ans;
    }
}
