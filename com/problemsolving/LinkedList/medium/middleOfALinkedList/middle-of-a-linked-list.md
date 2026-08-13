A naive approach to solve this problem is to count the number of nodes in the linked list and then traverse the list again to find the middle element. If the linked list contains N number of nodes, then the middle node will be at the position: floor(N/2) + 1

Note that in case of even number of nodes in the linked list, there will be two middle nodes and we need to return the second middle node

Approach : 
1. Linked list is traversed once to determine it's total length
2. The Middle position is calculated as N/2 + 1
3. The linked list traversed again up to the middle position
4. The node at this position is returned as the middle node


An optimal approach to solve this problem involves the use of two pointer technique using the slow and fast pointers. The slow pointer moves one step at a time while the fast pointer moves two steps at a time. If the fast pointer reaches the end of the list, the slow pointer will be at the middle of the list

This is because fast pointer moves twice as fast as the slow pointer, so when the fast pointer reaches the end of the list , the slow pointer will be at the middle of the list

Approach
1. One pointer moves one step at a time, while the other pointer moves two step at a time
2. The fast pointer moves twice as fast as the slow pointer
3. When the faster pointer reaches the end, the slower pointer is at the middle node
4. The node where the slower pointer stops is returned as the middle node