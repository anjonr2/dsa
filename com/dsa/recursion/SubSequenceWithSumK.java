package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceWithSumK {
    private static List<List<Integer>> subseqWithSumK(){
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }
    private static int sum(List<Integer> list){
        int total = 0;
        for(int e : list){
            total+=e;
        }
        return total;
    }
    public static void main(String[] args){
        System.out.println("Test");
    }
}
