There is only row of fruit trees on the farm, oriented left to right. An integer array called fruits represents the trees, where fruit[i] denotes the kind of fruit produced by the ith tree

The goal is to gather as much fruit as possible, adhering to below rules

1.There are two baskets available, and each basket can only contain one kind of fruit. The quantity of fruit each basket can contain is unlimited

fruits : [1, 2, 1]
Output : 3

Explanation : We will start from the first tree 
The first tree produces the fruit of kind '1' and we will put that in the first basket
The second tree produces the fruit of kind '2' and we will put that in the second basket
The third tree produces the fruit of kind '1' and we have first basket that is already holding fruit of kind '1'. So we will put it in first basket
Hence we are able to collect total of 3 fruits


fruits : [1,2,3,2,2]
Output : 4
if we start from 2nd tree, 1st index
first index will have fruit from : 1,3,4th index
2nd basket will have fruit from : 0th index

Bruteforce approach : 
1.Iterate the array for each index from 0 to sizeOfArray - 1 to consider each index as the starting point of a substring

2.For each starting point, initialize an empty set to to keep track of types of fruits in the current substring and start another loop from starting point of the substring till sizeOfArray-1. Add each fruit to the set

3.After adding each fruit , check the size of the set . Set will only contain fruits that appear in the current substring

4.If the size of set is less than or equal to 2, it means the current substring has at most 2 different types of fruits