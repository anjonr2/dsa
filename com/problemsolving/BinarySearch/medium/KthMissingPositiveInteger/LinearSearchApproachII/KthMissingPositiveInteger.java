package com.problemsolving.BinarySearch.medium.KthMissingPositiveInteger.LinearSearchApproachII;

/*
for example arr = [2, 3, 4, 7, 11]` and `k = 5`

**Iteration 1: num = 2, prev = 0**
- `missing = num - prev - 1 = 2 - 0 - 1 = 1`
- This means 1 number is missing before 2 (which is the number 1)
- Check if `k <= missing`? k=5, missing=1 → No
- Update: `k = k - missing = 5 - 1 = 4`
- Update `prev = 2`

**Iteration 2: num = 3, prev = 2**
- `missing = 3 - 2 - 1 = 0` (no missing numbers between 2 and 3)
- k=4, missing=0 → No action
- Update `prev = 3`

**Iteration 3: num = 4, prev = 3**
- `missing = 4 - 3 - 1 = 0`
- k remains 4
- Update `prev = 4`

**Iteration 4: num = 7, prev = 4**
- `missing = 7 - 4 - 1 = 2` (missing numbers: 5 and 6)
- Check if k <= missing? k=4, missing=2 → No
- Update: `k = 4 - 2 = 2`
- Update `prev = 7`

**Iteration 5: num = 11, prev = 7**
- `missing = 11 - 7 - 1 = 3` (missing numbers: 8, 9, 10)
- Check if k <= missing? k=2, missing=3 → Yes
- Return `prev + k = 7 + 2 = 9`

**Result: 9** (the 5th missing positive number)

## Visual Representation
```
Positive integers: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,...
Array elements:      2, 3, 4,    7,       11
Missing numbers:  1          5,6  8,9,10   12,...

Position:         1st       2nd,3rd 4th,5th,6th 7th,...
The 5th missing number is 9 ✓
```
 */
public class KthMissingPositiveInteger {
    public int findKthMissingInteger(int nums[], int k) {
        int prev = 0;
        for (int num : nums) {
            // count missing number between prev and current
            int missing = num - prev - 1;

            // if k is within the missing number
            if (k <= missing) {
                return prev + k;
            } else {
                k = k - missing;
                prev = num;
            }
        }
        return prev + k;
    }
}
