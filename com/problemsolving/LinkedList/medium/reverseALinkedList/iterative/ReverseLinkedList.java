package com.problemsolving.LinkedList.medium.reverseALinkedList.iterative;

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

public class ReverseLinkedList {
    /*
     * Function to reverse a linked list using the 3-pointer approach
     */
    public ListNode reverseList(ListNode head) {
        /*
         * Initializes 'temp' at head of the LinkedList
         */
        ListNode temp = head;

        /*
         * Initialize pointer prev to Null, representing the previous node
         */
        ListNode prev = null;

        /*
         * Traverse the list, continue till 'temp' reaches the end(NULL)
         */
        while (temp != null) {
            /*
             * Store the next node in front so that when temp changes it's link rest of list
             * is not lost and temp can move to next in next iteration
             */
            ListNode front = temp.next;

            /*
             * Reverse the direction of the current node's 'next' pointer to prev
             */
            temp.next = prev;

            /* Move prev to current for next iteration */
            prev = temp;

            /* Move temp to front node advancing the traversal */
            temp = front;
        }

        /* Return the new head of the reversed list */
        return prev;
    }
}

/*
 * Time complexity : O(N) , because the algorithm traverses the entire list
 * once. Where 'N' is the number of nodes in the linked list
 */
