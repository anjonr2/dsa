package com.problemsolving.stackandqueue.hard.LRUCache;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key, value;
    Node prev, next;

    Node() {
        key = value = -1;
        next = prev = null;
    }

    Node(int k, int val) {
        key = k;
        value = val;
        next = prev = null;
    }
}

public class LRUCache {
    private Map<Integer, Node> keyNodeMap;
    private int capacity; // Capacity of the cache
    private Node tail;
    private Node head;

    /*
     * Method to delete node from doubly linked list
     */
    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        // Remove pointers to node
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Private method to insert node after head
    private void insertAfterHead(Node node) {
        Node nextNode = head.next;
        node.next = nextNode;
        nextNode.prev = node;
        node.prev = head;
        head.next = node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyNodeMap = new HashMap<>();

        Node head = new Node();
        Node tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // Return -1 if key is not present in the cache
        if (!keyNodeMap.containsKey(key))
            return -1;

        Node node = keyNodeMap.get(key);
        int val = node.value;

        // delete node
        deleteNode(node);
        /*
         * Insert this node after head as it was recently used
         */
        insertAfterHead(node);

        return val;
    }

    public void put(int key, int val) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key); // get the node

            node.value = val;

            deleteNode(node);

            /*
             * Insert this node after head as it was recently used
             */
            insertAfterHead(node);

            return;
        } else {
            // check if the capacity limit is reached
            if (keyNodeMap.size() == capacity) {

                /*
                 * Get the least recently used node , which is the node before previous node
                 */
                Node node = tail.prev;

                // delete the node from the keyNode map
                keyNodeMap.remove(node.key);

                // delete the node from doubly linked list
                deleteNode(node);
            }

            // create a new node
            Node node = new Node(key, val);
            keyNodeMap.put(key, node);

            // insert in doubly linked list
            insertAfterHead(node);
        }

    }
}
