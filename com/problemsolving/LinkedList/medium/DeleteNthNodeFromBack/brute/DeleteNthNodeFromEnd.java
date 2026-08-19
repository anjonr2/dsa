package com.problemsolving.LinkedList.medium.DeleteNthNodeFromBack.brute;

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

public class DeleteNthNodeFromEnd {
    /* Function to remove nth node from end */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        int cnt = 0;
        ListNode temp = head;

        /* Count the number of nodes in the list */
        while (temp != null) {
            cnt += 1;
            temp = temp.next;
        }

        /*
         * If n equals the total number of nodes
         * delete the head
         */
        if (cnt == n) {
            ListNode newHead = head.next;
            return newHead;
        }

        /* calculate the position of the node to be deleted (res) */
        int res = cnt - n;
        temp = head;

        /*
         * to delete nth node from the end we need to reach node before nth node from
         * end which is res or cnt-n
         */
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        /* Delete the nth node from the end */
        ListNode del = temp.next;
        del.next = del.next.next;
        return head;

    }
}

/*
 * Time complexity :O(L) + O(L-N)
 * we are calculating the length of the linked list and then iterating up to
 * (L-N)th node of the linked list, where L is the total length of the list and
 * N is the position of the node to delete
 */