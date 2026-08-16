The starting point of a loop in a linked list is the first node that we encounter more than once while traversing the list. When we reach this node for the second time, it indicates that we have entered a cycle, meaning we are no longer progressing forward but moving in a circular path within the list

Approach 
Initialization : Start by creating a temporary pointer poininting to the head of the linked list and an empty hash map to keep track of visited nodes

Note : storing the entire node in the map is essential to distinguish between nodes with identical values but different positions in the list. 

Traversal and Detection : Move through the linked list node by node using the temporary pointer. For each node, check if it is already in the hash map. If not, add it to the map and proceed to the next node. If a node is found in the hashmap , it indicates the start of the loop and should be returned


Optimal approach ---------
Above approach utilizes O(N) additional memory, which can be of concern when dealing with longer linked lists. To improve efficiency, we can use tortoise and hare algorithm, which is an optimized approach that reduces memory usage

Approach -----------

Initialization: Intialize two pointers, slow and fast, to the head of the linked list. The slow pointer will advance one step at a time, while the fast pointer will advance two steps at a time. These pointers will move simultaneously through the list

Traversal : As the traversal progresses, move the slow pointer one step and the fast pointer two steps at a time. This continues until one of two conditions is met: 
if fast or fast.next reaches the end of the linked list(i.e becomes null), it means there is no loop in the linked list

Alternatively if slow and fast pointer meet at the same node, it indicates the presence of a loop in the linked list

Finding the Loop's start : Once a loop is detected, reset the slow pointer to the head of the linked list. Then move both slow and fast pointers one step at a time. The point where they meet again is identified as the starting point of the loop. This method ensures efficient detection and pinpointing of the loop's starting location in the linked list

