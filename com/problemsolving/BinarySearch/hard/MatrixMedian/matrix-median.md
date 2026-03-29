Brute force
1. Gather all the elements from the matrix into a single list and sort them the median will simply be the middle element of that sorted list

Approach
1. Flatten the matrix : 
>Loop through each row of the matrix and append it's element to a new list
>This gives us a one-dimensional array containing all the matrix elements

Sort the 1D Array

Find the median
>Since the total number of elements is n * m, the median will be at index (n * m)/2 in sorted list