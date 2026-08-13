package com.problemsolving.LinkedList.medium.reverseALinkedList.recursive;

/**
 * Inner list node class
 */
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
    /* Function to reverse a singly linked list using recursion */
    public ListNode reverseList(ListNode head) {
        /*
         * Base case :
         * If the linked list is empty or has only one node, return the head as it is
         * already reversed
         */
        if (head == null || head.next == null) {
            return head;
        }

        /*
         * Recursive step :
         * Reverse the linked list starting from the second node (head.next)
         */
        ListNode newHead = reverseList(head.next);

        /*
         * Save a reference to the node following the current head node
         */
        ListNode front = head.next;

        /*
         * Make the front node point to the current head node, not newHead node
         * This action reverses the link
         */
        front.next = head;

        /* break the link from current head to it's front node to avoid cycle */
        head.next = null;

        /* Return the new head which is the new head of the linked list */
        return newHead;
    }
}

/*
 * Time complexity :O(N), where N is the number of nodes in the linked list. The
 * algorithm traverses the list exactly once through the recursive calls
 * 
 * Space complexity : O(N) (Auxiliary Space). The recursive call stack will
 * reach maximum depth of N before it hits the base case, taking up O(N) space.
 */
