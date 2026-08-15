package com.problemsolving.LinkedList.medium.DetectALoop.brute;

import java.util.HashSet;

/**
 * Defintion of LinkedList Node class
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }
}

public class DetectLoop {

    public boolean hasCycle(ListNode head) {
        /*
         * Initialize a pointer temp at the head of the linked list
         */
        ListNode temp = head;

        /* Create a set to keep track of encountered nodes */
        HashSet<ListNode> nodeSet = new HashSet<>();

        // Traverse the list
        while (temp != null) {
            /* If the node is already in the set , there is a loop */
            if (nodeSet.contains(temp)) {
                return true;
            }

            /* Store the current node in the set */
            nodeSet.add(temp);

            /* Move to the next node */
            temp = temp.next;
        }

        return false;
    }
}

/*
 * Time complexity : O(N), where N is the number of nodes in the LL. The
 * algorithm traverses the linked list once, and each insertion or lookup
 * operation in a HashSet takes O(1) on average due to hashing
 * 
 * Space Complexity : O(N), the hashset stores refrences to all visited nodes in
 * the worst case(when no loop exists),resulting in O(N) auxiliary space
 */