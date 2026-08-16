package com.problemsolving.LinkedList.medium.LengthOfALoop.optimal;

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

public class LengthOfALoop {
    // Function to find the length of loop
    public int findLength(ListNode slow, ListNode fast) {
        // Count to keep track of nodes encountered in loop
        int cnt = 1;

        // Move fast by one step
        fast = fast.next;

        // Traverse fast till it reaches back to slow
        while (slow != fast) {
            /*
             * At each node increase count by 1
             * move fast point by one step
             */
            cnt += 1;
            fast = fast.next;
        }

        /*
         * Loop terminates when fast reaches slow again and the count is returned
         */
        return cnt;
    }

    /*
     * Function to find length of the loop
     */
    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list to detect a loop
        while (fast != null && fast.next != null) {
            // Move slow one step
            slow = slow.next;

            // Move fast two steps
            fast = fast.next.next;

            // If the slow and fast pointers
            // meet there is a loop
            if (slow == fast) {
                // return the number of nodes
                return findLength(slow, fast);
            }
        }

        return 0;
    }
}

/*
 * Time complexity : O(N) because the code traverses entire linked list once
 * 
 * Space complexity : O(1)
 */