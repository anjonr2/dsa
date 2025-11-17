package com.problemsolving.array.medium.sort0s1s2s.better;

public class Sort0s1s2s {
    public void sortArrayOf01and2(int nums[]) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == 0)
                cnt0 += 1;
            else if (num == 1)
                cnt1 += 1;
            else
                cnt2 += 1;
        }
        for (int i = 0; i < cnt0; i += 1)
            nums[i] = 0;
        for (int i = 0; i < cnt1; i += 1)
            nums[i] = 1;
        for (int i = 0; i < cnt2; i += 1)
            nums[i] = 2;
    }
}
