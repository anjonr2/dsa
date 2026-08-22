package com.problemsolving.LinkedList.medium.DeleteOccurencesInADLL;

/* Definition of a DLL */
class ListNode {
    ListNode prev;
    int val;
    ListNode next;

    ListNode() {
        this.prev = null;
        this.val = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.prev = null;
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

public class DeleteOccurencesInADLL {
    /* Function to delete all occurences of a target value */
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == target) {
                if (temp == head)
                    head = head.next;

                ListNode nextNode = temp.next;
                ListNode prevNode = temp.prev;

                /* Update next node's previous */
                while (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                /* Update prev node's next */
                while (prevNode != null) {
                    prevNode.next = nextNode;
                }
                /* Delete the current node */
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}

/*
 * Time complexity :O(N) because the linked list is traversed only once. Here, N
 * represents the number of nodes in the linked list
 */