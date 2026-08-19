package com.problemsolving.LinkedList.medium.DeleteMiddleNode.optimal;

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
    /*
     * Function to delete middle of a linked list
     */
    public ListNode deleteMiddle(ListNode head) {
        /*
         * If the list is empty or has only one node return null as there is no middle
         * node to delete
         */
        if (head == null || head.next == null)
            return head;

        /*
         * Initialize fast and slow pointer
         * move fast two nodes ahead initially
         * This ensures slow pointer reach just before middle , the 'fast' pointer gets
         * a head start
         */
        ListNode slow = head;
        ListNode fast = head.next.next;

        /* Move fast pointer twice as fast as slow */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /* Delete the middle node by skipping it */
        slow.next = slow.next.next;

        return head;
    }
}

/*
 * Time complexity : O(N/2) because the code traverses the linked list using the
 * tortoise and hare approach
 */