package com.problemsolving.LinkedList.medium.DeleteMiddleNode.brute;

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

public class DeleteMiddleNode {
    /* Function to delete middle node of the linked list */
    public ListNode deleteMiddleNode(ListNode head) {
        /*
         * Edge case : if the list is empty or has only one node, return null
         */
        if (head == null || head.next == null)
            return head;

        /* Temporary node to traverse */
        ListNode temp = head;

        /* Variable to store number of nodes */
        int n = 0;

        /* Loop to count the number of nodes in the linked list */
        while (temp != null) {
            n += 1;
            temp = temp.next;
        }

        int middleIndex = n / 2;

        /* Reset temporary node to the begining of linked list */
        temp = head;

        /* Loop to find the node just before middle node */
        for (int i = 1; i < middleIndex; i += 1) {
            temp = temp.next;
        }

        if (temp.next != null) {
            ListNode middle = temp.next;

            /* adjust pointer to remove link to middle node */
            temp.next = temp.next.next;

            middle.next = null;

        }

        return head;
    }
}

/*
 * Time complexity : O(N + N/2)because the loop traverses the entire linked list
 * once to count the total number of nodes then the loop iterates halfway
 * through the linked list to reach the middle node. Hence the time complexity
 * is O(N + N/2 ) ~ O(N)
 */