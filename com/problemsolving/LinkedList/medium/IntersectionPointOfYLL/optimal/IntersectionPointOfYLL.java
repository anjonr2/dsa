package com.problemsolving.LinkedList.medium.IntersectionPointOfYLL.optimal;

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

public class IntersectionPointOfYLL {
    /* Function to find intersection node of two linked list */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /* Edge case */
        if (headA == null || headB == null)
            return null;

        ListNode d1 = headA;
        ListNode d2 = headB;

        /* Traverse both lists until the pointers meet */
        while (d1 != d2) {
            /* Move both pointers by one place */
            d1 = d1.next;
            d2 = d2.next;

            /* If intersection is found */
            if (d1 == d2)
                return d1;

            /*
             * If either of the two pointers reaches end, place it back at the front or head
             * of other list
             */
            if (d1 == null)
                d1 = headB;
            if (d2 == null)
                d2 = headA;
        }

        return d1;
    }
}

/*
 * Time complexity : O(N + M), where N and M are the lengths of first and second
 * linked list respectively
 */