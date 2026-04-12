package com.problemsolving.BinarySearch.medium.PaintersPartition.BinarySearchApproach;

import java.util.Arrays;

public class PaintersPartition {
    /* Count how many painters are needed for a given max time */
    private int countPainters(int[] boards, int time) {
        /*
         * painters = 1, to get started because you need atleast one painter to get
         * started
         */
        int painters = 1;
        int boardsPainters = 0;
        for (int board : boards) {
            /*
             * Painter 1 starts taking the board one by one
             * As long as the total time for Painter #1 is <= time , they just keep adding
             * it
             * The moment adding a new board would exceed the limit , we have to stop since
             * Painter #1 is full and new Painter is required
             */
            if (boardsPainters + board <= time) {
                boardsPainters += board;
            } else {
                painters += 1;
                boardsPainters = board;
            }
        }
        return painters;
    }

    public int findLargestMinTime(int[] boards, int k) {
        int low = Arrays.stream(boards).max().getAsInt();
        int high = Arrays.stream(boards).sum();
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            int painters = countPainters(boards, mid);

            if (painters > k) {
                low = mid + 1; // Too many painters than allowed -> increased allowed time
            } else {
                result = mid; // Valid time - anything on the right of mid will be valid. To find largest min
                              // time move high to left of mid

                high = mid - 1;
            }
        }

        return result;
    }
}
