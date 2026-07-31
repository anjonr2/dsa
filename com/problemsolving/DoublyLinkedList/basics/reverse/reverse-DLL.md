A brute force approach involves replacing data in a doubly linked list. First, we traverse the list and store node data in a stack. 
Then in a second pass, we assign elements from the stack to nodes, 


In Optimal approach 
Instead of performing two separate traversals of the linked list and storing its node values in an external data structure, we can optimize our approach by directly modifying the links the nodes within the doubly linked list We need to traverse on every node, and for every node change the next pointer and back pointer