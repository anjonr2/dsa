package com.dsa.stack.TrappingRainWater;

public class TrappingRainWater1 {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }
        int water = 0;
        int left = 0;
        int right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            if (leftMax <= rightMax) {
                left += 1;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else if (rightMax <= leftMax) {
                right -= 1;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        return water;
    }
}
