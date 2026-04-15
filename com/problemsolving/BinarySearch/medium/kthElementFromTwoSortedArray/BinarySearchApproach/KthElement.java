package com.problemsolving.BinarySearch.medium.kthElementFromTwoSortedArray.BinarySearchApproach;

public class KthElement {
    /*
     * length of left half is k
     * We are looking for a cut point such that exactly k element on the left of the
     * partition
     */
    public int kthElement(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;

        // Ensure a is the smaller array
        if (m > n) {
            // This ensures peforming binary search on smaller array which results in
            // O(log(min(m,n))) time complexity
            return kthElement(b, a, k);
        }

        int left = k; // No of elements in the left partition
        int low = Math.max(0, k - n);
        int high = Math.min(m, k);

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < m) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                /* kth element is the largest of the two values at the boundary on left */
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1; // Move left
            } else {
                low = mid1 + 1;
            }
        }

        return -1;
    }
}
