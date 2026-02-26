package com.problemsolving.array.hard.MergeOverLappingSubIntervals.better;

import java.util.ArrayList;
import java.util.List;

public class MergeOverLappingSubIntervals {
    public List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
        // if it's an empty list of intervals , return an empty list
        if (intervals == null || intervals.size() == 0)
            return new ArrayList<>();
        intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        int n = intervals.size();
        // add first interval from the input to the mergedIntervals list
        mergedIntervals.add(intervals.get(0));

        // start iterating from the second interval and compare it with the last
        // interval in the merged intervals
        for (int i = 1; i < n; i += 1) {
            List<Integer> lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            List<Integer> currentInterval = intervals.get(i);

            // to check for overlap check if current interval's first is less than or equal
            // to last interval's
            // second
            if (currentInterval.get(0) <= lastInterval.get(1)) {
                lastInterval.set(1, Math.max(lastInterval.get(1), currentInterval.get(1)));

            } else {
                // add current interval to the merged intervals list
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals;
    }
}

/*
 * Time Complexity: O(nlogn) for sorting the intervals and O(n) for iterating
 * over the intervals
 * 
 */