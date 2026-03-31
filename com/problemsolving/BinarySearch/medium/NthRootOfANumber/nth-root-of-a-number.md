Input N = 3, M = 27
Output : 3

Explanation : Cube root of 27 is equal to 3

Input N = 4, M = 69

Output : -1;

Explanation : The 4th root of 69 does not exist. So the answer is -1

Linear search approach --------------

Perform a linear search in range [1,M]. Calculate the value of x raised to power N for every x in this range
If it is equal to the given number then x is then nth root of the number. If no such number(x) exisits, return -1 as an answer

Approach
>Iterate from 1 to M(given number). Calculate the value of x raised to power n as follows : 
 1. Start with result as 1 and keep track of the base value
 2.If the exponent is odd , multiply the result by the base and reduce the exponent by 1
 3.If the exponent is even , square the base and half the exponent
 4.Continue the process until exponent becomes 0 and final result is returned

 If the result is equal to M, this means x is the Nth root of M. So return x
 If the calculated value is smaller than M , then continue to next iteration
 if the calculated value is greater than M, In this case our answer does not exist and break out from 
 this step and return -1