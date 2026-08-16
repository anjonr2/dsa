package com.problemsolving.LinkedList.medium.StartingPointOfALoop.optimal;

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
        /* Use temp to traverse the linked list */
        ListNode temp = head;

        /* HashMap to store all visited nodes */
        HashMap<ListNode, Integer> map = new HashMap<>();

        /* Traverse the list using temp */
        while (temp != null) {
            /* Check if the temp has been encountered again */
            if (map.containsKey(temp))
                return temp;

            /* Store temp as visited */
            map.put(temp, 1);

            /* Move to the next node */
            temp = temp.next;
        }

        // if no loop is detected, return null
        return null;
    }
}

/*
 * Time complexity : O(N) , the algorithm goes through the entire linked list
 * once, with 'N' representing the total number of nodes. As a result, the time
 * complexity is linear or O(N)
 * 
 * Space complexity : O(N), the algorithm utilizes a hash map to store the nodes
 * it encounters
 */
