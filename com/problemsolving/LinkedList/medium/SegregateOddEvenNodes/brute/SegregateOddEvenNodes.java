package com.problemsolving.LinkedList.medium.SegregateOddEvenNodes.brute;

import java.util.ArrayList;
import java.util.List;

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
    /* Function to segregate odd and even indices nodes */
    public ListNode oddEvenList(ListNode head) {
        /* Check if list is empty or has only one node */
        if (head == null || head.next == null)
            return head;

        List<Integer> array = new ArrayList<>();
        ListNode temp = head;

        /*
         * Traverse the list , move forward by two nodes to store odd index nodes
         */
        while (temp != null && temp.next != null) {
            /* store odd indices nodes */
            array.add(temp.data);
            temp = temp.next.next;
        }

        /*
         * If the traversal ends on a valid odd indexed node, include its value as well
         */
        if (temp != null)
            array.add(temp.data);

        /* Reset the temp to the even node to store even indices node */
        temp = head.next;

        /*
         * Traverse the list again, by two nodes like fast pointer and store values in
         * the array
         */
        while (temp != null && temp.next != null) {
            /* store even indices nodes */
            array.add(temp.data);
            temp = temp.next.next;
        }

        /*
         * If the traversal ends on a valid even-indexed node, include its value as well
         */
        if (temp != null) {
            array.add(temp.data);
        }

        // Reset temp
        temp = head;
        int i = 0;

        while (temp != null) {
            temp.data = array.get(i);
            i += 1;
            temp = temp.next;
        }

        return head;
    }
}

/*
 * Time complexity : O(2N) for the following reasons
 * 
 * Traversing the odd-indexed elements takes O(N/2) time
 * 
 * Traversing the even-indexed elements takes O(N/2) time
 * 
 * Updating the list with the values from the array takes O(N) time. Here N is
 * the size of the linked list
 * 
 * Space complexity : O(N) because an additional list is used
 */