public class MedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int nums3[] = new int[n + m];
        int l = nums3.length;
        int i = 0; // pointing to first index of nums1 array
        int j = 0; // pointing to first index of nums2 array
        int k = 0; // pointing to first index of nums3 array
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        while (i < n) {
            nums3[k++] = nums1[i++];
        }
        while (j < m) {
            nums3[k++] = nums2[j++];
        }

        if (nums3.length % 2 == 1) {
            return nums3[nums3.length / 2];
        }

        double median = (double) ((nums3[l / 2] + nums3[l / 2 - 1])) / 2.0;
        return median;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int i, j, k = 0;
        int cnt = 0;
        int index2 = n / 2;
        int index1 = index2 - 1;
        int index1El, index2El = Integer.MIN_VALUE;

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (index1 == cnt)
                    index1El = nums1[i];
                if (index2 == cnt)
                    index2El = nums2[i];
                i++;
                cnt++;
            } else {
                if (index1 == cnt)
                    index1El = nums1[j];
                if (index2 == cnt)
                    index2El = nums2[j];
                j++;
                cnt++;
            }
        }

        while (i < n1) {
            if (index1 == cnt)
                index1El = nums1[i];
            if (index2 == cnt)
                index2El = nums2[i];
            cnt++;
            i++;
        }

        while (j < n2) {
            if (index1 == cnt)
                index1El = nums1[j];
            if (index2 == cnt)
                index2El = nums2[j];
            j++;
            cnt++;
        }
        if (n % 2 == 1) {
            // if it's an odd length array median is middle element of the array which is
            // index2El
            return (double) index2El;
        }
        double median = ((double) index1El + (double) index2El) / 2.0;
        return median;
    }
}
