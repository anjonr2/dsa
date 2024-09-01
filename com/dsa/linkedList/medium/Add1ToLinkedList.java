import com.dsa.linkedList.utils.ListNode;

public class Add1ToLinkedList {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode addOne(ListNode head) {
        int carry = 1;
        head = reverse(head);
        ListNode temp = head;
        while (temp != null) {

            temp.data = temp.data + carry;
            if (temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }
        }
        if (carry == 1) {
            head = reverse(head);
            ListNode node = new ListNode(carry);
            node.next = head;
            return node;
        }
        return reverse(head);
    }
}
