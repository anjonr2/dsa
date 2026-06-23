package com.problemsolving.stackandqueue.hard.slidingwindowmaximum.brute;

import java.util.ArrayList;
import java.util.List;

public class SlidingwindowMaximum {
    public List<Integer> maxSlidingWindow(int arr[], int k) {
        int n = arr.length;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= n - k; i += 1) { // this for loop traverses for O(n-k)

            // stores the maximum element of the window
            int maxi = arr[i];

            for (int j = i; j < i + k; j += 1) { // this inner for loop traverses for O(n-k)
                maxi = Math.max(maxi, arr[j]);
            }
            /*
             * because first window is from 0 to k-1 idx
             * so we add k-1th idx element to the answer
             */
            if (i >= k - 1) {
                ans.add(maxi);
            }
        }
        return ans;
    }
}

/*
 * Time complexity : O(n-k) * k
 * using two nested loop
 * outer for loop runs for O(n-k) time complexity and inner for loop runs for
 * O(k)
 * Space complexity : O(n-k) it is due to size taken to store the answer
 */