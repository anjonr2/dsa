package com.problemsolving.BinarySearch.easy.CountOccurences.BinarySearchApproach;

import com.problemsolving.BinarySearch.easy.FirstAndLastOccurences.BinarySearchApproach.FirstAndLastOccurence;

public class CountOccurences {
    // int[] arr = {1, 2, 2, 2, 3, 4}; target = 2. First occurence of 2 is at 1st
    // index and last occurence of 2 is at 3rd index. So count of 2's occurences is
    // last occurence index - first occurence index + 1 = 3- 1 + 1 = 3
    public int countOccurences(int[] nums, int target) {
        FirstAndLastOccurence firstAndLastOccurence = new FirstAndLastOccurence();
        int first = firstAndLastOccurence.firstOccurence(nums, target);
        if (first == -1)
            return 0; // if the target element is not present in the array then first occurence will
                      // be -1 and count of occurences will be 0
        int last = firstAndLastOccurence.lastOccurence(nums, target);
        return last - first + 1;

    }
}
