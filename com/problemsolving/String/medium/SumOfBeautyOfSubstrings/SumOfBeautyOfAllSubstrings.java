package com.problemsolving.String.medium.SumOfBeautyOfSubstrings;

public class SumOfBeautyOfAllSubstrings {

    private int getMinCount(int[] freq) {
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i += 1) {
            minCount = Math.min(minCount, freq[i]);
        }
        return minCount;
    }

    private int getMaxCount(int[] freq) {
        int maxCount = 0;
        for (int i = 0; i < 26; i += 1) {
            maxCount = Math.max(maxCount, freq[i]);
        }
        return maxCount;
    }

    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i += 1) {
            /* as there are 26 alphabets in lower case so array size is 26 */
            int[] freq = new int[26];
            for (int j = i; j < n; j += 1) {
                freq[s.charAt(i) - 'a'] += 1;
                int beauty = getMaxCount(freq) - getMinCount(freq);
                sum += beauty;
            }
        }
        return sum;
    }
}
