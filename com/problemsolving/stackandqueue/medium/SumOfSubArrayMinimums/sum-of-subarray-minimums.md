Given an array of integers arr of size n, calculate the sum of the minimum value in each(contiguous) subarray of arr
Since the result may be large, return the answer modulo 10^9+7

Example
Input: arr = [2,3,1]
[2] - 2
[2,3] - 2
[2,3,1] - 1
[3] - 3
[3,1] - 1
[1] - 1

total = 2 + 2 + 1 + 3 + 1 + 1
      = 10


Brute force approach is to generate all the subarrays and finding the minimum in all of them.All the minimums can be summed up while taking modulus with 10^9 + 7 to return the result

Instead of generating all the subarrays and finding the minimum in each subarray to find the sum, we can get the required sum by finding the number of times an element in the array will be considerd in sum

How to find the frquency of an element in the required sum?
To find the frequency we need to figure out number of subarrays where the current element will be minimum

Current element will be considerd in all those subarrays that :
1. Do not start with the previous smaller element which includes current element
2. Do not end with the next smaller element , which includes current element

Finding count of required subarrays

The count of subarrays that contain the current element as the minimum element is the subarrays whose
1. Starting index lies in the range(pse[ind], ind] (excluding pse[ind] and including ind)
Count of such subarrays is: ind - (pse[ind] + 1) + 1
i.e ind - pse[ind]
2.Ending index lies in the range [ind, nse[ind])(including ind and excluding nse[ind])
Count of such subarray is : (nse[ind] - 1) - ind + 1
i.e nse[ind] - ind

where pse[ind] and nse[ind] refer to the indices of previous smallest element and the next smallest element for the element at index ind

So of count of subarrays having the current element (having index ind) as minimum is
(ind-pse[ind]) * (nse[ind] - ind)

Approach
For each element in the array, find the index of the next smaller element(NSE) to the right. Use a stack to efficiently track these indices

For each element in the array, find the index of the previous smaller or equal element (PSE) to the left. Use a stack to efficiently track these indices

For each element in the array, calculate its contribution to the sum of subarray minimums based on its frequency as the minimum in the subarrays. Use the indices from NSE and PSE to determine the count of subarrays where the current element is minimum


