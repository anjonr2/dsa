package com.problemsolving.stackandqueue.hard.LFUCache;

import java.util.HashMap;
import java.util.Map;

/*
To implement a node in a doubly linked list
that will store data items 
 */
class Node {
    int key, value, cnt;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        cnt = 1;
    }
}

// to implement a doubly linked list
class List {
    int size;
    Node head; // Dummy head
    Node tail; // Dummy tail

    List() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // Function to add node in front
    void addFront(Node node) {
        Node temp = head.next;
        node.next = temp;
        temp.prev = node;
        node.prev = head;
        head.next = node;
        size++;
    }

    // Function to remove node from the tail
    void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
}

// class to implement LFU cache
public class LFUCache {
    // Map to store Key-Node pairs
    Map<Integer, Node> keyNodeMap;

    /*
     * Hashmap to maintain lists having different frequencies
     */
    Map<Integer, List> freqListMap;

    private int maxSizeCache; // Max size of cache

    /*
     * Function to store least frequently used data items
     */
    private int leastFreq;

    /*
     * To store current size of the cache
     */
    private int currentSize;

    public LFUCache(int capacity) {
        this.maxSizeCache = capacity;
        this.currentSize = 0; // initialize current size to 0
        this.leastFreq = 0; // initialize leastFreq to 0
        keyNodeMap = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    // Method to update frequency of data-items
    private void updateFreqListMap(Node node) {
        // remove from key-node map
        keyNodeMap.remove(node.key);

        // Update the freq list hashMap
        freqListMap.get(node.cnt).removeNode(node);

        // if node was the last node having its frequency
        if (node.cnt == leastFreq && freqListMap.get(node.cnt).size == 0) {
            // Update the minimum frequency
            leastFreq += 1;
        }

        // creating a dummy node for next higher frequency
        List nextHigherFreqList = new List();

        // If there is already an existing list to next higher frequency
        if (freqListMap.containsKey(node.cnt + 1)) {
            // Update the pointer to already existing list
            nextHigherFreqList = freqListMap.get(node.cnt + 1);
        }

        // Increment the count of data item
        node.cnt += 1;

        // Add the node in front of higher frequencey list
        nextHigherFreqList.addFront(node);

        freqListMap.put(node.cnt, nextHigherFreqList);
        keyNodeMap.put(node.key, node);
    }

    public int get(int key) {
        // Return the value if key exists
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            int val = node.value;
            updateFreqListMap(node); // update the frequency listMap since this node is accessed now so it's
                                     // frequency will increment by 1
            return val;
        }
        return -1;
    }

    public void put(int key, int val) {
        /*
         * If the max capacity of the cache is 0,
         * no data items can be inserted
         */
        if (maxSizeCache == 0) {
            return;
        }

        /*
         * If the key already exists
         */
        if (keyNodeMap.containsKey(key)) {
            // Get the node from the key-node map
            Node node = keyNodeMap.get(key);

            // update the value
            node.value = val;

            // update the frequency list map
            updateFreqListMap(node);
        } else {
            if (currentSize == maxSizeCache) {

                // Remove the least frequently used data items
                List list = freqListMap.get(leastFreq);

                keyNodeMap.remove(list.tail.prev.key);

                // Update the frequency map. Remove from tail
                freqListMap.get(leastFreq).removeNode(list.tail.prev);

                currentSize--;
            }

            currentSize += 1;

            /*
             * Adding new value to the cache
             * set it's freq to 1
             */
            leastFreq = 1;

            List leastFreqList = new List();

            // if the list already exists in the map for leastFreq
            if (freqListMap.containsKey(leastFreq)) {
                leastFreqList = freqListMap.get(leastFreq);
            }

            // Create the node to store data-item
            Node node = new Node(key, val);

            // Add the node to the dummy list
            leastFreqList.addFront(node);

            // Add the node to the key-node hashMap
            keyNodeMap.put(key, node);

            // Update the freqList map
            freqListMap.put(leastFreq, leastFreqList);
        }
    }
}
