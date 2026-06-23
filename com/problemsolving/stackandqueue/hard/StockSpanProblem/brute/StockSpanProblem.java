package com.problemsolving.stackandqueue.hard.StockSpanProblem.brute;

public class StockSpanProblem {
    // Function to find span of stock prices for each day
    public int[] stockSpan(int[] arr, int n) {

        int ans[] = new int[n];

        // traverse the array
        for (int i = 0; i < n; i += 1) {

            // to store current span of the stocks
            int currentSpan = 0;

            // traversing backwards to find stock span
            for (int j = i; j >= 0; j -= 1) {
                if (arr[j] <= arr[i]) {
                    currentSpan += 1;
                } else {

                    // Else breakout from the loop
                    break;
                }
            }

            ans[i] = currentSpan;
        }

        return ans;
    }
}
