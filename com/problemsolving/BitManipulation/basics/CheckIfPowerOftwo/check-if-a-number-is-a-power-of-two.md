Given an integer n, return true if it is a power of two. Otherwise, return false

Example 1
Input n = 1
Output true
Explanation: 2^0 = 1

Example 2
Input n = 16
Ouput : true
Explanation 2^4 = 16

Every power of two in binary representation has exaclt one bit set to 1 (e.g, 1 = 0001, 2=0010, 4=0100, 8=1000). So if a number is a power of two 

It must be positive
And n & (n-1) must be 0