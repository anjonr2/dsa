package com.dsa.twopointerandslidingwindow.MaxPointsScoredFromCard;

public class MaxPointsScored {
    public int maxScore(int[] cardPoints, int k) {
        int maxScore = 0;
        int leftScore = 0;
        int rightScore = 0;
        int n = cardPoints.length;
        for (int i = 0; i < n; i++) {
            leftScore += cardPoints[i];
            maxScore = leftScore;
        }
        int rightIndex = n - 1;
        for (int i = k - 1; i >= 0; i -= 1) {
            rightScore += cardPoints[rightIndex];
            rightIndex -= 1;
            leftScore -= cardPoints[i];
            maxScore = Math.max(maxScore, leftScore + rightScore);
        }
        return maxScore;
    }
}
