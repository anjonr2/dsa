package com.problemsolving.BinarySearch.medium.MedianOfTwoSortedArrays.BinarySearchApproach;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] a, int[] b) {
        // Make sure array a is smaller one to minimize binary search range
        if (a.length > b.length)
            return findMedianSortedArrays(b, a);

        int n1 = a.length, n2 = b.length;
        int low = 0, high = n1;

        // Binary search on the smaller array
        while (low <= high) {
            // calculate cut points of both the array
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            // since element on the left needs to be smaller than element on right. So for
            // edge cases we have used Integer.MIN_VALUE for left elements and
            // Integer.MAX_VALUE for right elements. Where l1 is the element from left side
            // of array1 cut or partition and l2 is the element from the left side of array2
            // cut or partition. Similar for r1 and r2
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : a[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : b[cut2];

            // for a valid partition elements on the left needs to be smaller than all the
            // elements on right. Since l1 and r1 is from the same array and since array is
            // sorted so l1 is already smaller than r1 we just need to check if l1 is
            // smaller than other right element r2 taken from arr2
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0)
                    // Even total elements => average of two middle elements
                    return (Math.max(l1, l2) + Math.min(r1, r2));
                else
                    // Odd total no of elements => max of left parts
                    return Math.max(l1, l2);
            } else if (l1 > r2) {
                // need to take smaller elements than l1 for left. Since all elements in left
                // part of partition or median needs to be smaller than all elements in right of
                // partition or median
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }

        }
        return 0.0;
    }
}

/*
 * Time complexity : O(log(min(n1,n2))), we are applying binary search on range
 * [0, min(n1,n2)]
 */