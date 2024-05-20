package com.dsa.linkedList;

import java.util.HashMap;

public class LinkedListLoop {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node findStartingOfTheLoop(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            map.put(temp, 1);

            // move temp to next node for next iteration
            temp = temp.next;
        }
        // temp will be null if it's a linear linkedlist
        // so no loop or starting point of the loop
        // hence return null
        return null;
    }
}
