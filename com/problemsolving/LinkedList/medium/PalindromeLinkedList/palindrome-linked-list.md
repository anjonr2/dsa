A simple way to determine if a give linked list is a palindrome is to use an additional data structure to temporarily store store the node values. We can utilize a stack for this purpose. As we traverse the linked list, we push each node's value onto the stack, which stores the values in the reverse order. After traversing the entire list, we traverse it again and compare each node's value with the values popped from the top of the stack. If all values match, the linked list is a palindrome

Approach : 

Initialize : Begin by creating an empty stack. This stack will help us temporarily store the nodes values as we traverse the linked list

Travrse and Store : Traverse the linked list using a temporary pointer `temp`. As we move through each node, push its value onto the stack. This action stacks the values in reverse order - starting from the head to the tail of the linked list

Comparison : Reset the `temp` pointer back to the head of the linked list after storing all values. While the stack is not empty:

    a. Pop the top value from the stack
    b. Compare this value with the value at the current `temp` node
    c. If they match, move `temp` to the next node and continue the comparison
    d. If any value does not match during this traversal, conclude that the linked list is not a palindrome and return false

Palindrome Check: If all values match until the `temp` pointer reaches the end of the linked list, conclude that the linked list is a palindrome and return true

This approach uses a stack to reverse the order of values temporarily, allowing efficient comparison to check if the linked list maintains symmetry both forwards and backwards


------------------------------

Optimal approach : 

Previous approach uses O(N) additional space, which can be avoided by reversing only half of the linked list and comparing the first and the second halves, if they match, reverse the portion that was originally reversed, and then return true, otherwise return false

To implement this, we need to reverse the second half and compare it with first half 

The first step is to divide the linked list using tortoise and hare algorithm

