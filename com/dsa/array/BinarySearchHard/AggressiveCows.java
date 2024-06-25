package BinarySearchHard;

import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        int start = stalls[0];
        int n = stalls.length;
        int ans = Integer.MIN_VALUE;

        Arrays.sort(stalls);
        int end = stalls[n - 1] - stalls[0];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = 1;
            int position = stalls[0];
            for (int i = 1; i < n; i++) {
                if (position + mid <= stalls[i]) {
                    count++;
                    position = stalls[i];
                }
            }
            if (count < k) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
