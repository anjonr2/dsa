package com.problemsolving.array.hard.countInversions.optimal;

public class CountInversions {
    private long merge(int[] arr, int low, int mid, int high) {
        // temporary array to store the merged array
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int index = 0;

        long count = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                // if left element is less than or equal to right element then we can not form a
                // inversion pair and so we store the left element in the merged array and move
                // the left pointer.
                temp[index++] = arr[left++];
            } else {
                // if the left element is greater than the right element then we have found an
                // inversion pair and since the left and right subarrays are sorted, all the
                // elements from the left subarray starting from left pointer to mid pointer
                // will be greater than the right element and so we can count all those pairs at
                // once and then store the right element in the merged array and move the right
                // pointer
                count += (mid - left + 1);
                temp[index++] = arr[right++];
            }

            // Copy remaing elements of the left subarray if any
            while (left <= mid) {
                temp[index++] = arr[left++];
            }

            while (right <= high) {
                temp[index++] = arr[right++];
            }
        }
        return count;
    }

    private long mergeSort(int[] arr, int left, int right) {
        long count = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }
        return count;
    }

    public long countInversions(int[] arr) {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }
}

/*
 * Time Complexity : O(nlogn) merge sort takes O(nlogn)
 * Space Complexity : O(n) for temporary array used in merge function
 */