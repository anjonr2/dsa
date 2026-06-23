package com.problemsolving.stackandqueue.hard.slidingwindowmaximum.optimal;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingwindowMaximum {
    // Function to get maximum sliding window
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;

        int ans[] = new int[n - k + 1];
        int ansIndex = 0;

        Deque<Integer> deque = new LinkedList<>();

        // traverse the array
        for (int i = 0; i < n; i += 1) {

            // Update deque to maintain a current window of size k
            if (!deque.isEmpty() && deque.peekFirst() <= (i - k)) {
                // if including current index exceeds window of size k then remove the index
                // from the front of the deque
                deque.pollFirst();
            }

            /*
             * Maintain a monotonic (decreasing) order of elements in deque.
             * If the current element is greater than deque back then inserting or adding it
             * to deque it disrupts the decreasing order of deque
             */
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add current element's index to the deque
            deque.offerLast(i);

            /*
             * Store the maximum element from the first window possible
             */
            if (i >= k - 1) {
                ans[ansIndex++] = arr[deque.peekFirst()];
            }
        }
        return ans;
    }
}

/*
 * Time complexity : O(N) (where N is the size of the given array)
 * 
 * The array is traversed once taking O(N) time
 * 
 * Space complexity : O(N-K)+O(K)
 * 
 * The deque will store O(K) element at max
 * The result will store N-K+1 maximum taking O(N-K) space
 */