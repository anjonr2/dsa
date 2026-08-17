package com.problemsolving.LinkedList.medium.SegregateOddEvenNodes.optimal;

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

public class SegregateOddEvenNodes {
    // Function to rearrange nodes
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        /*
         * Intialize pointer for odd and even nodes and keep track of the first even
         * node
         */
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = head.next;

        /*
         * for even length linked list even node will reach null
         * and for odd length linked list even node will reach last node
         */
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        /* Connect the last odd node to first even node */
        odd.next = firstEven;
        return head;
    }
}

/*
 * Time complexity : O(N/2) * 2 ~ O(N) because we are iterating over the
 * odd-indexed as well as the even-indexed elements . Here N is the size of the
 * given linked list
 * 
 * Space complexity : O(1)
 */