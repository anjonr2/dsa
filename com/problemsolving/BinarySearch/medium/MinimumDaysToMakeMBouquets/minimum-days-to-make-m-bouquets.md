Given n roses and an array nums where nums[i] denotes that the i'th rose will bloom on the nums[i] th day, only adjacent bloomed roses can be picked to make a bouquet . Exactly k adjacent bloomed roses can be picked to make a bouquet

Ask is to find minimum number of days required to make atleast m bouquets each containing k roses

Input n = 8, nums = [7,7,7,7,13,11,12,7], m=2, k=3
Output : 12
Explanation : On the 12th day the first 4 flowers and and the last 3 flowers would have already bloomed so we can easily make 2 bouquets, one with the first 3 flowers another with the last 3 flowers

Linear search approach --------------

In this approach we have to linearly check all possible answers from range min to max linearly, where min is the minimum element of the array and max is the maximum element of the array. Each number in the range shows the number of days 

Edge case : If the product k * m (number of bouquet required) is greater than size of the array , then it is impossible to make bouquet, in that case return -1