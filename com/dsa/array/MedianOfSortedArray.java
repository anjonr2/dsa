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
}
