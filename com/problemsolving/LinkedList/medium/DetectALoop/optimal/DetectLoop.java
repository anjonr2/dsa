package com.problemsolving.LinkedList.medium.DetectALoop.optimal;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
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

public class DetectLoop {
    /*
     * Function to detect a loop in a linked list using slow and fast pointer
     * algorithm
     */
    public boolean hasCycle(ListNode head) {
        /* Initialize two pointers slow and fast to the head of the linked list */
        ListNode slow = head;
        ListNode fast = head;

        /* Traverse linked list with slow and fast pointer */
        while (fast != null && fast.next != null) {
            /* Move slow by one step */
            slow = slow.next;
            /* Move fast by two steps */
            fast = fast.next.next;

            /* Check if slow and fast pointers meet */
            if (slow == fast) {
                return true; // Loop detected
            }
        }

        // if the fast pointer reaches the end of the list there is no loop
        return false;
    }
}

/*
 * Time complexity : O(N), where N represents the number of nodes in the linked
 * list. In the worst-case scenario, the fast pointer, which advances more
 * quickly will either reach the end of the list (if there's no loop) or catch
 * up to the slow pointer (if there's a loop) in a time proportional to the
 * length of the list
 * 
 * The reason this complexity is O(N) and not slower is due to the fact that
 * each step of the algorithm decreases the gap between the fast and slow
 * pointers ( when they are within the loop) by one node. Thus, the maximum
 * number of steps requried for them to meet is directly related to the number
 * of nodes in the list
 */