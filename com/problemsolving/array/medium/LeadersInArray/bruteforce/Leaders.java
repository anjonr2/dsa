package com.problemsolving.array.medium.LeadersInArray.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class Leaders {
    public int[] findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i += 1) {
            boolean isLeader = false;
            for (int j = i + 1; j < n; j += 1) {
                if (arr[j] > arr[i]) {
                    isLeader = false;
                    break;
                }
                if (isLeader)
                    leaders.add(arr[i]);
            }
        }
        return leaders.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Leaders leaders = new Leaders();
        int[] arr = { 16, 17, 4, 3, 5, 2 };
        int[] result = leaders.findLeaders(arr);
        for (int leader : result) {
            System.out.print(leader + " ");
        }
    }
}
