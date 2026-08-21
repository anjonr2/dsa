package com.problemsolving.LinkedList.medium.IntersectionPointOfYLL.better;

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int n1 = 0, n2 = 0;

        /* Get the length of first linked list */
        while (temp1 != null) {
            n1 += 1;
            temp1 = temp1.next;
        }

        /* Get the length of second linked list */
        while (temp2 != null) {
            n2 += 1;
            temp2 = temp2.next;
        }

        /* Traverse the longer list and bring the pointers to the same level */
        if (n1 < n2)
            return collisionPoint(headA, headB, n2 - n1);

        return collisionPoint(headB, headA, n1 - n2);
    }

    private ListNode collisionPoint(ListNode smallerListHead, ListNode longerListHead, int len) {
        ListNode temp1 = smallerListHead;
        ListNode temp2 = longerListHead;

        /* Adjust the pointers to the same level by moving longerListHead */
        for (int i = 0; i < len; i += 1)
            temp2 = temp2.next;

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }
}

/*
 * Time complexity : O (N + M), where N and M are the lengths of first and
 * second linked list respectively
 * 
 * Calculating the lengths of the two linked list takes O(N) and O(M) time.
 * Another O(|N-M|) time is needed for aligning the nodes. The final traversal
 * of the aligned lists takes O(min(N,M)) time in the worst case. Thus, the
 * overall time complexity O(N + 2M) or O(N + M)
 * 
 */