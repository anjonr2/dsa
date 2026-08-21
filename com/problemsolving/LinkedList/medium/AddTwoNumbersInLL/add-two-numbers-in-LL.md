Imagine you have two numbers written on paper, with the digits arranged backward : 
Number 1: 3 -> 2 -> 1 (Represents 123)
Number 2: 4 -> 5 -> 6 (Represents 654)

To add them, we need to start from rightmost digits (ones place), add them up ( 1 + 6 = 7), then move left to the next pair(tens place 2 + 5 = 7) and so on. If the sum of two digits is greater than or equal to 10, you'd carry over 1 to the next digit position

Approach : 

Simultaneous traversal: Traverse both linked lists at the same time, node by node
Digit wise addition : At each step, add the values stored in the current lists. Also, add any carry-over from the previous addition
Create new node : Calculate the result digit by taking modulo 10 of the sum. Create a new node to store this digit

Carry over : If the sum is 10 or greater, carry over 1 to the next addition
Update pointers : Move the pointers of both lists to their next nodes, and the pointer of the result list to the newly created node

