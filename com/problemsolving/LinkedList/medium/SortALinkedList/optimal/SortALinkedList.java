package com.problemsolving.LinkedList.medium.SortALinkedList.optimal;

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

public class SortALinkedList {
    /* Function to merge two sorted list */
    public ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
        /* Create dummy node to serve as head of merged list */
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        /* Traverse both lists simultaneously */
        while (list1 != null && list2 != null) {
            /*
             * Compare elements of both lists and link the smaller node to the merged list
             */
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            /* Move the temporary pointer to the next node */
            temp = temp.next;
        }

        /*
         * If any list still has remaining elements append them to the merged list
         */
        if (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
        }
        if (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
        }
        /* Return the merged list starting from the next of the dummy node */
        return dummyNode.next;
    }

    /* Function to find the middle of a linked list */
    private ListNode findMiddle(ListNode head) {
        /* If the list is empty or has only one node, the middle is the head itself */
        if (head == null || head.next == null)
            return head;

        /* Initializing slow and fast pointer */
        ListNode slow = head;
        ListNode fast = head.next;

        /*
         * Move the fast pointer twice as fast as slow pointer
         * When the fast pointer reaches end, the slow pointer will be at middle
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

    }

    /* Function to sort a Linked List */
    public ListNode sortList(ListNode head) {
        /*
         * Base case : if the list is empty or has only one node, it is already sorted,
         * so return the head
         */
        if (head == null || head.next == null) {
            return head;
        }

        /* Find middle of the list using findMiddle function */
        ListNode middle = findMiddle(head);

        /* Divide the list into two halves */
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        /* Recursively sort left and right halves */
        left = sortList(left);
        right = sortList(right);

        /* Merge the sorted halves using the mergeTwoSortedLinkedLists function */
        return mergeTwoSortedLinkedLists(left, right);
    }
}

/*
 * Time complexity : O(NlogN) where N is the number of nodes in the linked list.
 * Finding the middle node of the linked list requires traversing it linearly
 * taking O(N) time complexity and to reach the individual nodes of the list, it
 * has to be split logN times (continuously halve the list until we have
 * individual elements)
 * 
 * Space complexity : O(1) as no additional data structures or space is
 * allocated for storage during the merging process. However space proportional
 * to O(logN) stack space is required for recurisve calls. The maximum recursion
 * depth of log N height is occupied on the call stack
 */