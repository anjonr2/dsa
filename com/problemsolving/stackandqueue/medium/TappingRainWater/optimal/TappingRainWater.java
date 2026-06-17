package com.problemsolving.stackandqueue.medium.TappingRainWater.optimal;

public class TappingRainWater {
    // Function to get the trapped water
    public int trap(int[] height) {
        int n = height.length;

        int total = 0;

        // to store the maximum on both sides
        int leftMax = 0, rightMax = 0;

        // left and right pointers
        int left = 0, right = n - 1;

        // Traverse from both ends
        while (left < right) {
            if (height[left] <= height[right]) {

                // if height of ground is smaller than leftMax then water can be stored
                if (leftMax > height[left]) {
                    total += leftMax - height[left];
                }

                else
                    leftMax = height[left];

                left += 1;
            } else {
                if (height[right] < rightMax) {
                    total += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }

                right += 1;
            }
        }
        return total;
    }
}
