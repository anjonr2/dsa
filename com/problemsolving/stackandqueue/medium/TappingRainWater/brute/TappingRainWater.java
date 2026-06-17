package com.problemsolving.stackandqueue.medium.TappingRainWater.brute;

public class TappingRainWater {
    // Function to find prefix maximum array
    private int[] findPrefixMax(int[] arr, int n) {
        int[] prefixMax = new int[n];

        // For the first element there is no element to it's left. So 0th index element
        // is the prefix max at that index
        prefixMax[0] = arr[0];

        // Traverse the array
        for (int i = 1; i < n; i += 1) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }
        /*
         * for array int[] heights = {4, 2, 0, 3, 2, 5};
         * i = 1 compare between arr[1] and arr[0] max= Math.max(arr[1], prefixMax[1-1])
         * = Math.max(2,4) = 4
         * it's prefixMax array is prefixMax = {4,4,4,4,4,5}
         */

        return prefixMax;
    }

    private int[] findSuffixMax(int[] arr, int n) {
        int suffixMax[] = new int[n];
        suffixMax[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i -= 1) {
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        /*
         * for array int[] heights = {4, 2, 0, 3, 2, 5};
         * it's suffixMax is . Start from end of the array
         * i.e from arr[n-1]
         * 
         * suffixMax[n-1] = arr[n-1]
         * suffixMax[6-1] = arr[6-1]
         * suffixMax[5] = arr[5]
         * arr[5] = 5 from the input array
         * 
         * for i = 4
         * we do suffixMax[4] = Math.max(arr[4], suffixMax[5]);
         * so suffixMax[4] = 5
         * suffixMax [] = {5,5,5,5,5,5}
         */

        return suffixMax;
    }

    // Function to get the trapped water
    public int trap(int[] height) {
        int n = height.length;

        // to store the total trapped rainwater
        int total = 0;

        int[] leftMax = findPrefixMax(height, n);
        int[] rightMax = findSuffixMax(height, n);

        for (int i = 0; i < n; i += 1) {
            // if there are higher grounds on both side to hold water
            if (height[i] < leftMax[i] && height[i] < rightMax[i]) {
                // height[i] is the height of the ground at that index i
                total += (Math.min(leftMax[i], rightMax[i]) - height[i]);
            }
        }
        return total;
    }
}
