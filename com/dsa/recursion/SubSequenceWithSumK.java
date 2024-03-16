package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceWithSumK {
    private static List<List<Integer>> subseqWithSumK(int[] input, int sum){
        List<List<Integer>> result = new ArrayList<>();
        findSubSeq(input,sum,0,new ArrayList<>(),result);
        return result;
    }
    private static void findSubSeq(int[] input,int sum, int idx,List<Integer> current,List<List<Integer>> result){
        if(idx==input.length){
            if(sum(current)==sum){
                result.add(new ArrayList<>(current));
            }
            return;
        }
        //pick the element at current idx
        current.add(idx);
        findSubSeq(input,sum,idx+1,current,result);

        //backtrack and remove the current element
        current.remove(current.size()-1);
        findSubSeq(input,sum,idx+1,current,result);
    }
    private static int sum(List<Integer> list){
        int total = 0;
        for(int e : list){
            total+=e;
        }
        return total;
    }
    public static void main(String[] args){
        int [] nums = {1, 2, 3, 4, 5};
        int sum = 5;
        List<List<Integer>> subsequences = subseqWithSumK(nums,sum);

        System.out.println("Subsequences with sum "+sum+" :");
        for(List<Integer> subseq:subsequences){
            System.out.println(subseq);
        }
    }
}
