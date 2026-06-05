Problem Statement : Given a positive integer n, set the rightmost unset (0) bit of its binary representation to 1 and return the resulting integer. If all the bits are set, return the number as it is

Example 1

Input
n = 10 (binary 1010)

Output 
11 (binary 1011)

Explanation 
Thr rightmost unset bit is the least significant bit (LSB). Setting it to 1 gives 1011 = 11

Example 2
Input n = 7 (binary 111)

Output
n = 7

All bits are already set to 1, so the number remains same

Approach 
Use bitwise OR with n+1
result = n | n+1
n+1 flips the rightmost 0 in n to 1, and all bits to the right become 0
Performing OR sets that bit to 1 while leaving other bits unchanged 