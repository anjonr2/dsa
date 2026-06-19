The brute force way to solve this problem is by generating all the subarrays and finding the minimum and maximum values in all of them. The range of a subarray can be found as the difference between the maximum and minimum value which can be summed up for all the subarrays to get the result 

Approach: 
1. Initialize a variable to store the required sum with 0 initially
2. Traverse on the array. Initialize two variables to store the minimum and maximum elements in the subarray
3. Use a nested loop to traverse all the subarrays and find the minimum and maximum of each subarray. Update the sum for each subarray by finding the range of subarray (maximum - minimum)