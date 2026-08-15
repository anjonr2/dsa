Given the head of a singly linked list. Return true if a loop exists in the linked list or return false

A loop exists in a linked list if some node in the list can be reached again by continuously following the next pointer

A loop in a linked list happens when a node points back to one of the previous nodes, creating a cycle. This means that if you keep following the next pointers, you will eventually return to the same node. One common way to do this is by using hashing

Start by initializing a hash map to store nodes we visit. Set a temporary pointer to the head of the linked list

Traverse the list : Traverse through the linked list using the temporary pointer. For each node, check if it is already in the hash map. If the node is not in the hash map, add it to the map and move to the next node. If the node is already in the hash map, this means we have encountered a node we have seen before, indicating the presence of a loop

Loop Detection : During traversal , if we find a node that is already in the hash map, return true immediately because this confirms the existance of a loop

