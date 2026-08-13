Iterative approach --- 

To reverse a linked list without using extra space, we change the direction of the links between the nodes. Think of it like flipping arrows between the nodes. This means each node will point to the one before it instead of the one after it.
By doing this, the last node in the original list becomes the first node in the reversed list.
This way, we efficiently reverse the list without needing any extra memory

Approach : 

1. Intialize pointers temp and prev. temp set to head and prev set to null. This temp pointer will help to traverse the list and prev will be used to reverse the direction of the links between the nodes
2. Traverse and Reverse: Move through the linked list with the temp pointer. For each node: 
    a. Save the next node in a variable called front. This ensures that you don't lose the track of the remaining list after changing the direction of the link
    b. Change the next pointer of the current node(temp) to point to the previous (prev) node. This action reverses the link
    c. Move the prev pointer to current node (temp). The prepares prev for the next iteration
    d. Move the temp pointer to the next node (front). This continues the traversal

    Continue the traversal until the temp pointer reaches null.
    At this point prev pointer will be at the new head of the reversed list  

Recursive approach ------------

When recursively reversing a linked list, we start by taking into account the complete list with N nodes. We can break this down recursively by starting with N - 1 nodes, moving on to N - 2 nodes and so on, until we reach a single node

In the base case, reversing a list with one node is straightforward because the list is alresdy in reverse. We simply return this node. When we return from each recursive call, we flip the pointers to reverse the linkages between nodes, thereby reversing the entire list

Approach 

Base case : 

First, check if the linked list is empty or has only one node. In these cases, the list si already reversed, so simply return the head.

Recursive function : 

The main part of the algorithm is a recursive function the handles the reversal of the linked list. This function works as follows : 

If the base case is not met, the function calls itself recursively. This process continues until the base case is reached, effectively reversing the list starting from the second node onwards

Returning the new head node : 
After the recursion completes, the function returns the new head of the reversed linked list. This new head was the last node of the original list before reversal, and it becomes the first node in the newly reversed list

Steps : 

Step 1 : Establish Base Case Conditions : First, check if the linked list is either empty or has only one node. If this condition is met, the list is already reversed, so return the head as it is

Step 2 : Recursively Reverse the List: Begin the recursive step by starting to reverse the linked list from the second node onward. Make a recursive call to the function, passing the next node as argument

Step 3 : Preseve Access to Remaining Nodes: To ensure access to the rest of the linked list while reversing, store a reference to the node following the current head node. This maintains the continuity of the link sequence during reversal process

Step 4 : Reverse Link Direction : Adjust the 'next' pointer of the node following the current head to point back to current head node. This effectively reverses the link between these two nodes

Step 5 : Prevent Cyclic References: To prevent creating a cycle, break the old link from current head to next node by setting the head's next pointer to null. This ensures that the reversed part of the list does not from a loop

Step 6 : Return the New Head : Finally, return the new head of the reversed linked list. This new head is the node that was last in the original list before the reversal started.
