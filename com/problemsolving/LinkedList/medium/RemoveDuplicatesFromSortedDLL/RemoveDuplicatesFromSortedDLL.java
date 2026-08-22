package com.problemsolving.LinkedList.medium.RemoveDuplicatesFromSortedDLL;

class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.prev = null;
        this.next = null;
    }

    ListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

public class RemoveDuplicatesFromSortedDLL {
    /* Remove duplicates from a sorted doubly linked list */
    public ListNode removeDuplicates(ListNode head) {
        ListNode temp = head;

        /* Traverse the list */
        while (temp != null && temp.next != null) {
            ListNode nextNode = temp.next;

            /* Remove all duplicate nodes */
            while (nextNode != null && nextNode.val == temp.val) {
                ListNode duplicate = nextNode;
                nextNode = nextNode.next;
                /* Delete the duplicate node */
                duplicate = null;
            }

            /* Link the current node to the next non duplicate node */
            temp.next = nextNode;

            /*
             * Update previous pointer of next non-duplicate node
             */
            if (nextNode != null) {
                nextNode.prev = null;
            }

            /* move to the next node */
            temp = temp.next;
        }

        return head;
    }
}

/*
 * Time complexity : O(N) and not O(N^2) because each node in the doubly linked
 * list is visited exactly once. The outer loop traverses each distinct node,
 * and the inner loop skips over consecutive duplicates in a single pass,
 * ensuring a total linear traversal of the list
 */