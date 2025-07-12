package com.dsa.bitmanipulation.InterviewProblems.SingleNumberIII.bruteforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumberIII {
    public List<Integer> singleNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i += 1) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) == 1)
                ans.add(key);
        }
        Collections.sort(ans);
        return ans;
    }
}
