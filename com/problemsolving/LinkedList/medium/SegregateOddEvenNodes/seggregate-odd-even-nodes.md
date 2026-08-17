Given the head of a linked list, Group all the nodes with odd indices followed by all the nodes with even indices and return the reorderd list

Optimal Approach ------------

1. Start by setting two pointers: one for the odd-indexed elements and one for the even-indexed elements. The odd pointer will start at the first node, and the even pointer will start at the second node. 
2. Keep track of the first even-indexed node to link last node of the odd indexed node to even indexed node
3. Depending on whether the list length is odd or even, ensure the traversal continues appropriately. For an even-length list, make sure the loop runs until the node after the even pointer is not NULL. For an odd length list, we need to make sure the loop runs until the even pointer itself is not NULL

4. Once all odd index nodes are grouped, link the last odd-indexed node to the first even-indexed node to form the desired linked list without using extra space