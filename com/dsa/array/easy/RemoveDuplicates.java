package easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    static int removeDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x : set) {
            arr[j++] = x;
        }
        return k;
    }
}
