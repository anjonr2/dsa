package com.dsa.array.medium;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArrayProblem {
    public static ArrayList<Integer> findLeaders(ArrayList<Integer> elements, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(elements.get(n - 1));
        int maximum = elements.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (elements.get(i) > maximum) {
                result.add(elements.get(i));
                maximum = elements.get(i);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
