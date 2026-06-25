package com.problemsolving.array.easy.RemoveDuplicates.optimal;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // pointer for unique elements
        int i = 0;

        for (int j = 1; j < nums.length; j += 1) {
            /*
             * If the current element is different from the previous then unique element is
             * found
             */
            if (nums[j] != nums[i]) {
                /*
                 * Move to the next position in the array to make place for unique element
                 */
                i++;

                /*
                 * Update the current position with unique element
                 */
                nums[i] = nums[j];
            }
        }

        /* Return the number of unique elements */
        return i + 1;
    }
}
