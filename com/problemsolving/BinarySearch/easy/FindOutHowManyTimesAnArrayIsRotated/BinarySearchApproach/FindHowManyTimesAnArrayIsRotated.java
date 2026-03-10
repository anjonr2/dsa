package com.problemsolving.BinarySearch.easy.FindOutHowManyTimesAnArrayIsRotated.BinarySearchApproach;

import java.util.ArrayList;

public class FindHowManyTimesAnArrayIsRotated {
    public int findKRotation(ArrayList<Integer> nums) {
        int n = nums.size();
        int minimum = Integer.MAX_VALUE;
        int minimumIndex = -1;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < minimum) {
                    minimum = nums.get(low);
                    minimumIndex = low;
                }
                break;
            }
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < minimum) {
                    minimum = nums.get(low);
                    minimumIndex = low;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
                if (nums.get(mid) < nums.get(high)) {
                    minimum = nums.get(mid);
                    minimumIndex = mid;
                }
            }
        }
        return minimumIndex;
    }
}
