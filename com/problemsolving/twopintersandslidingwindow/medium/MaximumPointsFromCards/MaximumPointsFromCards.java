package com.problemsolving.twopintersandslidingwindow.medium.MaximumPointsFromCards;

public class MaximumPointsFromCards {
    /*
     * Function to calculate the maximum score after picking k cards
     */
    public int maxScore(int[] cardScore, int k) {
        int lSum = 0, rSum = 0, maxSum = 0;

        /*
         * Calculate the initial sum of first k cards
         */
        for (int i = 0; i < k; i += 1) {
            lSum += cardScore[i];

            /*
             * Initialize maxSum with sum of first k cards
             */
            maxSum = lSum;
        }

        /* Initialize rightIndex to iterate array from last */
        int rightIndex = cardScore.length - 1;

        for (int i = k - 1; i >= 0; i -= 1) {
            /* Remove the score of the ith card from the left sum */
            lSum -= cardScore[i];

            /*
             * Add the score of the card from the right to the right sum
             */
            rSum += cardScore[rightIndex];

            /* Move to the next card from the right */
            rightIndex--;

            maxSum = Math.max(maxSum, lSum + rSum);
        }
        return maxSum;
    }
}

/*
 * Time complexity : O(2 * k). Where k is the size of the window given in the
 * input
 */