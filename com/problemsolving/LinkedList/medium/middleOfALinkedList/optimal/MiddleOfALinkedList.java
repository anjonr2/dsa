package com.problemsolving.LinkedList.medium.middleOfALinkedList.optimal;

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

public class MiddleOfALinkedList {
    /* Function to get the middle of the linked list */
    public ListNode middleOfLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        /*
         * Until the fast pointer reaches NULL or the last node
         * if even length the fast pointer will reach null
         * if odd length linked list then fast pointer will reach last node
         */
        while (fast != null && fast.next != null) {
            /* move slow pointer by one step */
            slow = slow.next;

            /* move fast pointer by two step */
            fast = fast.next.next;
        }
        return slow;
    }
}

/*
 * Time complexity : O(N/2)
 */