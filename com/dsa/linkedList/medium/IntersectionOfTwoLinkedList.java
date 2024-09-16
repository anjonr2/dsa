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

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;

            if (tempA == tempB)
                return tempA;

            if (tempA == null)
                tempA = headB;
            if (tempB == null)
                tempB = headA;
        }
        return null;
    }
}
