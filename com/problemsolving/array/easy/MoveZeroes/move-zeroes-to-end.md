Brute force : 
We can store the non-zero numbers separately and then place those numbers back into the original array. This ensures that all the non-zero numbers are kept at the front of the array. Lastly, fill the remaining positions in the array with zeroes

Approach : 
1. Declare a temporary array to store all the non-zero elements. Traverse the original array and  copy all non-zero elements to the temporary array

2. Overwrite the original array's starting positions with the elements from the temporary array
3. Fill the remaining position the original array with zeros

To do this efficiently 
1. Start by taking two pointers i, j . initialize j = 0. The pointer j will track the position where the next non-zero element should be placed
2. Traverse the array using pointer i from index 0 to n-1
3. Whenever i encounters a non-zero element, swap the elements at position i and j.
