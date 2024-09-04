package com.dsa.linkedList.medium;

import com.dsa.linkedList.utils.ListNode;

public class DeleteNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        if (cnt == n) {
            return head.next;
        }
        int res = cnt - n;
        temp = head;
        while (temp != null) {
            res--;
            if (res == 0)
                break;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
