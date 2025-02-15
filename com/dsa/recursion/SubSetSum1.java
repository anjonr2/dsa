package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSetSum1 {
    public static void subSet(int idx, int sum, int[] candidate, int N, List<Integer> subSet) {
        if (idx == N) {
            subSet.add(sum);
            return;
        }

        subSet(idx + 1, sum + candidate[idx], candidate, N, subSet);
        subSet(idx + 1, sum, candidate, N, subSet);
    }

    public static List<Integer> subsetSum(int[] arr, int N) {
        List<Integer> subSet = new ArrayList<>();
        subSet(0, 0, arr, N, subSet);
        Collections.sort(subSet);
        return subSet;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2 };
        List<Integer> res = subsetSum(arr, 3);
        for (int el : res) {
            System.out.print(el + " ");
        }
    }
}
