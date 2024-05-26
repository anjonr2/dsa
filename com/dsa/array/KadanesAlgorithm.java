package com.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class KadanesAlgorithm {
    public static int[] maximumSumSubArr(int arr[]) {
        int ans[] = new int[2];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int startIdx = -1;
        int endIdx = -1;
        int start = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                start = i;
            }
            sum += arr[i];

            if (sum > max) {
                max = sum;
                startIdx = start;
                endIdx = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        ans[0] = startIdx;
        ans[1] = endIdx;
        return ans;
    }

    public static int majorityElement(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (n / 2))
                return entry.getKey();
        }
        return -1;
    }

    public static int majorityElementOptimisedSolultion(int arr[]) {
        int cnt = 0;
        int el = -1;
        int n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = arr[i];
            } else if (arr[i] == el) {
                cnt++;
            } else {
                cnt--;
            }
        }

        int cnt2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == el) {
                cnt2++;
            }
        }

        if (cnt2 > n / 2) {
            return el;
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { -2, -3, 4, -1 - 2, 1, 5, -3 };
        int arr2[] = { 2, 2, 3, 3, 1, 2, 2 };

        // int res[] = new int[2];
        // res = maximumSumSubArr(arr);

        // System.out.println(
        // "Start and end idx of maximum sum sub array are " + "startIdx: " + res[0] +
        // "endIdx: " + res[1]);

        int ans = majorityElement(arr2);
        System.out.println("Majority element is " + ans);
    }
}
