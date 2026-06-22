In brute force solution precomputing PSE and NSE arrays is contributing to multiple traversals.This can be avoided by finding the PSE on the go. And finding NSE still remains same

for example
heights = {2,1,5,6,2,3}

traverse heights array from left to right. from i=0 to n-1

Stack<Integer> stack = new Stack<>();

i = 0 heights[i] = 2 push index 0 to stack
stack.push(0)

at index i = 1 heights[i] = 1

since at index i = 1 heights[1] < stack.top() which is 2 so stack's order of storing element in increasing order is broken

so pop i=0 out from the stack

so it is clear that for i = 0 when heights[i] =2 so next smaller element of 2 is 1 which is at index i = 1

Hence the index of NSE is known while popping the elements from the stack, serving as a backward traversal
Hence width of the rectangle can be determined using the formula : 
width = nse[ind] - pse[ind] - 1

where nse[ind] and pse[ind] represents the indices of the previous and next smaller element for the current index

Since the areas of only those rectangles are considerd that are popped from the stack, to ensure all the possible heights are considerd for areas, all the elements must be popped from the stack even after the traversal of the array is complete. For such elements (that remains in the stack after traversal), the index of the next smaller element will be set to the size of the array, as there is no next smaller element

Approach : 
Initialize an empty stack to store indices of histogram bars. For each height in the histogram, maintain a stack of indices where the heights are in increasing order

If the current height is shorter than the height at the top of the stack, it means the reactangle with the height at the top of the stack ends at the current bar

For each popped bar from the stack, calculate the current index as the next smaller element and index of the new top of the stack as the previous smaller element

