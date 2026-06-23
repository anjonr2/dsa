package com.problemsolving.stackandqueue.hard.CelebrityProblem.optimal;

public class CelebrityProblem {
    public int celebrity(int[][] M) {
        int n = M.length;

        int top = 0, down = n - 1;

        while (top < down) {
            /*
             * if top knows down, top can not be a celebrity
             */
            if (M[top][down] == 1) {
                top = top + 1;
            }

            else if (M[down][top] == 1) {
                down = down - 1;
            }

            /*
             * If both do not know each other, both cannot be celebrity
             */
            else {
                top++;
                down--;
            }
        }

        // Return -1 if no celebrity is found
        if (top > down)
            return -1;

        // when while loop breaks top == down
        /*
         * Check if the person pointed by top is celebrity
         */
        for (int i = 0; i < n; i += 1) {
            // do not check for diagonal element like M[1][1] , it's the same person
            if (i == top)
                continue;
            /*
             * M[top][i] = checks across all M[top] array
             * M[i][top] = checks for the entire column pointed by index top
             */
            if (M[top][i] == 0 && M[i][top] == 1)
                return top;
        }

        return -1;
    }
}
