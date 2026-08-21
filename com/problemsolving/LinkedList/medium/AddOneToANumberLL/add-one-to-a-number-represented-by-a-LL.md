Here each node contains a single digit
The first node contains the leftmost digit

Approach 
Reverse the Linked List : Reverse the linked list so we can start the addition from the rightmost digit

Add One : Add one to the first digit of the reversed list. If there's carry (result is 10), set the current digit to 0 and carry over 1 to the next digit

Handle the Carry : Reverse the list again to restore the original order, now with the added value

Recursive approach ---------------------------

1. To add a number represented as a linked list, we use a recursive function addHelper. This function traverses the list to the end, with the base case being when the current node is NULL, returning a carry of 1 to signify adding one to the number

2. During each recursive call, we add the carry returned by the next node to the current node's value. If the current node's value is less than 10, no further carry is needed, so we return 0. If the value is 10 or more, we set the current node's value to 0 and return a carry 1 to be added to the next significant digit

3. After processing all nodes, we check if there's a carry left. If there is. we create a new node with a value of 1 and set it as the new head of the list. This handles cases where an additional digit is needed, like adding 1 to 999 which results in 1000
