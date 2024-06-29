package medium;

// solution explained :Striver &  https://leetcode.com/problems/next-permutation/solutions/3473399/beats-100-full-explanation-in-steps/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int idx1 = -1;
        int n = nums.length;
        int idx2 = -1;
        // traverse from back of the array to find index such that nums[i]<nums[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx1 = i;
                break;
            }
        }

        // if no breaking point than current array is the maximum permutation so reverse
        // it
        if (idx1 == -1) {
            reverse(nums, 0);
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > nums[idx1]) {
                    idx2 = i;
                    break;
                }
            }
            swap(nums, idx1, idx2);
            reverse(nums, idx1 + 1);
        }
    }

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
