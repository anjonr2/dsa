package com.problemsolving.LinkedList.medium.PalindromeLinkedList.optimal;

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

public class PalindromeLinkedList {
    /* Function to reverse a Linked List using the iterative approach */
    private ListNode reverseLinkedList(ListNode head) {
        /* Initialize previous pointer as null */
        ListNode prev = null;

        /* Initialize current pointer as head */
        ListNode curr = head;

        /* Traverse the list until all the nodes are processed */
        while (curr != null) {

            // Store the reference to the next node so that link to remaining list is
            // not lost
            ListNode front = curr.next;

            /* reverse the link direction */
            curr.next = prev;

            /* Move previous one step forward */
            prev = curr;

            /* Move current to front node for next iteration */
            curr = front;
        }

        /* prev now points to the new head after reversal */
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        /*
         * Check if the linked list is empty or has only one node
         */
        if (head == null || head.next == null)
            /* it's a palindrome by definition */
            return true;

        /*
         * Initialize two pointers slow and fast to find the middle of the linked list
         */
        ListNode slow = head;
        ListNode fast = head;

        /*
         * for even length linked list slow pointer needs to reach first middle node.
         * so we have to stop when fast.next.next == null instead of fast == null
         */
        while (fast.next != null && fast.next.next != null) {
            /* Move slow node by one step */
            slow = slow.next;

            /* Move fast node by two step */
            fast = fast.next.next;
        }

        /*
         * Reverse the second half of the linked list starting from the node after the
         * middle
         */
        ListNode newHead = reverseLinkedList(slow.next);

        ListNode first = head;
        ListNode second = newHead;

        /* Compare nodes from both halves one by oneto check for palindrome */
        while (second != null) {

            /* if mismatch found, it's not a palindrome */
            if (first.val != second.val) {

                /* Restore the original list before returning */
                reverseLinkedList(newHead);
                return false;
            }

            /* Move both pointers one step ahead */
            first = first.next;
            second = second.next;
        }

        /* Restore the second half of the linked list to its original order */
        reverseLinkedList(newHead);

        // All values matched, the list is a palindrome
        return true;
    }
}

/*
 * Time complexity : O(2N) , this approach involves traversing the linked list
 * twice.
 * First traversal finds the middle and reverses second half
 * while second traversal compares element from both halves
 * Since each traversal covers N/2 elements, the total time complexity is O(N/2
 * + N/2 + N/2 + N/2) which simplifies to O(2N) ~ O(N)
 */