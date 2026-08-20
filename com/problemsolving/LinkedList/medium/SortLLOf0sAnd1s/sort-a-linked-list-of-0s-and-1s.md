Optimal approach : 
Traverse the linked list to segregate nodes into three separate lists based on their values (0s, 1s and 2s), then link these lists together to form a single sorted linked list

Approach : 

Create three dummy nodes to serve as the heads of three separate lists of 0s, 1s and 2s. Also create pointers to track the current end of each of these lists

Traverse the original linked list. For each node, append it to the appropriate list(0s, 1s or 2s) based on its value and update the corresponding pointer

Connect the three lists together. Link the end of 0s list to the start of the 1s list (or directly to the 2s list if the 1s list is empty). Then, link the end of the 1s list to the start of the 2s list

The new head of the sorted linked list will be the node following the dummy node for 0s