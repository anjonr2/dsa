package com.problemsolving.BinarySearch.medium.MaximiseDistanceToGasStation.Better;

import java.util.PriorityQueue;

public class MaximiseDistanceToGasStation {
    /*
     * We can use a Priority Queue. In a max heap implementation the largest element
     * is always at the top. This property allows us to efficiently retrieve the
     * maximum distance. Store the elements in pairs consisting of distance and it's
     * corresponding index. By using a max heap(implemented via a priority queue) we
     * avoid the need to iterate through the array multiple times to find the maximu
     * distance
     */
    public double minimiseMaxGasStationDistance(int gasStattions[], int noOfGasStations) {
        int n = gasStattions.length;
        int[] howMany = new int[n - 1];

        // Max heap of double array [] : [distance, sectionIndex]
        /*
         * a = [1.0,0]
         * b = [3.0,2]
         * Double.compare(b[0], a[0])
         * Double.compare(3.0, 1.0)
         * Result = positive. b gets higher priority
         * Largest distance on the top
         */
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));

        /*
         * traverse till n-2th index so that Array does not go ArrayIndex out of bound
         * if we traverse till i<n i.e n-1th index then arr[i+1] => arr[n-1+1]=>arr[n]
         * which will lead to aray index out of bound
         */

        for (int i = 0; i < n - 1; i += 1) {
            /*
             * Intializing priority queue with respective distances between given gas
             * stations and their indexes
             */
            double distance = gasStattions[i + 1] - gasStattions[i];
            priorityQueue.offer(new double[] { distance, i });
        }

        for (int gasStationsIdx = 1; gasStationsIdx <= noOfGasStations; gasStationsIdx += 1) {
            double[] top = priorityQueue.poll();

            // this returns the index of gas station index which has max section distance
            int sectionIndex = (int) top[1];

            // insert gas station in section index where gas station distance is maximum
            howMany[sectionIndex] += 1;

            // update section length
            double initialDistance = gasStattions[sectionIndex + 1] - gasStattions[sectionIndex];
            double newSectionLength = initialDistance / initialDistance + 1;
            priorityQueue.offer(new double[] { newSectionLength, sectionIndex });
        }

        // since top of the priority queue stores the maximum element. So once we
        // retrieve the peak of the priority queue we can return first element from that
        // array where first element stores the maximum section length
        return priorityQueue.peek()[0];
    }
}

/*
 * Time Complexity :O(nlogn + klogn) , n is the size of the given array, k is
 * the no of gas stations to be placed. As the insert operation of priority
 * queue takes logn time complexity
 * so O(nlogn) for inserting all the indices with distance value
 * O(klogn) for placing k gas stations
 * 
 * Space Complexity : O(n-1)+O(n-1)
 * first n-1 is to keep track of placed gas stations
 * and second one is for priority queue
 */