Given two integers n and i, return true if the ith bit in the binary representation of n (counting from the least significant bit 0-indexed) is set (i.e equal to 1). Otherwise return false

Example 1
Input n = 5, i = 0
Output: true
Explanation: Binary representation of 5 is 101. The 0-th bit from LSB is set (1)

Example 2

Input n = 10, i = 1
Output: true
Explanation: Binary representation of 10 is 1010. The 1st bit from LSB is Set (1)

Using bitwise operator -------------------------

Shift the value of 1 to the left by i positions to form a mask : 1 << i
Perform a bitwise AND between n and the mask : n & ( 1 << i)
If the result is non zero, it means the ith bit is set