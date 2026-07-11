Given a binary array nums and an integer goal. Return the number of non-empty subarrays with a sum goal

Input : nums = [1,1,0,1,0,0,1], goal = 3
Output : 4
Explanation : The subarrays with sum 3 are
[1,1,0,1]
[1,1,0,1,0]
[1,1,0,1,0,0]
[1,0,1,0,0,1]

Here, the idea is to use two-pointers approach to optimize the solution. So , basically instead of finding the count of subarrays which have sum exactly equal to goal, we need to find the count of subarrays whose sum is less than or equal to goal and the count of subarrays whose sum is less than or equal to goal-1. The difference between both will provide the required result in linear time

Let,

A = count of subarrays(sum <= goal)
B = count of subarrays(sum <= goal-1)

Here, A contains count of all subarrays having sum : 0,1,2,.....,goal
B contains count of all subarrays having sum : 0,1,2,3,......., goal-1

So when we substract B from A, all subarrays with sum smaller than goal get removed
leaving only the subarrays whose sum is exactly equal to goal

Hence,
ans = count of subarrays(sum <= goal) - count of subarrays(sum <= goal-1)