package com.problemsolving.LinkedList.medium.DeleteNthNodeFromBack.optimal;

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

public class DeleteNthNodeFromEnd {
    /* Function to remove nth node from end */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        /* Move fast pointer n nodes ahead */
        for (int i = 0; i < n; i += 1) {
            fast = fast.next;
        }

        /* if fast pointer becomes null nth node from end is head */
        if (fast == null) {
            return head.next;
        }

        /* Move both pointers until fast pointer reaches last node of the list */
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}

/*
 * Time complexity : O(N)
 */