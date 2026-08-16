package com.problemsolving.LinkedList.medium.StartingPointOfALoop.brute;

import java.util.HashMap;

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

public class StartingPointOfALoop {

    public ListNode findStartingPoint(ListNode head) {
        /* Intialize a slow and fast pointers to the head of the list */
        ListNode slow = head;
        ListNode fast = head;

        // Phase 1 : Detect the loop
        while (fast != null && fast.next != null) {

            // Move slow by one step
            slow = slow.next;

            // Move fast by two steps
            fast = fast.next.next;

            // if slow and fast meet
            // a loop is detected
            if (slow == fast) {

                // Reset the slow pointer
                // to the head of the list
                slow = head;

                // Phase 2 : Find the first node of the loop
                while (slow != fast) {

                    // Move
                    slow = slow.next;
                    fast = fast.next;

                    // when slow and fast meet again
                    // it's the first node of the loop
                }

                // Return the first node of the loop
                return slow;
            }

        }

        // if no loop is detected, return null
        return null;
    }
}

/*
 * Time complexity : O(N)
 * 
 * Space complexity : O(1)
 */