Given collection of candidate numbers (candidates) and a integer target. Find all unique combinations in candidates where the sum is equal to the target. There can be only one usage of each number in candidates combination and return the answer in sorted order

e.g : The combination [1,1,2] and [1,2,1] are not unique

Real life problem solving : To visualize the problem, imagine having a set of coins with different denominations and a target amount to achieve. The goal is to find all unique combinations of coins that add up to the target amount without reusing the same coin denominations multiple times in the same combination

In the recursive approach 
first a coin is selected and substracted it's value from the target
A valid combination is found when target becomes zero
If the target becomes negative or all coins are considerd, the current path is abandoned