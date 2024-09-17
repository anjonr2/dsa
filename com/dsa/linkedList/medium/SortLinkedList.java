package com.dsa.linkedList.medium;

import com.dsa.linkedList.utils.ListNode;

public class SortLinkedList {
    public static ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null)
            temp.next = list1;
        if (list2 != null)
            temp.next = list2;
        return dummy.next;
    }

    public static ListNode sortLL(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;
        leftHead = sortLL(leftHead);
        rightHead = sortLL(rightHead);

        return mergeTwoList(leftHead, rightHead);
    }
}
