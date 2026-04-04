A monkey is given n piles of bananas where the ith piles of bananas has nums[i] bananas
An integer h represents the total time in hours to eat all the bananas

Need to determine minimum number of bananas monkey must eat per hour to finish all the bananas within h hours

Input n = 4 nums = [7,15,6,3] h=8
output k = 5
Explanation : If koko eats 5 bananas/hr, he will take 2,3,2 and 1 hour to eat the piles accordingly. So he will take 8 hours to complete all the piles

Linear search approach ---------

We can check for all possible answers from 1 to max
where max is the maximum element of the array 
The minimum number for which the required time is less than or equal to h , is the answer

Binary search approach --------------

Start by initializing low to 1 (minimum possible eating rate)