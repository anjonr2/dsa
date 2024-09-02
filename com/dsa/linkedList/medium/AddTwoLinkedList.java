import com.dsa.linkedList.utils.ListNode;

public class AddTwoLinkedList {
    public static ListNode addTwoLists(ListNode first, ListNode second) {
        ListNode list1 = first;
        ListNode list2 = second;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while (list1 != null || list2 != null) {
            int sum = carry;
            if (list1 != null)
                sum = sum + list1.data;
            if (list2 != null)
                sum = sum + list2.data;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            if (list1 != null)
                list1 = list1.next;
            if (list2 != null)
                list2 = list2.next;
        }
        if (carry == 1) {
            ListNode node = new ListNode(carry);
            curr.next = node;
        }
        return dummy.next;
    }
}
