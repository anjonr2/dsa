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
}
