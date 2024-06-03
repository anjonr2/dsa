package com.dsa.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindTriplets {
    public static ArrayList<ArrayList<Integer>> findThreeSum(int arr[], int K) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            Set<Integer> set2 = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int third = K - (arr[i] + arr[j]);

                if (set2.contains(third)) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(third);

                    Collections.sort(temp);
                    set.add(temp);
                }
                set2.add(arr[j]);
            }
        }

        for (ArrayList<Integer> list : set) {
            result.add(list);
        }
        return result;
    }
}
