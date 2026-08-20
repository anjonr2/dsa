package com.problemsolving.LinkedList.medium.SortLLOf0sAnd1s.optimal;

class ListNode {
    public int data;
    public ListNode next;

    ListNode() {
        this.data = 0;
        this.next = null;
    }

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

public class SortALLOf0sAnd1s {
    /* Function to sort the Linked List */
    public ListNode sortList(ListNode head) {
        /* If the list is empty or has only one node, return as it is already sorted */
        if (head == null || head.next == null)
            return head;

        /* Dummy nodes to point to heads of three lists */
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        /* Pointer to current last nodes of three lists */
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;
        ListNode temp = head;

        /*
         * Traverse the original list and distribute the nodes into three lists
         */
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            } else if (temp.data == 2) {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }

        /* connect the three list together */
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        /* new head of the sorted list */
        ListNode newHead = zeroHead.next;

        return newHead;
    }
}

/*
 * Time complexity : O(N) because the code traverses the linked list once. Here,
 * N represents the length of the linked list or the number of nodes present in
 * the linked list
 */
