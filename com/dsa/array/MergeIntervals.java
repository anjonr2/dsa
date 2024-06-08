package com.dsa.array;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int startingPoint2 = intervals[i][0];
            int endPoint2 = intervals[i][1];

            int[] popArray = stack.pop();
            int startingPoint1 = popArray[0];
            int endPoint1 = popArray[1];

            int endMax = Math.max(endPoint2, endPoint1);
            if (endPoint1 >= startingPoint2) {
                int[] merge = new int[] { startingPoint1, endMax };
                stack.add(merge);
            } else {
                stack.add(popArray);
                stack.add(intervals[i]);
            }
        }

        int result[][] = new int[stack.size()][2];
        for (int i = result.length - 1; i >= 0; i--) {
            int[] ans = stack.pop();
            result[i] = ans;
        }

        return result;
    }
}
