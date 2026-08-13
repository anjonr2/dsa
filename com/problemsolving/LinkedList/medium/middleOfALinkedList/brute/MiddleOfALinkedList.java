package com.problemsolving.LinkedList.medium.middleOfALinkedList.brute;

/*Definition for a singly linked list */
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int data) {
        this.val = data;
        this.next = null;
    }

    ListNode(int data, ListNode next) {
        this.val = data;
        this.next = next;
    }
}

public class MiddleOfALinkedList {
    /* Function to get the middle of the linked list */
    public ListNode middleOfLinkedList(ListNode head) {
        ListNode temp = head;
        int length = 0;

        /* Traverse the linked list */
        while (temp != null) {
            length += 1; // Increment the count by one
            temp = temp.next;
        }

        int midPosition = (length) / 2 + 1;

        ListNode middleNode = head;

        for (int i = 1; i < midPosition; i += 1) {
            middleNode = middleNode.next;
        }

        return middleNode;
    }
}

/*
 * Time complexity : O(N), where N is the number of nodes in the linked list
 * Firstly the size of the linked list is determined which takes O(N) time
 * Then traversing to the middle nodes takes another O(N/2) time. Thus the
 * overall time
 * complexity is O(N) + O(N/2) or O(3N/2) or O(N)
 */