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
}
