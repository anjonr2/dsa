package com.problemsolving.LinkedList.medium.PalindromeLinkedList.brute;

import java.util.Stack;

/*Definition of single Linked List */
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
    public boolean isPalindrome(ListNode head) {
        /* Create an empty stack to store values */
        Stack<Integer> stack = new Stack<>();

        /* Intialize temporary pointer to the head of the linked list */
        ListNode temp = head;

        /* Traverse the linked list and push values onto the stack */
        while (temp != null) {
            /*
             * Push the data from the current node onto the stack
             */
            stack.push(temp.val);

            // Move to the next node
            temp = temp.next;
        }

        /*
         * Reset temporary pointer back to the head of the linked list
         */
        temp = head;

        /*
         * Compare values by popping from the stack and checking against linked list
         * nodes
         */
        while (temp != null) {
            if (temp.val != stack.pop()) {
                /* If values don't match, it's not a palindrome */
                return false;
            }

            /* Move to the next node in the linked list */
            temp = temp.next;
        }

        /*
         * If all values match, it's a palindrome
         */
        return true;
    }
}

/*
 * Time complexity : O(2*N) because we need to traverse the linked list twice:
 * Once to push the values onto stack and once more to pop values and compare
 * them with the nodes in the linked list. Here, N represents the number of
 * nodes in the linked list. Even though it's O(2*N)
 * 
 * Space complexity : O(N) , using stack to store data
 */