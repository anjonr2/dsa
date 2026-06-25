To rotate an array by K positions to the left, we have to move first k elements of the array to the end, while the remaining element will shift K positions to the left

Thought process involves first capturing the first K elements in a temporary array. Next, shift each of the remaining elements from position K to the beginning of the array. Finally, append the temporarily stored elements to the end of the array. This approach ensures that the array is rotated to the left by K positions effectively

Approach : 
1. First , calculate the effective number of rotations by taking the modulo of K with the array size to avoid unecessary rotations
2. Create temporary array to store first K elements of the array
3. Shift the (N-K) elements of the array to the front
4. Copy the stored K elements from the temporary array to the end of the array

That's how array is rotated to the left by K places

The most optimal solution works based on the properties of reversing sections of the array. This involves reversing different parts of the array to achieve the desried solutions

Approach
1. Reverse the first K element of the array
2. Reverse next n-k element of the array
3. Reverse the entire array