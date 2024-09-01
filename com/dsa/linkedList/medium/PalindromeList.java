import java.util.Stack;

import com.dsa.linkedList.utils.ListNode;

public class PalindromeList {
    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (!stack.isEmpty() && stack.pop() != temp.data) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

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

    public static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;

        // find middle of the linked list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode first = head;
        ListNode second = newHead;
        while (second != null) {
            if (first.data != second.data) {
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }
}
