package com.problemsolving.BinarySearch.easy.FindOutHowManyTimesAnArrayIsRotated.LinearSearchApproach;

import java.util.ArrayList;

//solution to this problem invloves performing 
//a linear search to find the minimum element 
//of the array by comparing each element individually with the minimum element
public class FindHowManyTimesAnArrayIsRotated {
    /* Function to find the number of rotations in a sorted array */
    public int findKRotation(ArrayList<Integer> nums) {
        int n = nums.size();

        // intialized variable to store minimum value and it's index
        int minimum = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < n; i += 1) {
            if (nums.get(i) < minimum) {
                minimum = nums.get(i); // update the minimum value
                minIndex = i; // update the value of minimum index
            }
        }
        return minIndex;
    }
}
