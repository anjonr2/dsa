package com.problemsolving.array.hard.MergeOverLappingSubIntervals.brute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverLappingSubIntervals {
    public List<List<Integer>> mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;
            while (j < n && intervals[j][0] <= end) {
                // as long as the start of next interval is less than or equal to the current
                // end, we can keep moving j keeping i constant
                end = Math.max(end, intervals[j][1]);
                j += 1;
            }
            mergedIntervals.add(Arrays.asList(start, end));
            i = j; // move i to j as we have already merged all the overlapping intervals till j-1
        }
        return mergedIntervals;
    }
}

/*
 * Time Complexity : O(n2)
 */
