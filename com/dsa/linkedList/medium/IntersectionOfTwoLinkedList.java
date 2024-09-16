package com.dsa.linkedList.medium;

import java.util.HashMap;
import java.util.Map;

import com.dsa.linkedList.utils.ListNode;

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = headA;

        while (temp != null) {
            map.put(temp, 1);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
