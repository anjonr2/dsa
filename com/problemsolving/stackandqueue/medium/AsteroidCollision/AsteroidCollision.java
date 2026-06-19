package com.problemsolving.stackandqueue.medium.AsteroidCollision;

import java.util.ArrayList;
import java.util.List;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        /* List implementation of stack */
        List<Integer> st = new ArrayList<>();

        /* Traverse all the asteroids */
        for (int i = 0; i < n; i += 1) {

            /*
             * Push the asteroid in stack if a right moving asteroid is seen
             */
            if (asteroids[i] > 0) {
                st.add(asteroids[i]);
            }
            /*
             * Else if asteroid is moving left perform the collision
             */
            else {
                /*
                 * Until the right moving asteroids are smaller in size, keep on destroying them
                 */
                while (!st.isEmpty() && st.get(st.size() - 1) > 0 && st.get(st.size() - 1) < Math.abs(asteroids[i])) {
                    st.remove(st.size() - 1);
                }

                /*
                 * If there is a right moving asteroid which is of same size
                 */
                if (!st.isEmpty() && st.get(st.size()) == Math.abs(asteroids[i])) {

                    // Destroy both the asteroids
                    st.remove(st.size() - 1);
                }
                /*
                 * Otherwise, if there is no left moving asteroid , the right moving asteroid
                 * will not be destroyed
                 */
                else if (st.isEmpty() || st.get(st.size() - 1) < 0) {

                    // Storing the array in final state
                    st.add(asteroids[i]);
                }
            }
        }

        // convert list to array
        int[] result = new int[st.size()];

        for (int i = 0; i < st.size(); i += 1) {
            result[i] = st.get(i);
        }
        return result;
    }
}

/*
 * Time complexity : O(N) (where N is the size of the aesteroid array)
 * Space complexity : O(N) In the worst case, all asteroids will be stored in
 * the stack if there are no collisions, leading to a space requirement of O(N)
 */