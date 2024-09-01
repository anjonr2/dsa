import java.util.ArrayList;
import java.util.List;

import com.dsa.linkedList.utils.ListNode;

public class SegregateOddEvenNodes {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null && temp.next != null) {
            list.add(temp.data);
            // go to the odd nodes only
            temp = temp.next.next;
        }
        // if odd length linked list add the last node data
        if (temp != null) {
            list.add(temp.data);
        }
        temp = head.next;
        while (temp != null && temp.next != null) {
            list.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) {
            list.add(temp.data);
        }

        temp = head;
        for (int i = 0; i < list.size(); i++) {
            while (temp != null) {
                temp.data = list.get(i);
            }
        }
        return head;
    }
}
