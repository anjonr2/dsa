Given a binary array nums and an integer k, flip at most k 0's .
Return the maximum number of consecutive 1's after performing the flipping operation

Input : nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0] , k = 3
Output : 10
Explanation : The maximum number of consecutive 1's are obtained only if we flip the 0's present at position 3,4,5 (0 based indexing)

The array after flipping becomes [1,1,1,1,1,1,1,1,1,1,0]
The number of consecutive 1's is 10

Brute force approach : 
In this approach idea is to generate all possible substrings of the given array and while doing so, keep a track of all the zeros encountered so far in the substring. If the number of zeros exceeds k the no need to consider that substring 

Approach : 
1.Iterate the array using for loop which runs from 0 to sizeOfArray - 1, which indicates the starting point of a substring. And initialize a variable to 0 which keeps count of the number of zeros in the substring

2.Use another for loop which basically indicates the ending point of the substring, and if the current element is 0 increase count of zeros by 1

3.If the number of zeros in the current substring exceeds k then break out of the inner loop, no need to consider such string. 



Better solution : 
We can use sliding window concept to solve this problem in linear time

Approach : 

1. First, initialize few variables as : l and r as pointers to the left and right ends of the window respectively, both starting at the beginning of the array nums, zeros to keep track of the number of zeros encountered within the current window, maxLen 

2.In sliding window r moves from 0 till last element of the array. if arr[r] is 0 then increment count of zero

3.While zeros exceed k, adjust the window by moving l to right until zeros is less than or equal to k. This ensures that the window contains at most k zeros

Optimal approach : 
In Optimal approach idea is to employ the sliding window approach efficiently by avoiding the additional O(N) time complexity incurred when shifting the window entirely in the better solution, to ensure total number of zeros does not exceed k. Instead of moving the left pointer l to eliminate excess zeros completely, shift the window by one position at a time

Approach : 
1.First initialize few variables as l and r where l marks the left boundary and r marks the right boundary of the sliding window 

2.Use the r pointer to traverse through the array. For each element check if it is zero increment the zeros count

3.After incrementing zeros check if it has exceeded the allowed limit k, if so, adjust the window by moving the l pointer to the right until the window contains at most k zeros (zeros <= k). Decrement the zeros count accordingly when the element pointed by l is 0 and increment l