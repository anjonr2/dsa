public class SplitArrayLargestSum {
    /*
     * Let's say int arr[] = [10, 20, 30, 40]. So here could the minimized largest
     * sum ever be 25?
     * Problem : If we set maximum allowed sum to 25 , number 30 and 40 cannot be
     * fit into any subarray partition
     * A Subarray must contain atleast one element, and if that single element is
     * already larger than limit , the configuration is impossible
     */
    private int countPartitions(int[] a, int maxSum) {
        int n = a.length;
        int partitions = 1;
        long subArraySum = 0;

        for (int i = 0; i < n; i += 1) {
            if (subArraySum + a[i] <= maxSum) {
                // Add element to the current subarray sum
                subArraySum += a[i];
            } else {
                partitions += 1;
                subArraySum = a[i];
            }
        }
        return partitions;
    }

    /*
     * Function to find the largest minimum subarray sum with at most k partitions
     */
    public int largestSubarraySumMinimized(int[] a, int k) {
        int low = a[0];
        int high = 0;
        int n = a.length;

        for (int i = 0; i < n; i += 1) {
            low = Math.max(low, a[i]);
            high += a[i];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int partition = countPartitions(a, mid);

            if (partition > k) {
                /*
                 * If the number of partitions exceeds the given limit. If it does , it
                 * indicates that the current value of 'mid' is too small so the left half is
                 * eliminated
                 */
                low = mid + 1;
            } else {
                /* If the partitions are within k, try to minimize the subarray sum further */
                high = mid - 1;
            }
        }
        return low;
    }
}
