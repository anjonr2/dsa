Given an array of integers nums and an integer limit as the threshold value, find the smallest positive integer divisor such that upon dividing all the elements of the array by this divisor, the sum of the division result is less than or equal to threshold value

Afrer dividing each element by the choosen divisor, take the ceiling of the result (i.e round up to the next whole number)

Linear search approach ------

Traverse from 1 to maximum element of the array to check all possible divisors

Within this loop divide each element in the array by the current divisor, and sum up the obtained ceiling values