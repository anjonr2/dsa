package com.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArray {
    public static List<Integer> rotateArray(List<Integer> arr, int k) {
        int size = arr.size();
        k = k % size;
        if (size == 0) {
            return arr;
        }
        reverse(arr, 0, k - 1);
        reverse(arr, k, size - 1);
        reverse(arr, 0, size - 1);
        return arr;
    }

    public static void reverse(List<Integer> arr, int startingIdx, int endingIdx) {
        while (startingIdx <= endingIdx) {
            int temp = arr.get(startingIdx);
            arr.set(startingIdx, arr.get(endingIdx));
            arr.set(endingIdx, temp);

            startingIdx++;
            endingIdx--;
        }
    }

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7 };
        List<Integer> list = Arrays.asList(array);
        ArrayList<Integer> ans = rotateArray(list, 3);
        System.out.println(list.toString());
    }
}
