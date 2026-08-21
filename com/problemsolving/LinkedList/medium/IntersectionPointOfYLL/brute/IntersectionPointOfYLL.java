package com.problemsolving.LinkedList.medium.IntersectionPointOfYLL.brute;

import java.util.HashSet;

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

public class IntersectionPointOfYLL {
    /* Function to find the intersection node of two Linked List */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /* Create a hashset to store the nodes of the first list */
        HashSet<ListNode> set = new HashSet<>();

        /* Traverse the first linked list and add all its nodes to the set */
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        /* Traverse the second list and check for intersection */
        while (headB != null) {
            /*
             * If a node from the second list is found in the set, it means there is an
             * intersection
             */
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }

        /* No intersection is found, return null */
        return null;
    }
}

/*
 * Time complexity : O(N + M), where N and M are the lengths of the first and
 * second linked list respectively
 * 
 * Traversing the first list and adding nodes to the hashset takes O(N) time.
 * Assuming hashset takes O(1) time for operations. Iterating through all nodes
 * in the second list takes O(M) time. Therefore, the total time complexity is
 * O(N+M)
 * 
 * Space complexity : O(N) , using an hashset to store the addresses of all
 * nodes in the list takes O(N) space
 */
