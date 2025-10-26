package com.dsa.heap;

import java.util.PriorityQueue;

public class KthLargestInAStream {
    private int k;
    private PriorityQueue<Integer> pq; // Min-Heap

    public KthLargestInAStream(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i += 1) {
            if (pq.size() < k)
                pq.offer(nums[i]);
            else if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
            return pq.peek();
        }
        if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }

}
