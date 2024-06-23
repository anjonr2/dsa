package easy;

public class CheckIfSorted {
    public boolean check(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // if any future element is smaller than nums[i] then it is not sorted
                if (nums[i] > nums[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
