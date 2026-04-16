package com.problemsolving.BinarySearch.medium.MinimiseMaxDistanceToGasStation.brute;

public class MinimiseMaxDistanceToGasStation {
    /* Function to minimise the maximum distance between gas stations */
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        /*
         * No of gas stations in each segment
         * if there are n elements then there are n-1 segements
         * arr = {1, 2, 3, 4, 5};
         * 1--2--3--4--5 there are 5 elements but 4 segments in between them
         */
        int howMany[] = new int[n - 1];

        /* Pick and place k gas station */
        for (int gasStation = 1; gasStation <= k; gasStation += 1) {
            double maxSection = -1;
            int maxInd = -1;

            /*
             * Find the section having maximum distance between them and insert gas stations
             */
            for (int i = 0; i < n - 1; i += 1) {
                double diff = arr[i + 1] - arr[i];
                /*
                 * Each section length between any two gas station is calculated by dividing the
                 * total distance between two consecutive gas station by total no of gas
                 * stations placed at that index
                 */
                double sectionLength = diff / (double) (howMany[i] + 1);

                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            /* Insert the gas station into maxInd position */
            howMany[maxInd] += 1;
        }

        /* Find the maximum distance */
        double maxAns = -1;
        for (int i = 0; i < n - 1; i += 1) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (double) (howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }

        return maxAns;
    }
}

/*
 * Time complexity : O(k*n) + O(n), n is the size of the given array,k is the
 * number of gas stations to be placed. O(k*n) to insert k gas stations between
 * the existing stations with maximum distance. Another O(n) for finding the
 * answer i.e the maximum distance
 * 
 * Space complexity : O(n-1), As an array is used to keep track of placed gas
 * stations
 */