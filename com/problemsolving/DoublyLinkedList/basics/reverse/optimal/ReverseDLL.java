package com.problemsolving.DoublyLinkedList.basics.reverse.optimal;

import com.problemsolving.DoublyLinkedList.util.Node;

public class ReverseDLL {
    public Node reverseDLL(Node head) {
        /* pointer to traverse the list */
        Node curr = head;

        Node last = null;

        while (curr != null) {
            last = curr.prev;

            curr.prev = curr.next;
            curr.next = last;

            curr = curr.prev;
        }

        return last.prev;
    }
}
