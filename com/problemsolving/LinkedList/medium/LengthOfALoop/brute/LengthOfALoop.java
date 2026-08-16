package com.problemsolving.LinkedList.medium.LengthOfALoop.optimal;

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

public class LengthOfALoop {
    // function to find length of the loop
    public int findLengthOfTheLoop(ListNode head) {
        // HashMap to store visited nodes and counter values
        HashMap<ListNode, Integer> visitedNodes = new HashMap<>();

        ListNode temp = head;

        int counter = 0;

        while (temp != null) {
            if (visitedNodes.containsKey(temp)) {
                // calculate the length of the loop
                int loopLength = counter - visitedNodes.get(temp);

                // Return the length of the loop
                return loopLength;
            }
            /*
             * Store the current node and its time value in the HashMap
             */
            visitedNodes.put(temp, counter);

            // Move to the next node
            temp = temp.next;

            // Increment the counter
            counter += 1;
        }

        /*
         * If traversal is completed and we reach end of the list(null)
         * means there is no loop
         */
        return 0;
    }
}
