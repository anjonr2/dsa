package com.dsa.linkedList.medium;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CloneALinkedList {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Map<Node, Node> map = new HashMap<>();
        while (temp != null) {
            Node node = new Node(temp.val);
            map.put(temp, node);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}
