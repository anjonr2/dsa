package com.dsa.linkedList.medium;

import java.util.ArrayList;
import java.util.List;

public class FindPairsWithGivenSUm {
    static class Pair {
        int num1;
        int num2;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }
    }

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private static Node findTail(Node head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static List<Pair> findPair(Node head, int sum) {
        Node left = head;
        Node right = findTail(head);
        List<Pair> res = new ArrayList<>();
        // since the doubly linked list is sorted
        while (left.data < right.data) {
            if (left.data + right.data == sum) {
                res.add(new Pair(left.data, right.data));
            } else if (left.data + right.data > sum) {
                right = right.prev;
            } else {
                left = left.next;
            }
        }
        return res;
    }
}
