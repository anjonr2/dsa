package com.problemsolving.stackandqueue.hard.CelebrityProblem.brute;

public class CelebrityProblem {
    // function to find index of celebrity
    public int celebrity(int[][] M) {
        int n = M.length;

        /* To store count of people who know person of index i */
        int[] knowMe = new int[n];

        /* To store count of people known by person of index i */
        int[] IKnow = new int[n];

        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < n; j += 1) {

                // if person i knows person j
                if (M[i][j] == 1) {
                    knowMe[j] += 1;
                    IKnow[i] += 1;
                }
            }
        }

        // Travese for all the person to find the celebrity
        for (int i = 0; i < n; i += 1) {
            if (knowMe[i] == n - 1 && IKnow[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
