package com.problemsolving.LinkedList.medium.SortLLOf0sAnd1s.brute;

class ListNode {
    public int data;
    public ListNode next;

    ListNode() {
        this.data = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.data = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.data = val;
        this.next = next;
    }
}

public class SortALLOf0sAnd1s {
    /* Function to sort the Linked List */
    public ListNode sortList(ListNode head) {
        /* Initialize counts */
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        ListNode temp = head;

        while (temp != null) {
            if (temp.data == 0)
                c0 += 1;
            else if (temp.data == 1)
                c1 += 1;
            else if (temp.data == 2)
                c2 += 1;

            temp = temp.next;
        }

        temp = head;

        /*
         * Reassign values to the nodes based on the counts
         */
        while (temp != null) {
            if (c0 > 0) {
                temp.data = 0;
                c0 -= 1;
            } else if (c1 > 0) {
                temp.data = 1;
                c1 -= 1;
            } else if (c2 > 0) {
                temp.data = 2;
                c2 -= 1;
            }

            temp = temp.next;
        }

        return head;
    }
}
