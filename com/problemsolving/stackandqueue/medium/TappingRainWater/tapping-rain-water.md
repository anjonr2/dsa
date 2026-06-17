Intuition : 
Imagine looking at the ground from a side view after a heavy rain.Water gets trapped in the dips and vallyes between the heights. To determine the amount of trapped water, it's essential to know the highest barriers to the left and right of each position. 

By knowing the maximum heights to the left and right of each position, the water level at that position will be determined by the shorter of these two barriers. The difference between this water level and the height of the ground at that position will give the amount of water trapped there

Traversing to the left and right side to get the maximum for every height of ground is inefficient
To solve this problem efficiently, two auxiliary arrays will be used to store the maximum heights to the left and right of each position

Prefix Maximum Array : Stores the maximum of all the elements to the left till the current indices
Suffix Maximum Array : Stores the maximum of all the elements to the right from the current index

Approach 
>Store the maximum height from the start to each position in this array. This will help in determining the maximum height to the left of any position
>Store the maximum height from each position to the end of the array in this array. This will help in determining the maximum height to the right of any position
>Traverse the array and for each position, determine the water level using the minimum of the prefix and suffix maximum heights. Subtract the ground height at that position from this water level to calculate the trapped water at that position


Optimal Approach ---
In brute force approach storing suffix and prefix Maximum was taking extra space

However, at a particular height, only the minimum height (out of left maximum height and right maximum height) was considerd. This simply means at a particular building either the left maximum or right maximum height was useful

We can't find the left and right maximum beforehand, but we can do so by traversing the array from both ends using two pointers. Left and right maximum heights can be maintained and based on these values the water on top of current height can be calculated using the formula : 

water = min(leftMax, rightMax) - height[i]

where height[i] is the height of the ground at any given index i

Approach : 
Start with two pointers at the begining and end of the array. Maintain two variables to keep track of the maximum heights encountered so far from both directions

Move using a for loop and compare the heights at the current positions of the pointers

If the height at the left pointer is less than or equal to the height at the right pointer
a.If the current height is less than the maximum height on the left, calculate the water trapped and add to the total
b.Otherwise update the maximum height on the left. Move the left pointer to the right

If the height at the right pointer is less:
If the current height is less than the maximum height on the right, calculate the water trapped and add to the total
Otherwise update the maximum height on the right. Move the right pointer to the left

