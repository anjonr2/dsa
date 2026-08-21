To find where two linked lists intersect, we can use a hash set to remember all the nodes from the list. Then, as we go through the second list, we check if any node is in the hash set. The first node that is found in the set is where the lists interact

Approach : 

A hashmap is used which provides an efficient way to search in constant time

Better approach : 
To find the intersection of two linked lists, we use the difference in their lengths to align their starting points and then traverse both lists simultaneously until we find the intersection node

Approach : 

1. Calculate the lengths of both linked lists.
2. Determine the positive differnce between these lengths
3. Advance the pointer of the longer list by this difference, thereby aligning both lists to the same remaining length
4. Traverse both lists simultaneously from these aligned points. The first node where the pointer meet is the intersection node.

Optimal Approach --- 
Time simple intuition behind the optimal approach is to use two pointers to traverse the lists and traverse the same total distance by the time the pointers reach the intersection node. If one list ends, the pointer is placed at the front of the other list. The two pointers will meet at the intersection node if the lists have an intersection, otherwise,they will reach the end of the lists at the same time

Edge cases : 

Edge cases need to be taken care of  :
1. There is no intersection between two linked list
2. The two linked lists intersect at the head
3. Either of the two linked lists is empty

Approach : 
1. If either of the two linked list is empty, there is no intersection, so return null
2. Start the pointer at the head of the first linked list and another at the head of the second linked list
3. Move each pointer one step at a time
4. When a pointer reaches the end of its list, it is reassigned to the head of the other list. This ensures both pointer traverse the same total distance

