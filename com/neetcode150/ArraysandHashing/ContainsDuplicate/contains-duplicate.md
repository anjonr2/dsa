Description

Given an integer array nums, return true if any value appears more than once in the array, otherwise return false

Example 1 : 

Input: nums = [1, 2, 3, 3]

Output: true

Input: nums = [1, 2, 3, 4]

Output: false

A brute force solution would be to check every element against every other element in the array. This would be an O(n^2) solution. 

An alternative approach sorts the array to bring duplicate adjacent, then scans linearly