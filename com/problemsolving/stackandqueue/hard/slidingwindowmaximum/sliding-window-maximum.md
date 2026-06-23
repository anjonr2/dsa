In brute force approach, we scanned every element of the window repeatedly was resulting in increased time complexity

Everytime the sliding window moves by one step, an element is added to the window and an previously added element is removed from the window. A data structure that can push elements from one end and remove elements from the other end is queue. Every time the window moves by one step, the queue is updated to manage the current window elements

Maximum element in a particular window can be found directly using the concept of monotonic queue, which includes storing the elements in a decreasing order. This way maximum element will always be the front element in the queue which can be retrieved from the queue in constant time

In order to maintain the decreasing order of elements in queue,before adding new element to eh queue, all the smaller elements already present in front of the queue can be popped out

But a queue data structure does not provide pop operation from the front. To overcome this, a Deque can be used, which enables efficient insertion and retrieval from both ends

Ensure deque maintains a monotonic decreasing order by removing indices of elements from the back that are less than or equal to the current element.Add the current element's index to eh back of the deque