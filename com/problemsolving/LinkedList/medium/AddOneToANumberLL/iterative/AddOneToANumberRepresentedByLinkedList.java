package com.problemsolving.LinkedList.medium.AddOneToANumberLL.iterative;

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

public class AddOneToANumberRepresentedByLinkedList {
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            // Store the next node
            next = curr.next;

            /* Reverse the link */
            curr.next = prev;

            /* Move previous to current */
            prev = curr;

            /* Move current to next to reverse link of the next node */
            curr = next;
        }

        return prev;
    }

    /* Function to add one to Linked List */
    public ListNode addOne(ListNode head) {
        head = reverseList(head);

        /* Create a dummy node */
        ListNode current = head;

        /* initialize carry with 1 */
        int carry = 1;

        while (current != null) {
            /* Sum the current node's value and carry */
            int sum = current.val + carry;

            /* Update carry */
            carry = sum / 10;

            /* Update the node's value */
            current.val = sum % 10;

            /* If no carry left break the loop */
            if (carry == 0)
                break;

            /*
             * If we have reached end of the list and there's still a carry, add a new node
             * with the carry value
             */
            if (current.next == null && carry != 0) {
                current.next = new ListNode(carry);
                break;
            }

            /* Move to the next node */
            current = current.next;
        }

        head = reverseList(head);

        return head;
    }
}

/*
 * Time complexity : O(N) , because we traverse the linked list three times,
 * each with a time complexity of O(N), resulting in O(3N) which simplifies to
 * O(N), here N is the number of nodes in the linked list
 */