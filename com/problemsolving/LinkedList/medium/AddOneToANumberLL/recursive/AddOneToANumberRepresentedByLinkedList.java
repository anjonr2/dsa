package com.problemsolving.LinkedList.medium.AddOneToANumberLL.recursive;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddOneToANumberRepresentedByLinkedList {
    /* Helper function to add 1 to the linked list */
    private int addHelper(ListNode node) {
        /* If the list is empty return a carry of 1 */
        if (node == null)
            return 1;

        /* Recursively call the add helper for the next node */
        int carry = addHelper(node.next);

        /* add carry to current node's value */
        node.val += carry;

        /* If the current node's value is less than 10 no further carry is needed */
        if (node.val < 10)
            return 0;

        /* If the current node's value is 10 set it 0 and return 1 */
        node.val = 0;
        return 1;
    }

    public ListNode addOne(ListNode head) {
        /* Call the helper function to start the addition process */
        int carry = addHelper(head);

        /*
         * If there's a carry left after processing all nodes add a new node at the head
         */
        if (carry == 1) {
            ListNode newNode = new ListNode(carry);
            /* Link the new node to the current head */
            newNode.next = head;
            /* Update the head to the new node */
            head = newNode;
        }

        return head;
    }
}

/*
 * Time complexity : O(N), where N is the number of nodes in the linked list.
 * This is because each node in the linked list is visited exactly once by the
 * recursive addHelper function. The process involves traversing the entire list
 * to reach the end, and then propagating carry back through each node,
 * resulting in a linear time complexity O(N)
 * 
 * Space complexity : O(N) due to recursive stack.
 */