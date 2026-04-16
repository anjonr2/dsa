package com.problemsolving.BinarySearch.medium.MinimiseMaxDistanceToGasStation.better;

import java.util.PriorityQueue;

public class MinimiseMaxDistanceToGasStation {
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int[] howMany = new int[n - 1];

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < n - 1; i += 1) {
            double dist = arr[i + 1] - arr[i];
            pq.offer(new double[] { dist, i });
        }

        for (int gasStation = 1; gasStation <= k; gasStation += 1) {
            double[] top = pq.poll();
            int sectionIndex = (int) top[1];
            howMany[sectionIndex] += 1;

            double intialDist = arr[sectionIndex + 1] - arr[sectionIndex];
            double newSectionLength = intialDist / (double) (howMany[sectionIndex] + 1);

            pq.offer(new double[] { newSectionLength, sectionIndex });
        }

        return pq.peek()[0];
    }
}

/*
 * Time complexity :O(NlogN + klogN)
 * n is the size of the given array, k = no of gas stations to be placed
 * as the insert operation in priority queue takes O(logN) time complexity
 * O(nlogn) for inserting all the indices with distance values
 * and O(klogn) for placing the gas stations
 * 
 * ---------------
 * 
 * Space complexity : O(n-1) + O(n-1)
 * first O(n-1) is for the array to keep track of placed gas stations
 * and the second one is for the priority queue
 */