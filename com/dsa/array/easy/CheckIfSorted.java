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

    public boolean check1(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 0) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
