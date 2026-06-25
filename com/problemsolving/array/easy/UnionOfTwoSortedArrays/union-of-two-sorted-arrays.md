In Optimal approach it uses two pointers to solve the problem. Use two pointers, one for each array, and traverse both arrays simultaneously. Keep adding the smaller element between the two arrays to the result vector if it hasn't been added already.

What if both elements are equal?
If both elements are equal, add any one of them, ensuring that all unique elements are added in sorted order

Approach :

Initialize two variable i to iterate nums1 and j to iterate nums2 as 0

Create an empty vector for storing the union of nums1 and nums2

If the current element of nums1 is equal to current element of nums2, this means it's a common element so insert only one element in the union and increment it by 1

If current element of nums1 is less than current element of nums2, insert current element of nums1 in union. Also check if last element in union vector is not equal to nums1[i], then insert in union else don't insert. After checking increment i
