AND Operator

The AND operator is denoted by & and performs a bitwise AND operation. If both corresponding bits are 1, the resulting bit is 1; Otherwise the resulting bit is 0

example
 13 : 1101
 7  : 0111 
 &  : ----
o/p : 0101

OR operator 

The OR operator is denoted by 'I' pipe character and performs a bitwise OR operation. If either corresponding bit is 1, the resulting bit is 1; otherwise resulting bit is 0.

Example: 13 I 7 is

13 : 1101
7  : 0111
I  : ----
o/p: 1111

XOR Operator

XOR operator is denoted by ^ and performs a bitwise XOR operation. If the number of 1s in corresponding bit positions is odd, the resulting bit is 1, if even, the resulting bit is 0

13 ^ 7

13 : 1101
7  : 0111
^  : 1010

NOT operator

NOT operator is denoted by ~ and flips all the bits in the number

Example ~5 is : 
 5 : 0000 0101
 ~5: 1111 1010


Shift Operators 

Right Shift (>>): Shifts the bits to the right , discarding the bits that fall off and filling the leftmost bits with zeros 

Example 13 >> 1 = 1101 >> 1 = 0110

Left shift (<<) : Shifts the bits to the left, discarding the bits that fall off and filling the rightmost bits with zeros 

Example 13 << 1 = 1101 << 1 = 11010