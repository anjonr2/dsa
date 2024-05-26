package com.dsa.array;

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

    public static void main(String[] args) {
        int arr[] = { -2, -3, 4, -1 - 2, 1, 5, -3 };

        int res[] = new int[2];
        res = maximumSumSubArr(arr);

        System.out.println(
                "Start and end idx of maximum sum sub array are " + "startIdx: " + res[0] + "endIdx: " + res[1]);
    }
}
