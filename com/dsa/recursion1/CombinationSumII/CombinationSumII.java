package com.dsa.recursion1.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public void findCombinations(int currIndex, int[] candidates, int target, List<Integer> currentCombination,
            List<List<Integer>> result) {
                if(target == 0){
                    result.add(new ArrayList<>())
                }
                if( currIndex == candidates.length || target < 0){
                    return;
                }
                //Include the current element
                currentCombination.add(candidates[currIndex]);
                findCombinations(currIndex+1, candidates, target-candidates[currIndex], currentCombination, result);
                //Backtrack to remove the last added element
                //and exclude it from the current combination
                currentCombination.remove(currentCombination.size()-1);

                for(int i = currIndex + 1; i<candidates.length; i++){
                    if(candidates[i] != candidates[currIndex]){
                        findCombinations(i, candidates, target, currentCombination, result);
                        break;
                    }
                }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, currentCombination, result);
        return result;
    }
}
