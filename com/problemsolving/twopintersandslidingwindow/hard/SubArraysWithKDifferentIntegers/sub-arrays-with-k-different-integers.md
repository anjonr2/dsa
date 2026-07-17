You are given an integer array nums and an integer k. Return the number of good subarrays of nums
A good subarray is defined as a contiguous subarray of nums that contains exactly k distinct integers 

Input: nums = [1, 2, 1, 2, 3], k = 2  
Output: 7
Explanation: The 7 subarrays with exactly 2 different integers are:
[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]


Input: nums = [1, 2, 1, 3, 4], k = 3  
Output: 3
Explanation: The 3 subarrays with exactly 3 different integers are:  
[1,2,1,3], [2,1,3], [1,3,4] 