package easy;

import java.util.ArrayList;
import java.util.List;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp.add(nums[i]);
            }
        }
        int m = temp.size();
        for (int i = 0; i < m; i++) {
            nums[i] = temp.get(i);
        }
        for (int i = m; i < n; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        int j = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // finding the position of the first 0 element
                j = i;
                break;
            }
        }
        if (j == -1) {
            // there is no non zero elements
            return;
        }
        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
