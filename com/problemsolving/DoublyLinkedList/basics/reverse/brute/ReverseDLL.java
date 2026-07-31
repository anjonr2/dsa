package com.problemsolving.DoublyLinkedList.basics.reverse.brute;

import java.util.Stack;

import com.problemsolving.DoublyLinkedList.util.Node;

public class ReverseDLL {
    /* Function to reverse the DLL using stack */
    public Node reverseDLL(Node head) {
        /* If the list is empty or it has one element, return it */
        if (head == null || head.next == null) {
            return head;
        }

        /* Stack to store the node values */
        Stack<Integer> stack = new Stack<>();

        /* pointer to traverse the list */
        Node temp = head;

        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        // reset temp to head
        temp = head;

        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }

        // Return updated head
        return head;
    }
}
