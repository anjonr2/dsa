package com.problemsolving.LinkedList.medium.SortALinkedList.brute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    /* Function to sort Linked List */
    public ListNode sortList(ListNode head) {
        /* ArrayList to store node values */
        List<Integer> array = new ArrayList<>();

        /* Temporary pointer to traverse the list */
        ListNode temp = head;

        /* Traverse linked list and store node values in the ArrayList */
        while (temp != null) {
            array.add(temp.val);
            temp = temp.next;
        }

        /* Sort ArrayList containing node values */
        Collections.sort(array);

        /* Reassign sorted values to linked list nodes */
        temp = head;

        for (int element : array) {
            /* update the node's data */
            temp.val = element;

            /* Move to the next node */
            temp = temp.next;
        }

        /* Return the head */
        return head;
    }
}

/*
 * Time complexity : O(N) + O(Nlog N) + O(N)
 * O(N) : Time taken to traverse the linked list and store its data values in an
 * array
 * 
 * O(NlogN) : Time taken to sort the array of node values
 * 
 * O(N) : Time taken to traverse the sorted array and reassign values back to
 * linked list
 * 
 * Space complexity : O(N) for using an extra array to store node values
 */