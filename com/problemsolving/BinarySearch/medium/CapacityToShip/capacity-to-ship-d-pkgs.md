Given an array of weights where weights[i] represents the weight of the i-th pkg
Task is to find the minimum possible capacity of the ship so that all the pkgs can be shipped within a given number of days

weights = [1,2,3,4,5,6,7,8,9,10] days = 5;
Output : 15

Explanation : Minimum ship capacity = 15
Day 1 : 1+2+3+4+5 = 15
Day 2 : 6+7 = 13
Day 3 : 8
Day 4 : 9
Day 5 : 10

Linear search approach ------------
> Determine the minimum possible capacity as the maximum weight of a single pkg
> Determine the maximum possible capacity as the sum of all pkgs weights